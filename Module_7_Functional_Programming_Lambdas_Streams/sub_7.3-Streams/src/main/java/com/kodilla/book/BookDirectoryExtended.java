package com.kodilla.book;

import java.util.ArrayList;
import java.util.List;

public final class BookDirectoryExtended {

    private final List<BookExtended> theBookList = new ArrayList<>();

    public BookDirectoryExtended() {
        theBookList.add(new BookExtended("Dylan Murphy", "Wolf of the mountain",
                2003, "0001"));
        theBookList.add(new BookExtended("Phoebe Pearson", "Slaves of dreams",
                2012, "0002"));
        theBookList.add(new BookExtended("Morgan Walsh", "Obliteration of heaven",
                2001, "0003"));
        theBookList.add(new BookExtended("Aimee Murphy", "Rejecting the night",
                2015, "0004"));
        theBookList.add(new BookExtended("Ryan Talley", "Gangsters and kings",
                2007, "0005"));
        theBookList.add(new BookExtended("Madelynn Carson", "Unity without duty",
                2007, "0006"));
        theBookList.add(new BookExtended("Giancarlo Guerrero", "Enemies of eternity",
                2009, "0007"));
    }

    public List<BookExtended> getList() {
        return new ArrayList<>(theBookList);
    }
}
