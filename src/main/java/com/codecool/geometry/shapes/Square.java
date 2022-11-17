package com.codecool.geometry.shapes;

public class Square extends Shape {
    private final float a;

    public Square(float a) {
        this.a = a;
    }

    public float getA() {
        return a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                '}';
    }
}
