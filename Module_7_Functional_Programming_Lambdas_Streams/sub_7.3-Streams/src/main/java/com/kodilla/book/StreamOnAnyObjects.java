package com.kodilla.book;

public class StreamOnAnyObjects {

    public static void main(String[] args) {

        BookDirectory theBookDirectory = new BookDirectory();

        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

    }
}
