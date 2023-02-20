package com.kodilla.person;

public class StreamsInCollections {

    public static void main(String[] args) {

        People.getList().stream()                         // [1]
                .forEach(System.out::println);                 // [2]
    }
}
