package com.kodilla.person;

public class TransformingCollections {

    public static void main(String[] args) {

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
