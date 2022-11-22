package com.codecool.geometry.shapes;

public class Rectangle extends Shape {
    private final float a;
    private final float b;

    public Rectangle(int a, int b, int id) {
        super(id);
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    public String toString() {
        return "Rectangle: " +
                "a= " + String.format("%.2f", a) +
                ", b= " + String.format("%.2f", b);
    }
}
