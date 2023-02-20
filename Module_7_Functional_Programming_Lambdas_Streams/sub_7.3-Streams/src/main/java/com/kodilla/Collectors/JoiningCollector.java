package com.kodilla.Collectors;

import com.kodilla.book.BookDirectoryExtended;
import java.util.stream.Collectors;
import com.kodilla.book.*;

public class JoiningCollector {

    public static void main(String[] args) {

        BookDirectoryExtended theBookDirectory = new BookDirectoryExtended();

        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(bookExtended -> bookExtended.getYearOfPublication() > 2005)
                .map(BookExtended::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);
    }
}
