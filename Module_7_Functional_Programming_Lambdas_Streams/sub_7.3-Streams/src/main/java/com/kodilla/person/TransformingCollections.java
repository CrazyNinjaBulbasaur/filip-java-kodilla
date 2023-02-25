package com.kodilla.person;

public class TransformingCollections {

    public static void main(String[] args) {

        /**
         * Dla każdego obiektu typu String zapisanego w kolekcji zwróconej przez People.getList(),
         * podane w metodzie .map() wyrażenie lambda wywołuje jego metodę toUpperCase()
         * (jest to metoda udostępniana przez klasę String),
         * która zwraca tekst zawarty w obiekcie zmodyfikowany w taki sposób, że jest on w całości zapisany dużymi literami.
         */

        /**
         * Lambdas
         */
        People.getList().stream()
                .map(s -> s.toUpperCase())                      // [1]
                .forEach(s -> System.out.println(s));
        System.out.println();

        /**
         * Method references
         */
        People.getList().stream()
                .map(String::toUpperCase)                      // [1]
                .forEach(System.out::println);
        System.out.println();

        /**
         * Lambdas & method reference
         */
        People.getList().stream()
                .map(s -> s.toUpperCase())                      // [1]
                .forEach(System.out::println);
        System.out.println();

        /**
         * Method reference & lambdas
         */
        People.getList().stream()
                .map(String::toUpperCase)                      // [1]
                .forEach(s -> System.out.println(s));          // [2]
        System.out.println();
    }

}
