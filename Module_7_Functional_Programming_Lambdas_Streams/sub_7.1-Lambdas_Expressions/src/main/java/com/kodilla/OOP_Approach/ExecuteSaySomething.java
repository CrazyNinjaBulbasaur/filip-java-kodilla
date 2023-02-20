package com.kodilla.OOP_Approach;

import java.sql.SQLOutput;

public class ExecuteSaySomething implements Executor{

    @Override
    public void process() {
        System.out.println("ExecuteSaySomething class -> calling process(): \nThis is an example text");
    }
}
