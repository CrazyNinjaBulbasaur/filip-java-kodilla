package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge sc = new SecondChallenge();

        try{
            System.out.println("In Try block");
            sc.probablyIWillThrowException(1,1);
        } catch (Exception e) {
            System.out.println("Exception occured\n" +
                    "Now in Catch block");
        }finally {
            System.out.println("Greetings Finally block");
        }

    }
}
