package com.codecool.geometry.shapes;

public class RegularPentagon extends Shape {
    // Side
    private final float a;

    // Constructor
    public RegularPentagon(int a, int id) {
        super(id);
        this.a = a;
    }

    // Methods
    @Override
    public double calculateArea() {
        return a * a * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) / 4;
    }

    @Override
    public double calculatePerimeter() {
        return 5 * a;
    }

    @Override
    public String toString() {
        return "Regular Pentagon: " +
                "a= " + String.format("%.2f", a);
    }
}
