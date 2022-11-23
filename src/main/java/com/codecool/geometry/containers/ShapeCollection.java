package com.codecool.geometry.containers;

import com.codecool.geometry.shapes.*;
import com.codecool.geometry.utilities.TableBuilder;

import java.util.ArrayList;
import java.util.Comparator;

public class ShapeCollection {
    // Dependencies
    private final TableBuilder tableBuilder;

    // In-memory database for storing Shape objects
    private final ArrayList<Shape> shapes;

    public ShapeCollection() {
        this.tableBuilder = new TableBuilder();
        this.shapes = new ArrayList<>();
    }

    /**
     * Creates and adds a Shape object to the in memory collection
     * @param shapeChoice integer value of Shape choice (from menu)
     * @param parameters list of necessary parameters for corresponding Shape object creation
     */
    public void addShape(int shapeChoice, ArrayList<Integer> parameters) {
        Shape shape = null;
        int nextId = nextId();

        switch (shapeChoice)
        {
            case 1:
                shape = new Circle(parameters.get(0), nextId);
                break;
            case 2:
                shape = new Rectangle(parameters.get(0), parameters.get(1), nextId);
                break;
            case 3:
                shape = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2), nextId);
                break;
            case 4:
                shape = new Square(parameters.get(0), nextId);
                break;
            case 5:
                shape = new EquilateralTriangle(parameters.get(0), nextId);
                break;
            case 6:
                shape = new RegularPentagon(parameters.get(0), nextId);
                break;
        }

        shapes.add(shape);
    }

    /**
     * Returns the next ID, based on the in memory Shapes collection
     * @return the next ID number as integer
     */
    private int nextId() {
        if (shapes.size() == 0) {
            return 0;
        }

        int maxId = shapes.stream()
                .max(Comparator.comparing(Shape::getId))
                .get()
                .getId();

        return maxId + 1;
    }

    /**
     * Creates and returns a table, dynamic in width, with all the Shape objects, and their attributes
     * @return a dynamic width table as String
     */
    public String getShapesTable() { return tableBuilder.buildTable(shapes); }

    /**
     * Returns the Shape object, which has the largest perimeter value
     * @return Shape object
     */
    public Shape getLargestShapeByPerimeter() {
        return shapes.stream()
                .max(Comparator.comparing(Shape::calculatePerimeter))
                .orElseThrow();
    }

    /**
     * Returns the Shape object, which has the largest area value
     * @return Shape object
     */
    public Shape getLargestShapeByArea() {
        return shapes.stream()
                .max(Comparator.comparing(Shape::calculateArea))
                .orElseThrow();
    }
}
