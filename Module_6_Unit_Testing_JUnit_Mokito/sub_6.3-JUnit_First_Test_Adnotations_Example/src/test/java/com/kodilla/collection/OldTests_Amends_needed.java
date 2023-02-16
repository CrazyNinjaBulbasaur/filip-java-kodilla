package com.kodilla.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldTests_Amends_needed {

    /**
     * OddNumbersExterminator oNE = new OddNumbersExterminator();
     * ^^ should be put into GIVEN section.
     *
     * Considering that this code is repeated, it makes sense to create a field storing OddNumbersExterminator.
     *
     * Even better. Initialization can be put into @Before all
     * /

     /**
     *
     * import static org.junit.jupiter.api.Assertions.*;
     * add, so you can use static methods without Assertions class eg.
     *
     * Assertions.assertEquals(isListEmpty, result);
     *
     * will change into:
     *
     * assertEquals(isListEmpty, result);
     *
     */

    /**
     * testOddNumbersExterminatorEmptyList()
     *
     * part in Given doesn't make sense. The list will be always empty. In this case you can skip Given section.
     */


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
        //Given
        List<Integer> numbers = new ArrayList<>();
        boolean isListEmpty = numbers.isEmpty();

        //When
        OddNumbersExterminator oNE = new OddNumbersExterminator();
        boolean result = oNE.exterminate(new ArrayList<>()).isEmpty();

        //Then
        Assertions.assertEquals(isListEmpty, result);
//
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
        OddNumbersExterminator oNE = new OddNumbersExterminator();
        List<Integer> result = oNE.exterminate(numbers);

        //Then
        Assertions.assertEquals(true, expectedList.equals(result));
//        assertTrue
//        ssertEquals (expected, tesult)
    }
}
