package com.codecool.geometry.shapes;

public class Triangle extends Shape {
    // Sides
    private final float a;
    private final float b;
    private final float c;

    // Semi-perimeter, for Area calculation with Heron's formula
    private final double s;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = (a + b + c) / 2;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public double getS() {
        return s;
    }

    @Override
    public double calculateArea() {
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", s=" + s +
                '}';
    }
}
