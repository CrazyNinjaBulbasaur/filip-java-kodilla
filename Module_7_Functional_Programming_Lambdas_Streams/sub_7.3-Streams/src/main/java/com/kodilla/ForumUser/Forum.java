package com.kodilla.ForumUser;

import com.kodilla.book.BookExtended;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(1, "Mike1111", 'M',
                LocalDate.of(1990, 1, 1), 0 ));
        theForumUserList.add(new ForumUser(2, "Becky222", 'F',
                LocalDate.of(1991, 2, 2), 1 ));
        theForumUserList.add(new ForumUser(3, "Tyson333", 'M',
                LocalDate.of(1992, 3, 3), 3 ));
        theForumUserList.add(new ForumUser(4, "Alice444", 'F',
                LocalDate.of(1993, 4, 4), 0 ));
        theForumUserList.add(new ForumUser(5, "John555", 'M',
                LocalDate.of(1994, 5, 5), 5 ));
        theForumUserList.add(new ForumUser(6, "Mike666", 'M',
                LocalDate.of(1995, 6, 6), 0 ));
        theForumUserList.add(new ForumUser(7, "Emily777", 'F',
                LocalDate.of(2009, 7, 7), 6 ));
        theForumUserList.add(new ForumUser(8, "Tanya888", 'F',
                LocalDate.of(2007, 8, 8), 0 ));
        theForumUserList.add(new ForumUser(9, "Jacob999", 'M',
                LocalDate.of(2010, 9, 9), 9 ));
        theForumUserList.add(new ForumUser(10, "Barbarian10", 'M',
                LocalDate.of(2004, 10, 10), 0 ));

    }

    public List<ForumUser> getTheForumUserList() {
        return new ArrayList<>(theForumUserList);
    }
}
