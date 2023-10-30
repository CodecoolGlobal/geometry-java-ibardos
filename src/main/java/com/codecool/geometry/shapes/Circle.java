package com.codecool.geometry.shapes;

import static java.lang.Math.PI;

public class Circle extends Shape {
    // Radius
    private final float r;

    // Constructor
    public Circle(int r, int id) {
        super(id);
        this.r = r;
    }

    // Methods
    @Override
    public double calculateArea() {
        return PI * r * r;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * r;
    }

    @Override
    public String getData() {
        return "r= " + String.format("%.2f", r);
    }

    @Override
    public String toString() {
        return  "Circle: " + getData();
    }
}
