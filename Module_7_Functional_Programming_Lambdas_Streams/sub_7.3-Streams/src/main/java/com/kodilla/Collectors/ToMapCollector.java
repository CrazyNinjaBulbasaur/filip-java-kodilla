package com.kodilla.Collectors;

import com.kodilla.book.BookDirectoryExtended;
import com.kodilla.book.BookExtended;

import java.util.Map;
import java.util.stream.Collectors;

public class ToMapCollector {

    public static void main(String[] args) {
        BookDirectoryExtended theBookDirectory = new BookDirectoryExtended();

        Map<String, BookExtended> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(bookExtended -> bookExtended.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(BookExtended::getSignature, bookExtended -> bookExtended));             // [1]

        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]

        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
                .forEach(System.out::println);

        /**
         * W linii [1] używamy kolektora Collectors.toMap(Function keyMapper, Function valueMapper),
         * który za pomocą funkcji (wyrażenia lambda lub referencji do metody) keyMapper oblicza klucz (key) pary w mapie.
         *
         * Z kolei valueMapper jest analogiczną funkcją (wyrażeniem lambda lub referencją do metody)
         * zwracającą wartość obiektu (value) pary w mapie.
         *
         * W naszym kodzie:
         *  -klucze par Entry w mapie obliczane są funkcją, która wskazana jest przez referencję do metody Book::getSignature,
         *  -wartości par Entry w mapie obliczane są funkcją zapisaną przy pomocy
         *  wyrażenia lambda book -> book, czyli po prostu są obiektami przepisanymi ze strumienia.
         *
         * W linii [2] sprawdzamy rozmiar nowo powstałej mapy.
         *
         * W liniach [3]—[4] wyświetlamy zawartość mapy w formacie klucz: wartość.
         * Przy pomocy wyrażenia lambda konwertujemy typ Map.Entry na łańcuchy tekstowe,
         * a następnie wyświetlamy je w konsoli, posługując się metodą System.out::println.
         */
    }
}
