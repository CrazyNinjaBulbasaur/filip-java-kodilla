package com.kodilla.person;

public class FilteringCollections {

    public static void main(String[] args) {

        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);
    }
}
