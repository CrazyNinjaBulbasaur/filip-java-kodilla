package com.kodilla.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> figures = new ArrayList<>();

    public ShapeCollector() {
    }

    public List<Shape> getFigures() {
        return figures;
    }


    /**
     * Metody z zadania
     *
     */

    public void addFigure(Shape shape){
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (figures.contains(shape)) {
            figures.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){

        return figures.get(n);
    }

    public StringBuilder showFigures(){
        StringBuilder text = new StringBuilder("Showing Figures stored in ShapeCollector:\n");
        for(Shape shape : figures){
            text.append(shape.toString() + "\n");
//            System.out.println(text);
        }
        return text;
    }
}
