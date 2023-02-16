package com.kodilla.shape;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ShapeCollectorTestSuite {

    ShapeCollector sc;

    @BeforeEach
    void before(){
        sc = new ShapeCollector();
    }


    @Nested
    @DisplayName("Tests for adding a figure - ddFigure(Shape shape)")
    class TestAddingFigure {

        @DisplayName("Test will check if size of a list has been incremented after adding a new figure")
        @Test
        void testAddFigure() {
            //Given
            int size = sc.getFigures().size();
//            System.out.println(size);

            //When
            sc.addFigure(new Square(15));
            int expected = sc.getFigures().size();
//            System.out.println(size2);

            //Then
            assertFalse(expected == size);
        }
    }

    @Nested
    @DisplayName("Tests for removing a figure - removeFigure(Shape shape)")
    class TestRemovingFigure {

        @DisplayName("Test will check if size of a list has been decremented after removing a new figure")
        @Test
        void testRemoveFigure() {
            //Given
            sc.addFigure(new Square(15));
            int size = sc.getFigures().size();
//            System.out.println(size);

            //When
            sc.removeFigure(new Square(15));
            int expected = sc.getFigures().size();
//            System.out.println(size2);

            //Then
            assertFalse(expected == size);
        }
    }

    @Nested
    @DisplayName("Test for getting a figure - getFigure(int n)")
    class TestGetFigure {
        @DisplayName("Test will whether getFigure() returns a correct figure")
        @Test
        void testGetFigure() {
            //Given
            Shape figure = new Circle(20);
            sc.addFigure(figure);

            //When
            Shape retrievedShape = sc.getFigure(0);

            //Then
            assertEquals(figure, retrievedShape);
        }
    }

    @Nested
    @DisplayName("Test for displaying figures - showFigures()")
    class TestShowFigures {
        @DisplayName("Test will whether showFigures() returns desirable value")
        @Test
        void testShowFigure() {
            //Given
            Shape figure1 = new Circle(20);
            Shape figure2 = new Square(20);

            sc.addFigure(figure1);
            sc.addFigure(figure2);

            //When
            Shape figureAdded1 = new Circle(20);
            Shape figureAdded2 = new Square(20);

            StringBuilder expectedResult = new StringBuilder();
            expectedResult.append("Showing Figures stored in ShapeCollector:\n");
            expectedResult.append(figureAdded1 +"\n");
            expectedResult.append(figureAdded2 +"\n");

            //Then
            assertEquals(expectedResult.toString(), sc.showFigures().toString());
        }
    }
}
