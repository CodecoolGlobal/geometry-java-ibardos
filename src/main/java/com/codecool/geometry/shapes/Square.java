package com.codecool.geometry.shapes;

public class Square extends Shape {
    private final float a;

    public Square(int a, int id) {
        super(id);
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
        return "Square: " +
                "a= " + String.format("%.2f", a);
    }
}
