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
    private final String[] columnNames;

    // Store column names and their corresponding final lengths as key/value pairs
    private final HashMap<String, Integer> columnLengths;

    // Constructor

    public TableBuilder() {
        this.columnNames = new String[]{"ID", "Shape", "Shape data", "Perimeter", "Perimeter formula", "Area", "Area formula"};
        this.columnLengths = new HashMap<>();

        // Populate columnLengths HashMap with column names and corresponding lengths to have an initial dataset
        for (String columnName : columnNames) {
            columnLengths.put(columnName, columnName.length());
        }
    }


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
        // Determine maximum column lengths and update HashMap (ID column already covered)
        for (Shape shape : shapes) {
            if (columnLengths.get(columnNames[0]) < String.valueOf(shape.getId()).length()) {
                columnLengths.put(columnNames[0], String.valueOf(shape.getId()).length());
            }

            if (columnLengths.get(columnNames[1]) < shape.getClass().getSimpleName().length()) {
                columnLengths.put(columnNames[1], shape.getClass().getSimpleName().length());
            }

            if (columnLengths.get(columnNames[2]) < shape.getData().length()) {
                columnLengths.put(columnNames[2], shape.getData().length());
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

    /**
     * Creates the header row, in the necessary length (padded with whitespaces), of the table, by columnNames declared in it's the class
     * @return String representation of the header row
     */
    private String createHeaderRow() {
        StringBuilder headerRow = new StringBuilder();

        for (String columnName : columnNames) {
            int currentColumnLength = columnLengths.get(columnName);
            headerRow.append("|").append(padLeftText(columnName, currentColumnLength));
        }

        headerRow.append("|"); // Add closing symbol

        return "\n" + headerRow;
    }

    /**
     * Create table body, as String, filled with data about in memory Shape objects
     * @param shapes collection of existing in memory Shape objects
     * @return table body, filled with data about existing Shape objects if any, otherwise "No data."
     */
    private String createTableData(ArrayList<Shape> shapes) {
        StringBuilder tableData = new StringBuilder();

        if (shapes.isEmpty()) {
            String noDataSign = "No data.";
            String noData = centerText(noDataSign, getTableMiddlePartLength());

            tableData.append("\n").append(createMiddleLine());
            tableData.append("\n").append("|").append(noData).append("|");
        }

        for (Shape shape : shapes) {
            tableData.append("\n").append(createSeparatorLine());

            tableData.append("\n");

            tableData.append("|").append(padLeftText(String.valueOf(shape.getId()), columnLengths.get("ID")));
            tableData.append("|").append(padLeftText(shape.getClass().getSimpleName(), columnLengths.get("Shape")));
            tableData.append("|").append(padLeftText(shape.getData(), columnLengths.get("Shape data")));
            tableData.append("|").append(padLeftText(String.format("%.2f", shape.calculatePerimeter()), columnLengths.get("Perimeter")));
            tableData.append("|").append(padLeftText(FormulaProvider.getPerimeterFormulaForShape(shape.getClass().getSimpleName()), columnLengths.get("Perimeter formula")));
            tableData.append("|").append(padLeftText(String.format("%.2f", shape.calculateArea()), columnLengths.get("Area")));
            tableData.append("|").append(padLeftText(FormulaProvider.getAreaFormulaForShape(shape.getClass().getSimpleName()), columnLengths.get("Area formula")));

            tableData.append("|");
        }

        return tableData.toString();
    }

    /**
     * Creates a simple separator middle line for the Shapes table, with the necessary table width, used when table have no data
     * @return a middle line built up by "-" characters as String
     */
    private String createMiddleLine() { return "|" + createLineMiddleSection() + "|"; }

    /**
     * Creates a separator line for the Shapes table, with the necessary table and column widths, used when table have data
     * @return a middle line built up by "-" and "|" separator characters as String
     */
    private String createSeparatorLine() {
        StringBuilder separatorLine = new StringBuilder();

        for (int i = 0; i < columnLengths.values().size(); i++) {
            separatorLine.append("|");
            separatorLine.append("-".repeat(columnLengths.get(columnNames[i])+1));
        }

        separatorLine.append("|");

        return separatorLine.toString();
    }

    /**
     * Centers a given String within the defined totalLength, padded on two sides by whitespaces
     * @param text the given String that will be centered
     * @param totalLength the total length of the output String with padding
     * @return a padded String with the defined totalLength, padded with whitespaces on both sides
     */
    private String centerText(String text, int totalLength) {
        String padded = "";
        int padNum = (totalLength - text.length()) / 2;

        padded += " ".repeat(padNum) + text + " ".repeat(padNum);

        return padded;
    }

    /**
     * Left pads a given String with the defined totalLength by adding whitespaces to the left
     * @param text the given String that will be left padded
     * @param totalLength the total length of the output String with padding
     * @return a padded String with the defined totalLength, padded with whitespaces on the left side
     */
    private String padLeftText(String text, int totalLength) {
        String padded = "";
        int padNum = totalLength - text.length() + 1;

        padded += " ".repeat(padNum) + text;

        return padded;
    }
}
