package com.codecool.geometry.utilities;

import com.codecool.geometry.shapes.Shape;

import java.util.ArrayList;
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

    // Methods
    /**
     * Stores logic to build a dynamic table of in memory stored shapes for console representation
     * @param shapes list of Shape objects that are stored in memory
     * @return a dynamic width table as String
     */
    public String buildTable(ArrayList<Shape> shapes) {
        StringBuilder table = new StringBuilder();

        // Determine the maximum lengths of table columns
        setTableColumnLengths(shapes);

        // Build a printable table: top line, header row, separator line, table data, bottom line
        // Top line
        table.append(createTopLine());

        // Header row
        table.append(createHeaderRow());

        // Table data (separator line embedded)
        table.append(createTableData(shapes));

        // Bottom line
        table.append(createBottomLine());

        return table.toString();
    }

}
