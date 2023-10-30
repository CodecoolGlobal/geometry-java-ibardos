package com.codecool.geometry.shapes;

public class Square extends Shape {
    // Side
    private final float a;

    // Constructor
    public Square(int a, int id) {
        super(id);
        this.a = a;
    }

    // Methods
    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public String getData() {
        return "a= " + String.format("%.2f", a);
    }

    @Override
    public String toString() {
        return "Square: " + getData();
    }
}
