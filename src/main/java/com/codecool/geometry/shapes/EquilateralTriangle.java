package com.codecool.geometry.shapes;

public class EquilateralTriangle extends Shape {
    private final float a;

    public EquilateralTriangle(int a, int id) {
        super(id);
        this.a = a;
    }

    public float getA() {
        return a;
    }

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
        return "EquilateralTriangle{" +
                "a=" + a +
                '}';
    }
}
