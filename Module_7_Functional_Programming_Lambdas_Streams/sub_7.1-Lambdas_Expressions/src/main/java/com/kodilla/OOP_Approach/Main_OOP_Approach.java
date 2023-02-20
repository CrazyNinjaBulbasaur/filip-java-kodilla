package com.kodilla.OOP_Approach;

public class Main_OOP_Approach {
    public static void main(String[] args) {

        SaySomething saySomething = new SaySomething();
        saySomething.say();

        new SaySomething().say();




        Processor processor = new Processor();                                // [6]
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();  // [7]
        processor.execute(executeSaySomething);

        /**
         * Zauważ ważną rzecz, która się właśnie wydarzyła –
         * do klasy Processor przekazaliśmy nie tylko tekst do wyświetlenia.
         * Przekazaliśmy również kod, który ma być wykonany
         * (w postaci implementacji metody execute() obiektu typu ExecuteSaySomething).
         *
         * W ten sposób zyskaliśmy cenną możliwość –
         * oprócz danych możemy również przekazywać kod, który na tych danych operuje!
         */
    }
}
