package com.codecool.geometry.shapes;

public class Rectangle extends Shape {
    // Sides
    private final float a;
    private final float b;

    // Constructor
    public Rectangle(int a, int b, int id) {
        super(id);
        this.a = a;
        this.b = b;
    }

    // Methods
    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    public String getData() {
        return "a= " + String.format("%.2f", a) + ", b= " + String.format("%.2f", b);
    }

    @Override
    public String toString() {
        return "Rectangle: " + getData();
    }
}
