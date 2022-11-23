package com.codecool.geometry.shapes;

public class EquilateralTriangle extends Shape {
    // Side
    private final float a;

    // Constructor
    public EquilateralTriangle(int a, int id) {
        super(id);
        this.a = a;
    }

    // Methods
    @Override
    public double calculateArea() {
        return a * a * Math.sqrt(3) / 4;
    }

    @Override
    public double calculatePerimeter() {
        return 3 * a;
    }

    @Override
    public String toString() {
        return "Equilateral Triangle: " +
                "a= " + String.format("%.2f", a);
    }
}
