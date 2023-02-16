package com.kodilla.calculator;

public class CalculatorUnitTesting {

    public static void calculatorAddMethodUnitTest(int expectedValue, int a, int b){
        System.out.println("Testing 'Add' method from Calculator class");
        Calculator c = new Calculator();

        if(expectedValue == c.add(a,b)){
            System.out.println("Test OK");
        } else {
            System.out.println("Error");
        }
    }

    public static void calculatorSubtractMethodUnitTest(int expectedValue, int a, int b){
        System.out.println("Testing 'Subtract' method from Calculator class");
        Calculator c = new Calculator();

        if(expectedValue == c.subtract(a,b)){
            System.out.println("Test OK");
        } else {
            System.out.println("Error");
        }
    }

    /**
     *
     * W testach najlepiej wpisywać dane do sprawdzenia na sztywno.
     * Staramy sie unikać generowania wartości używanej przez kod / metodę / funkcjonalność który poźniej sprawdzamy.
     * (przykładowo jeśli używamy pętli która jest zepsuta,
     * wówczas test będzie zgodny czyli będzie podwójnie błędny)
     */
//    public static void calculatorAddMethodUnitTest(int a, int b){
//        System.out.println("Testing 'Add' method from Calculator class");
//        Calculator c = new Calculator();
//
//        if(a + b == c.add(a,b)){
//            System.out.println("Test OK");
//        } else {
//            System.out.println("Error");
//        }
//    }
//
//    public static void calculatorSubtractMethodUnitTest(int a, int b){
//        System.out.println("Testing 'Subtract' method from Calculator class");
//        Calculator c = new Calculator();
//
//        if(a - b == c.subtract(a,b)){
//            System.out.println("Test OK");
//        } else {
//            System.out.println("Error");
//        }
//    }
}
