package Book;

import com.kodilla.book.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTestSuite {

    @Test
    void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for (Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size()) // [1]
                .filter(n -> books.get(n).getYearOfPublication() > 2007)             // [2]
                .map(n -> 1)                                                         // [3]
                .sum();                                                              // [4]

        assertEquals(3, numberOfBooksPublicatedAfter2007);                      // [5]
/**
 * W linii [1] tworzymy i uruchamiamy strumień elementów typu int o zakresach numerów od 0 do books.size().
 * Wynik działania tego strumienia, po jego zakończeniu, zostanie przypisany do zmiennej numberOfBooksPublicatedAfter2007.
 *
 * W linii [2] odfiltrowujemy tylko te książki, których rok wydania jest większy od 2007.
 * Realizujemy to przy pomocy wyrażenia lambda, które otrzymuje na wejściu kolejną wartość indeksu n.
 * Do strumienia wyjściowego filtra kierowane są jedynie numery indeksów (nie książki!) odpowiadające książkom
 * wydanym po roku 2007. Sprawdzamy to przy pomocy warunku books.get(n).getYearOfPublication() > 2007.
 *
 * W linii [3] na wejściu otrzymujemy strumień liczb typu int, które są numerami indeksów książek
 * wydanych po 2007 roku w kolekcji books. Każdy taki indeks odpowiada jednej książce do "zliczenia".
 * Dokonujemy więc transformacji strumienia w taki sposób, że do strumienia wyjściowego trafia liczba 1
 * w miejsce każdego elementu strumienia do zliczenia
 *
 * W linii [4] zliczamy liczbę "jedynek" w strumieniu wejściowym. Odpowiada ona liczbie książek
 * wydanych po roku 2007 w kolekcji.
  */
    }

    @Test
    void testGetListUsingIntStreamWithCountMethod() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();

        assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}
