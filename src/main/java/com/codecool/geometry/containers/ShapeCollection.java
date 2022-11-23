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

}
