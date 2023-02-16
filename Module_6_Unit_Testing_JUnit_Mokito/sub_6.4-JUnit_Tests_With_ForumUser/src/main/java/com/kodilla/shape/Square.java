package com.kodilla.shape;

public class Square implements Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public double getField() {
        return side * side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return this.side == square.side;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(side);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
