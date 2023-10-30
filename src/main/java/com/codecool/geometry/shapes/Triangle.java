package com.codecool.geometry.shapes;

public class Triangle extends Shape {
    // Sides
    private final float a;
    private final float b;
    private final float c;

    // Semi-perimeter, for Area calculation with Heron's formula
    private final double s;

    // Constructor
    public Triangle(int a, int b, int c, int id) {
        super(id);
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = (a + b + c) / 2f;
    }

    // Methods
    @Override
    public double calculateArea() {
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String getData() {
        return "a= " + String.format("%.2f", a) +
                ", b= " + String.format("%.2f", b) +
                ", c= " + String.format("%.2f", c) +
                ", s= " + String.format("%.2f", s);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + getData();
    }
}
