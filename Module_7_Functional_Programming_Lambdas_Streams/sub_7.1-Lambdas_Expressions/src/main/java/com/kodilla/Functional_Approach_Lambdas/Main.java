package com.kodilla.Functional_Approach_Lambdas;

import com.kodilla.OOP_Approach.*;
public class Main {

    /**
     * W Javie mamy możliwość zastosowania metod anonimowych -> czyli wyrażeń lambda.
     *
     * Metoda anonimowa to meroda która nie ma nazwy i nie jest związana z żadną klasą.
     */

    /**
     * Wyrażenia lambda z chwilą przekazania do metody oczekującej argumentu
     * typu interfejsowego stają się anonimowymi obiektami implementującymi ten interfejs.
     * Metoda, do której wyrażenie lambda zostało przekazane, wywołuje na otrzymanym obiekcie tę metodę.
     *
     * Zawsze gdy chcemy przekazywać do metody wyrażenia lambda,
     * to metoda ta musi oczekiwać argumentu typu interfejsowego.
     * Interfejs musi natomiast mieć TYLKO jedną metodę.
     * Implementacją tej właśnie metody stanie się otrzymane wyrażenie lambda.
     *
     */

    public static void main(String[] args) {

        /**
         * Importing classes and interface from another package
         */
        Processor processor = new Processor();

        Executor codeToExecute = () -> System.out.println("Functional Approach. This is an example text.");

        processor.execute(codeToExecute);
        System.out.println();


        /**
         * No Variable needed in functional approach. You can simply pass Lambda as a parameter.
         */

        processor.execute( () -> System.out.println("No Variable needed in functional approach. " +
                                                    "You can simply pass Lambda as a parameter. ") );
    }
}
