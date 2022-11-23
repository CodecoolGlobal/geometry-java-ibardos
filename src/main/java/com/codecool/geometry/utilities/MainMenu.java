package com.codecool.geometry.utilities;

import com.codecool.geometry.containers.ShapeCollection;
import com.codecool.geometry.shapes.Shape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static com.codecool.geometry.utilities.Util.*;
import static java.lang.Integer.parseInt;

public class MainMenu {
    // Dependencies
    private final ShapeCollection shapeCollection;

    // Fields
    private boolean inputWasWrong = false;
    private int option = -1;

    // Constructor
    public MainMenu(ShapeCollection shapeCollection) {
        this.shapeCollection = shapeCollection;
    }

    // Menus respectively

    // 1. Add new shape
    /**
     * Logic of new Shape creation and addition from Main Menu
     */
    public void addNewShape() throws IOException {
        askForShapeChoice("What shape would you like to add: ", AsciiArts.addNewShape);

        // In case of 0. the user should be redirected to Main menu
        if (option != 0) {
            ArrayList<Integer> parameters = getParametersForShapeCreation(option);
            shapeCollection.addShape(option, parameters);

            consoleClear();
            System.out.println(AsciiArts.shapeAdded);

            pressEnterToContinue();
        }

        inputWasWrong = false;
    }

    // 2. Show all shapes
    /**
     * Logic of Shapes table creation and representation on console from Main Menu
     */
    public void showAllShapes() throws IOException {
        consoleClear();
        System.out.println(AsciiArts.showAllShapes);
        System.out.println(shapeCollection.getShapesTable());

        pressEnterToContinue();
    }

    // 3. Show shape with the largest perimeter
    /**
     * Logic of finding and showing the Shape object with the largest perimeter from Main Menu
     */
    public void showShapeWithLargestPerimeter() throws IOException {
        consoleClear();
        System.out.println(AsciiArts.showShapeWithLargestPerimeter);

        try {
            Shape largestShapeByPerimeter = shapeCollection.getLargestShapeByPerimeter();
            System.out.println(largestShapeByPerimeter + ", perimeter= " + String.format("%.2f", largestShapeByPerimeter.calculatePerimeter()));
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("No data.");
            System.out.println();
        }

        pressEnterToContinue();
    }

    // 4. Show shape with the largest area
    /**
     * Logic of finding and showing the Shape object with the largest area from Main Menu
     */
    public void showShapeWithLargestArea() throws IOException {
        consoleClear();
        System.out.println(AsciiArts.showShapeWithLargestArea);

        try {
            Shape largestShapeByArea = shapeCollection.getLargestShapeByArea();
            System.out.println(largestShapeByArea + ", area= " + String.format("%.2f", largestShapeByArea.calculateArea()));
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("No data.");
            System.out.println();
        }

        pressEnterToContinue();
    }

    // 5. Show formulas

    /**
     * Logic of finding the formulas of a given Shape type and showing on console from Main Menu
     */
    public void showFormulas() throws IOException {
        askForShapeChoice("Which shape would you like to see the formula of: ", AsciiArts.showFormulas);

        // In case of 0. the user should be redirected to Main menu
        if (option != 0) {
            printFormulasOfShape(option);

            pressEnterToContinue();
        }

        inputWasWrong = false;
    }

    // 6. Credits
    /**
     * Showing some information about the creator and say thank you from Main Menu
     */
    public void credits() throws IOException {
        consoleClear();
        System.out.println(AsciiArts.credits);
        System.out.println("This is a Java demo project, made by Istvan Bardos.");
        System.out.println();
        System.out.println("The project was intended to design an interactive, yet stylish, console application in Java.");
        System.out.println("Maven was used for build and project management, therefore the app should run on multiple platforms.");
        System.out.println("Corresponding build & run commands were embedded in a shell script for ease of use.");
        System.out.println();
        System.out.println("Check out my GitHub profile for more projects: https://github.com/ibardos");
        System.out.println();
        System.out.println("Thank you for being here! :)");
        System.out.println();

        pressEnterToContinue();
    }

    // 0. Exit
    /**
     * Logic of exiting the application from Main Menu
     */
    public void exit() {
        consoleClear();
        System.out.println(AsciiArts.exit);
    }


    /**
     * Asks user input for shape choice, with the given text and ascii art as part of the UI
     * @param askInputText text as String, which will be used to ask the user with
     * @param asciiArt ascii art as String, to represent the menu in which the user is in
     */
    private void askForShapeChoice(String askInputText, String asciiArt) {
        option = -1;

        while (option < 0 || option > 6) {
            try {
                consoleClear();
                System.out.println(asciiArt);
                System.out.println(shapeOptionsMenu());
                option = parseInt(console.readLine(askInputText));

                if (option < 0 || option > 6) {
                    inputWasWrong = true;
                }
            } catch (NumberFormatException e) {
                inputWasWrong = true;
            }
        }

        consoleClear();
    }
}
