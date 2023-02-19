package com.kodilla.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();

        if (titleFragment.length() < 3) return bookList;

        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);

        if (resultList.size() > 20) return bookList;

        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser){
//        Code for testing

//        List<Book> bookList = new ArrayList<>();
//        bookList.add(new Book("Long Title", "Short Author", 2015));
//
//        return bookList;

        return libraryDatabase.listBooksInHandsOf(libraryUser);

    }
}
