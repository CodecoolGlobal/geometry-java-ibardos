package com.codecool.geometry.shapes;

/**
 * This is an abstract class representing geometrical shape.
 */
public abstract class Shape {
    private final int id;

    // Constructor
    public Shape(int id) {
        this.id = id;
    }

    // Getter
    public int getId() {
        return id;
    }

    // Abstract methods
    /**
     * Calculates shape's area.
     * @return area of the shape
     */
    public abstract double calculateArea();

    /**
     * Calculates shape's perimeter.
     * @return perimeter of the shape
     */
    public abstract double calculatePerimeter();

    /**
     * Returns a formatted String literal with data stored in private inner fields.
     * @return String of data from the particular object.
     */
    public abstract String getData();
}
