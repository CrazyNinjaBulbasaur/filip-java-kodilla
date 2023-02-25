package com.kodilla.person;

import java.util.ArrayList;
import java.util.List;

public final class People {

    public static List<String> getList() {                // [5]
        final List<String> theList = new ArrayList<>();    // [6]

        theList.add("John Smith");                         // [7]
        theList.add("Dorothy Newman");                     // [8]
        theList.add("John Wolkowitz");                     // [9]
        theList.add("Lucy Riley");                         // [10]
        theList.add("Owen Rogers");                        // [11]
        theList.add("Matilda Davies");                     // [12]
        theList.add("Declan Booth");                       // [13]
        theList.add("Corinne Foster");                     // [14]
        theList.add("Khloe fry");                          // [15]
        theList.add("Martin Valenzuela");                  // [16]

        return new ArrayList<>(theList);                   // [17]

        /**
         * W linii [17] zwracamy nie listę przechowywaną w zmiennej theList,
         * lecz tworzymy jej kopię (czyli tworzymy nową listę przy pomocy konstruktora kopiującego) –
         * jest to rozwiązanie zapobiegające mutowaniu obiektów.
         *
         * Nawet jeżeli "konsument" wyników działania metody getList() zmieni coś w otrzymanej kolekcji,
         * nie spowoduje to zmiany obiektów wewnątrz klasy People,
         * ponieważ operacja modyfikacji zostanie wykonana na kopii obiektu theList, a nie na samym obiekcie.
         */
    }
}
