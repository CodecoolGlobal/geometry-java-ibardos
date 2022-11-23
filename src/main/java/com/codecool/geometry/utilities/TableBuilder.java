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

    /**
     * Sets the length of each column in the table, based on header row and table data content, to achieve dynamic width
     * @param shapes collection of existing in memory Shape objects
     */
    private void setTableColumnLengths(ArrayList<Shape> shapes) {
        // Populate columnLengths HashMap with column names and corresponding lengths to have an initial dataset
        for (String columnName : columnNames) {
            columnLengths.put(columnName, columnName.length());
        }

        // Determine maximum column lengths and update HashMap (ID column already covered)
        for (Shape shape : shapes) {
            if (columnLengths.get(columnNames[0]) < String.valueOf(shape.getId()).length()) {
                columnLengths.put(columnNames[0], String.valueOf(shape.getId()).length());
            }

            if (columnLengths.get(columnNames[1]) < shape.getClass().getSimpleName().length()) {
                columnLengths.put(columnNames[1], shape.getClass().getSimpleName().length());
            }

            if (columnLengths.get(columnNames[2]) < shape.toString().length()) {
                columnLengths.put(columnNames[2], shape.toString().length());
            }

            if (columnLengths.get(columnNames[3]) < String.format("%.2f", shape.calculatePerimeter()).length()) {
                columnLengths.put(columnNames[3], String.format("%.2f", shape.calculatePerimeter()).length());
            }

            if (columnLengths.get(columnNames[4]) < FormulaProvider.getPerimeterFormulaForShape(shape.getClass().getSimpleName()).length()) {
                columnLengths.put(columnNames[4], FormulaProvider.getPerimeterFormulaForShape(shape.getClass().getSimpleName()).length());
            }

            if (columnLengths.get(columnNames[5]) < String.format("%.2f", shape.calculateArea()).length()) {
                columnLengths.put(columnNames[5], String.format("%.2f", shape.calculateArea()).length());
            }

            if (columnLengths.get(columnNames[6]) < FormulaProvider.getAreaFormulaForShape(shape.getClass().getSimpleName()).length()) {
                columnLengths.put(columnNames[6], FormulaProvider.getAreaFormulaForShape(shape.getClass().getSimpleName()).length());
            }
        }
    }

    /**
     * Creates the top line of the table, with the necessary table width
     * @return top line as String
     */
    private String createTopLine() { return "/" + createLineMiddleSection() + "\\"; }

    /**
     * Creates the bottom line of the table, with the necessary table width
     * @return bottom line as String
     */
    private String createBottomLine() { return "\n" + "\\" + createLineMiddleSection() + "/" + "\n"; }

    /**
     * Returns the width of the table, without opening and closing symbols on the sides
     * @return the total width of the table's content part as integer
     */
    private int getTableMiddlePartLength() {
        int tableMiddlePartLength = 0;
        for (int maxColumnLength : columnLengths.values()) {
            tableMiddlePartLength += maxColumnLength;
        }

        return tableMiddlePartLength+(columnLengths.size())*2-1; // Each column has 2 divider, but 1 is common;
    }

    /**
     * Creates the middle section for table lines (first, last, middle) with the necessary length
     * @return String containing "-" characters, representing the middle section of first, last, and middle line of the table
     */
    private String createLineMiddleSection() { return "-".repeat(getTableMiddlePartLength()); }

}
