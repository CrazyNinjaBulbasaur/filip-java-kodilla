package library;

import com.kodilla.library.Book;
import com.kodilla.library.BookLibrary;
import com.kodilla.library.LibraryDatabase;
import com.kodilla.library.LibraryUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private BookLibrary bookLibrary;

    @BeforeEach
    public void before(){
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    private static List<LibraryUser> libraryUsers = new ArrayList<>();

    @BeforeAll
    public static void init() {
        libraryUsers.add(new LibraryUser("Johny", "Deep", "5562"));
        libraryUsers.add(new LibraryUser("Emily", "Grey", "6969"));
        libraryUsers.add(new LibraryUser("Bulbi", "The Mighty", "9999"));
    }

    @DisplayName("ten test sprawdzi, czy lista książek spełniających warunek wyszukiwania jest poprawnie zwracana.")
    @Test
    void testListBooksWithConditionsReturnList() {
        // Given
//        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [3]
        List<Book> resultListOfBooks = new ArrayList<>();                                // [4]
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
        resultListOfBooks.add(book1);                                                    // [9]
        resultListOfBooks.add(book2);                                                    // [10]
        resultListOfBooks.add(book3);                                                    // [11]
        resultListOfBooks.add(book4);                                                    // [12]
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);// [13]

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");        // [14]

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @DisplayName("ten test posłuży do sprawdzenia, czy metoda listBooksWithCondition(String titleFragment) zachowuje się poprawnie, " +
            "gdy liczba tytułów pasujących do wzorca jest większa niż 20. " +
            "W tej sytuacji zwracana powinna być pusta lista.")
    @Test
    void testListBooksWithConditionMoreThan20() {
        // Given
//        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [1]
        List<Book> resultListOf0Books = new ArrayList<>();                           // [2]
        List<Book> resultListOf15Books = generateListOfNBooks(15);                       // [3]
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        // [4]
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))                    // [5]
                .thenReturn(resultListOf15Books);                                             // [6]
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))                    // [7]
                .thenReturn(resultListOf0Books);                                              // [8]
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))                   // [9]
                .thenReturn(resultListOf40Books);                                             // [10]

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");    // [11]
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");   // [12]
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");  // [13]
        // Then

        assertEquals(0, theListOfBooks0.size());                                         // [14]
        assertEquals(15, theListOfBooks15.size());                                       // [15]
        assertEquals(0, theListOfBooks40.size());
    }

    @DisplayName("Ten test z kolei ma za zadanie sprawdzenie, " +
            "czy zwracana lista książek jest pusta w sytuacji, " +
            "gdy wyszukiwany fragment tytułu jest krótszy niż trzy znaki.")
    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
//        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
//        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]
//         bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

        // Then
        assertEquals(0, theListOfBooks10.size());                                     // [5]
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());    // [6]
    }

    @DisplayName("The test will check whether testListBooksInHandsOf() from BookLibrary class" +
            "returns List with a correct number of Books. In this test - 0")
    @Test
    void testListBooksInHandsReturnListOf0(){
        // Given
        List<Book> resultListOf0Books = generateListOfNBooks(0);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(0))).thenReturn(resultListOf0Books);

        // When
        List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(libraryUsers.get(0));

        // Then
        assertEquals(0, theListOf0Books.size());

    }

    @DisplayName("The test will check whether testListBooksInHandsOf() from BookLibrary class" +
            "returns List with a correct number of Books. In this test - 1")
    @Test
    void testListBooksInHandsReturnListOf1(){
        // Given
        List<Book> resultListOf1Books = generateListOfNBooks(1);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(1))).thenReturn(resultListOf1Books);

        // When
        List<Book> theListOf1Books = bookLibrary.listBooksInHandsOf(libraryUsers.get(1));

        // Then
        assertEquals(1, theListOf1Books.size());
    }

    @DisplayName("The test will check whether testListBooksInHandsOf() from BookLibrary class" +
            "returns List with a correct number of Books. In this test - 5")
    @Test
    void testListBooksInHandsReturnListOf5(){
        // Given
        List<Book> resultListOf5Books = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(2))).thenReturn(resultListOf5Books);

        // When
        List<Book> theListOf5Books = bookLibrary.listBooksInHandsOf(libraryUsers.get(2));

        // Then
        assertEquals(5, theListOf5Books.size());
    }


    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
