package portfolio;

import com.kodilla.portfolio.Board;
import com.kodilla.portfolio.Task;
import com.kodilla.portfolio.TaskList;
import com.kodilla.portfolio.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void testAddTaskListAverageWorkingOnTask(){
        //Given
        Board project = prepareTestData();

        //When
        double averageOfDays = project.getTaskLists().stream()
                .filter(taskList -> taskList.getName().equals("In progress"))
                .flatMap(taskList -> taskList.getTasks().stream())
                .map(task -> (double) task.getCreated().until(LocalDate.now(), ChronoUnit.DAYS))
                .collect(Collectors.averagingDouble(days -> days));

        //Then
        assertEquals(10.0 , averageOfDays);

    }

    @Test
    void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        assertEquals(3, project.getTaskLists().size());
    }

    @Test
    void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");     // [1]
        List<Task> tasks = project.getTaskLists().stream()    // [2]
                .flatMap(l -> l.getTasks().stream())               // [3]
                .filter(t -> t.getAssignedUser().equals(user))     // [4]
                .collect(toList());                                // [5]

        //Then
        assertEquals(2, tasks.size());
        assertEquals(user, tasks.get(0).getAssignedUser());
        assertEquals(user, tasks.get(1).getAssignedUser());
    }

    /**
     * W linii [1] tworzymy obiekt klasy User, który będzie posiadał pole username wypełnione tekstem "developer1"
     * – metoda equals(Object o) porównuje właśnie to pole, więc taki użytkownik testowy jest nam potrzebny,
     * aby go odnaleźć w zadaniach.
     *
     * W linii [2] uruchamiamy strumień na kolekcji getTaskLists() obiektu Board.
     * Wynik działania strumienia po jego zakończeniu zostanie przypisany do kolekcji tasks będącej listą zadań typu Task.
     *
     * W linii [3] spłaszczamy strumień – na wejściu mamy strumień list zadań,
     * chcemy uzyskać strumień zadań (a nie listę zadań), wobec czego do strumienia wyjściowego przekazujemy
     * listy zadań z poszczególnych list, spłaszczając strumień przy pomocy flatMap().
     *
     * W linii [4] filtrujemy strumień (w strumieniu wejściowym są zadania typu Task) przy pomocy wyrażenia lambda
     * t -> t.getAssignedUser().equals(user)
     * zwracającego true lub false w zależności od tego, czy użytkownicy są sobie równi
     * (w sensie równości pola username – bo tak sprawdza to metoda equals(Object o) – klasy User).
     * Do strumienia wyjściowego trafią więc tylko te zadania, które mają przypisanego użytkownika "developer1".
     *
     * W linii [5] tworzymy kolekcję wynikową przy pomocy kolektora collect(),
     * kolekcja ta przypisywana jest do zmiennej tasks.
     *
     * Asercja w linii [6] sprawdza, czy znaleziono dokładnie dwa takie zadania.
     *
     * Asercje w liniach [7]—[8] sprawdzają, czy na pewno w obu tych zadaniach przypisanym użytkownikiem jest "developer1".
     */


    @Test
    void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();             // [1]
        undoneTasks.add(new TaskList("To do"));                     // [2]
        undoneTasks.add(new TaskList("In progress"));               // [3]
        List<Task> tasks = project.getTaskLists().stream()          // [4]
                .filter(undoneTasks::contains)                           // [5]
                .flatMap(tl -> tl.getTasks().stream())                   // [6]
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))  // [7]
                .collect(toList());                                      // [8]

        //Then
        assertEquals(1, tasks.size());                              // [9]
        assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    /**
W liniach [1]—[3] tworzymy roboczą listę "list zadań" o nazwie undoneTasks – przypisujemy do niej dwie puste listy zadań
     o nazwach zgodnych z nazwami list, w których przechowujemy niewykonane zadania.
     Metoda equals(Object o) klasy TaskList porównuje właśnie nazwy list, aby stwierdzić, czy to ta sama lista.

W linii [4] tworzymy i uruchamiamy strumień na kolekcji project.getTaskLists() klasy Board.
     Po zakończeniu działania strumienia, jego kolekcja wynikowa zostanie przypisana do zmiennej tasks.

W linii [5] dokonujemy odfiltrowania tylko tych list zadań, które zawierają niewykonane zadania.
     Wiemy, że są to listy "To Do" oraz "In Progress". Mamy takie listy zapisane w kolekcji undoneTasks.
     Wskazujemy więc referencję do metody - undoneTasks::contains – jako parametr zostanie przekazana
     każda kolejna lista zadań zwracana przez metodę getTaskLists() klasy Board.
     Do strumienia wyjściowego trafią jedynie te listy, które zapisane są w roboczej liście undoneTasks.

W linii [6] dokonujemy spłaszczenia strumienia w taki sposób, że do strumienia wyjściowego trafią już konkretne zadania
     z list zadań, zamiast obiektów reprezentujących te listy.

W linii [7] sprawdzamy dla każdego zadania czy jego data pobrana metodą getDeadline() nie jest wcześniejsza
     niż bieżąca data systemowa. Do tego celu wykorzystujemy metodę isBefore(LocalDate date) klasy LocalDate –
     zwraca ona true, gdy data zapisana w obiekcie, którego metodę wywołujemy, jest wcześniejsza niż data
     zapisana w obiekcie podanym jako argument. Do strumienia wyjściowego trafią jedynie te zadania,
     których data realizacji upłynęła.

W linii [8] generujemy kolekcję wynikową przy pomocy kolektora collect() –
     kolekcja ta zawiera przeterminowane zadania i jest wstawiana do zmiennej tasks.

Asercja w linii [9] sprawdza, czy znaleziono dokładnie jedno przeterminowane zadanie.

Asercja w linii [10] porównuje, czy znalezione zadanie jest rzeczywiście tym przeterminowanym.
*/

    @Test
    void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();               // [1]
        inProgressTasks.add(new TaskList("In progress"));                 // [2]
        long longTasks = project.getTaskLists().stream()                  // [3]
                .filter(inProgressTasks::contains)                             // [4]
                .flatMap(tl -> tl.getTasks().stream())                         // [5]
                .map(Task::getCreated)                                         // [6]
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)  // [7]
                .count();                                                      // [8]

        //Then
        assertEquals(2, longTasks);                                       // [9]
    }

    /**
W liniach [1]—[2] tworzona jest robocza lista inProgressTasks, zawierająca listy zadań,
     które są w trakcie realizacji (jedna lista o nazwie "In Progress").

W linii [3] uruchamiany jest strumień na kolekcji getTaskLists() klasy Board.
     Wynik jego realizacji będzie po wykonaniu przypisany do skalarnej zmiennej longTasks typu long.

Wlinii [4] odfiltrowywana jest lista zawierająca zadania w trakcie realizacji.

W linii [5] dokonujemy spłaszczenia strumienia. Z list zadań przechodzimy na konkretne zadania zawarte w listach.

W linii [6] wykonujemy transformację strumienia. Z wejściowego strumienia zadań przekształcamy go
     w strumień dat typu LocalDate informujących o tym, kiedy zadanie zostało utworzone.

W linii [7] wykorzystujemy metodę compareTo(LocalDate date) klasy LocalDate,
     aby sprawdzić czy różnica pomiędzy datą utworzenia zadania a bieżącą datą systemową
     (pomniejszoną o 10 dni przy pomocy metody minusDays(long days)) jest mniejsza od zera,
     równa zeru lub większa od zera. Metoda compareTo(LocalDate date) zwraca wartości:
     -1, gdy data jest mniejsza, 0, gdy daty są równe lub 1, gdy data jest większa.
     Do strumienia wyjściowego trafią tylko te daty, które są starsze (lub równe) niż 10 dni wcześniej
     – przed bieżącą datą.

W linii [8] zliczamy liczbę elementów w strumieniu przy pomocy kolektora skalarnego count(),
     który zwraca liczbę elementów w strumieniu.

Asercja w linii [9] sprawdza, czy znaleziono dokładnie dwa takie zadania.

*/

    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));

        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));

        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));

        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));

        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));

        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);

        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);

        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);

        return project;
    }
}
