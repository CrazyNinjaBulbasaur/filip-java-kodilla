package sand;

import com.kodilla.sand.Africa;
import com.kodilla.sand.Asia;
import com.kodilla.sand.Europe;
import com.kodilla.sand.SandStorage;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandStorageTestSuite {

    @Test
    void testGetSandBeansQuantity() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = BigDecimal.ZERO;

        for (SandStorage continent : continents) {
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        assertEquals(expectedSand, totalSand);
    }

    @Test
    void testGetSandBeansQuantityWithReduce() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = continents.stream()                              // [1]
                .map(SandStorage::getSandBeansQuantity)                              // [2]
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));  // [3]

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");      // [4]
        assertEquals(expectedSand, totalSand);                                  // [5]
    }

    /**
     * W linii [1] uruchamiamy strumień na kolekcji continents,
     * wynik jego działania przypiszemy do zmiennej totalSand typu BigDecimal.
     *
     * Linia [2] zmienia obiekty w strumieniu z klas reprezentujących kontynenty - na liczby typu BigDecimal,
     * odpowiadające ilościom ziaren piasku na poszczególnych kontynentach.
     *
     * W linii [3] wywołujemy kolektor skalarny reduce(identity, BinaryOperator accumulator),
     * który jako wartość początkową otrzymuje BigDecimal.ZERO,
     * a następnie dla każdej liczby w kolekcji wykonuje wyrażenie lambda
     *
     * (sum, current) -> sum = sum.add(current),
     *
     * gdzie sum jest wynikiem pośrednim uzyskanym dla poprzedniego obiektu w kolekcji
     * (na początku przy pierwszym elemencie jest to BigDecimal.ZERO, czyli wartość początkowa identity).
     * Wyrażenie lambda przypisuje do zmiennej sum nową wartość będącą sumą dotychczasowych obliczeń i wartości current,
     * reprezentującej bieżący obiekt w strumieniu.
     *
     * Po dokonaniu obliczenia – wartość ta będzie przekazana do "następnego przebiegu" kolektora jako nowa wartość pośrednia.
     * Na końcu – po zakończeniu działania kolektora – obliczona suma jest zwracana do zmiennej totalSand.
     *
     * Operacja reduce(identity, BinaryOperator accumulator) jest bardzo elastyczna.
     * Argument accumulator może być wyrażeniem lambda lub referencją do dwuargumentowej metody dowolnej klasy.
     */
}
