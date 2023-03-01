package com.kodilla.exception.exercise;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        //Given
        SecondChallenge sc = new SecondChallenge();

        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> sc.probablyIWillThrowException(0, 1)),
                () -> assertThrows(Exception.class, () -> sc.probablyIWillThrowException(2, 1)),
                () -> assertThrows(Exception.class, () -> sc.probablyIWillThrowException(3, 1)),

                () -> assertThrows(Exception.class, () -> sc.probablyIWillThrowException(1.5, 1.5)),

                () -> assertDoesNotThrow(() -> sc.probablyIWillThrowException(1, 1)),
                () -> assertDoesNotThrow(() -> sc.probablyIWillThrowException(1.5, 1)),
                () -> assertDoesNotThrow(() -> sc.probablyIWillThrowException(1.5, 1.6))
        );
    }
}
