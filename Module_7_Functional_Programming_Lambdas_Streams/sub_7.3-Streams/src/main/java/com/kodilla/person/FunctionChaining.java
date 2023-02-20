package com.kodilla.person;

public class FunctionChaining {
    public static void main(String[] args) {

        People.getList().stream()
                .map(String::toUpperCase)                             // [1]
                .filter(s -> s.length() > 11)                         // [2]
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")   // [3] Creates a substring from a method and then concatenate it with + "."
                .filter(s -> s.substring(0, 1).equals("M"))           // [4]
                .forEach(System.out::println);

        /**
         * W linii [1], wszystkie teksty w obiektach zamieniane są na teksty pisane wielkimi literami
         * poprzez wywołanie dla każdego obiektu kodu, wskazanego referencją do metody toUpperCase() klasy String.
         *
         * W linii [2], przy pomocy wyrażenia lambda odfiltrowane zostają jedynie te teksty,
         * których długość jest większa od 11 znaków.
         *
         * W linii [3], teksty obiektów zastępowane są nowymi.
         * Ze starego tekstu pobierane są znaki od początku napisu do spacji
         * (plus dwa znaki – sama spacja oraz pierwsza litera nazwiska), a na końcu dodawana jest kropka,
         *
         * W linii [4], odfiltrowane zostają jedynie te obiekty, których pierwszą literą imienia jest litera M.
         *
         * W linii [5], obiekty ze strumienia wynikowego są wyświetlane na ekranie konsoli
         * przy pomocy kolektora forEach() z referencją do metody System.out::println.
         */
    }
}
