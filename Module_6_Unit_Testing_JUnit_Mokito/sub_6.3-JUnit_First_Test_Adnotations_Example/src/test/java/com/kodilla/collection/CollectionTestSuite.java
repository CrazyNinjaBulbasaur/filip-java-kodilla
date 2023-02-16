package com.kodilla.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTestSuite {

    static OddNumbersExterminator oNE;

    @BeforeEach
    public void before() {
        System.out.print("Testing begins for: ");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        oNE = new OddNumbersExterminator();
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {

        System.out.println("Test Suite: end");
    }

    @DisplayName("When list is empty, " +
            "then exterminate() should return empty list "
    )
    @Test
    void testOddNumbersExterminatorEmptyList () {
        System.out.println("testOddNumbersExterminatorEmptyList");

        //When
        List<Integer> result = oNE.exterminate(new ArrayList<>());

        //Then
        assertTrue(result.isEmpty());
    }

    @DisplayName("When list is not empty, " +
            "then exterminate() should return list of even numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList () {
        System.out.println("testOddNumbersExterminatorNormalList");

        //Given
        List<Integer> numbers = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        List<Integer> expectedList = Arrays.asList(10, 8, 6, 4, 2, 0);

        //When
        List<Integer> result = oNE.exterminate(numbers);

        //Then
        assertTrue(expectedList.equals(result));
    }
}
