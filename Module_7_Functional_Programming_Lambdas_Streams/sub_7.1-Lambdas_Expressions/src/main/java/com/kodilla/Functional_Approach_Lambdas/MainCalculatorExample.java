package com.kodilla.Functional_Approach_Lambdas;

public class MainCalculatorExample {

    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]


        /**
         * Wyrażenie to przyjmuje dwa argumenty: a oraz b.
         *
         * Nie podajemy typu argumentów – kompilator sam sprawdzi,
         * jaki jest ich typ (analogicznie do sytuacji, gdy nie podajemy typu zwracanego).
         * Następnie wyrażenie oblicza sumę tych elementów i ją zwraca
         * (w jednoliniowych wyrażeniach lambda pomijamy słowo return).
         *
         * Zauważ, że nie musieliśmy tworzyć klas implementujących w różny sposób
         * metody calculateExpression(double a, double b) interfejsu MathExpression.
         */
        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);           // [9]


        /**
         * Method References
         */

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
    }
}
