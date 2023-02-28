package com.kodilla.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    public static double getAverage(int[] numbers){
        System.out.println("Size of an array: " + numbers.length);
        IntStream.range(0, numbers.length)
                .forEach(n -> System.out.println(numbers[n]));


        return IntStream.range(0, numbers.length)
                .mapToDouble(n -> numbers[n])
                .average().getAsDouble();
    }
}
