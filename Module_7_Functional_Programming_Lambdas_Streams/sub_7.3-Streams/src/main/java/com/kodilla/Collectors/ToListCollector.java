package com.kodilla.Collectors;

import com.kodilla.book.Book;
import com.kodilla.book.BookDirectory;

import java.util.List;
import java.util.stream.Collectors;

public class ToListCollector {

    public static void main(String[] args) {

        BookDirectory theBookDirectory = new BookDirectory();

        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()   // [1]
                .filter(book -> book.getYearOfPublication() > 2005)                  // [2]
                .collect(Collectors.toList());                                       // [3]

        System.out.println("# elements: " + theResultListOfBooks.size());       // [4]
        theResultListOfBooks.stream()                                           // [5]
                .forEach(System.out::println);                                       // [6]
    }

}
