package com.kodilla;

import com.kodilla.user.SimpleUser;

import static com.kodilla.calculator.CalculatorUnitTesting.*;

public class TestingMain {
    public static void main(String[] args) {
        simpleUserUnitTest();

        calculatorAddMethodUnitTest(25,10, 15);
        calculatorSubtractMethodUnitTest(-5,10,15);


    }

    static void simpleUserUnitTest(){
        System.out.println("Testing SimpleUser ");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK\n");
        } else {
            System.out.println("Error!\n");
        }
    }
}