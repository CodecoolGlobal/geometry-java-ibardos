package com.codecool.geometry.utilities;

import java.util.HashMap;

/**
 * A class containing logic and necessary helper methods for building a dynamic width table about Shape objects
 */
public class TableBuilder {
    // Fields
    // Store column names
    private final String[] columnNames = {"ID", "Class", "toString", "Perimeter", "Perimeter formula", "Area", "Area formula"};

    // Store column names and their corresponding final lengths as key/value pairs
    private final HashMap<String, Integer> columnLengths = new HashMap<>();

}
