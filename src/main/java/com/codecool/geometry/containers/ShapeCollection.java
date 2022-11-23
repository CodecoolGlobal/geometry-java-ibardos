package com.codecool.geometry.containers;

import com.codecool.geometry.shapes.Circle;
import com.codecool.geometry.shapes.EquilateralTriangle;
import com.codecool.geometry.shapes.Rectangle;
import com.codecool.geometry.shapes.RegularPentagon;
import com.codecool.geometry.shapes.Shape;
import com.codecool.geometry.shapes.Square;
import com.codecool.geometry.shapes.Triangle;
import java.util.ArrayList;

public class ShapeCollection {
    // In-memory database for storing Shape objects
    private final ArrayList<Shape> shapes;
    public ShapeCollection() {
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

}
