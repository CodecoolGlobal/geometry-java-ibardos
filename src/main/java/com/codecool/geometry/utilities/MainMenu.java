package com.codecool.geometry.utilities;

import com.codecool.geometry.containers.ShapeCollection;
import com.codecool.geometry.shapes.Shape;

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
    public void addNewShape() {
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
    public void showAllShapes() {
        consoleClear();
        System.out.println(AsciiArts.showAllShapes);
        System.out.println(shapeCollection.getShapesTable());

        pressEnterToContinue();
    }

    // 3. Show shape with the largest perimeter
    /**
     * Logic of finding and showing the Shape object with the largest perimeter from Main Menu
     */
    public void showShapeWithLargestPerimeter() {
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
    public void showShapeWithLargestArea() {
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
    public void showFormulas() {
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
    public void credits() {
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


    // Private helper methods

    /**
     * Prints out to console the chosen Shape object's available formulas
     * @param shapeChoiceForFormula shape choice as integer (from menu)
     */
    private void printFormulasOfShape(int shapeChoiceForFormula) {
        switch (shapeChoiceForFormula) {
            case 1:
                System.out.println(AsciiArts.circle);
                System.out.println("Area formula: " + FormulaProvider.getAreaFormulaForShape("Circle"));
                System.out.println("Perimeter formula: " + FormulaProvider.getPerimeterFormulaForShape("Circle"));
                System.out.println();
                break;
            case 2:
                System.out.println(AsciiArts.rectangle);
                System.out.println("Area formula: " + FormulaProvider.getAreaFormulaForShape("Rectangle"));
                System.out.println("Perimeter formula: " + FormulaProvider.getPerimeterFormulaForShape("Rectangle"));
                System.out.println();
                break;
            case 3:
                System.out.println(AsciiArts.triangle);
                System.out.println("Area formula: " + FormulaProvider.getAreaFormulaForShape("Triangle"));
                System.out.println("Perimeter formula: " + FormulaProvider.getPerimeterFormulaForShape("Triangle"));
                System.out.println();
                break;
            case 4:
                System.out.println(AsciiArts.square);
                System.out.println("Area formula: " + FormulaProvider.getAreaFormulaForShape("Square"));
                System.out.println("Perimeter formula: " + FormulaProvider.getPerimeterFormulaForShape("Square"));
                System.out.println();
                break;
            case 5:
                System.out.println(AsciiArts.equilateralTriangle);
                System.out.println("Area formula: " + FormulaProvider.getAreaFormulaForShape("EquilateralTriangle"));
                System.out.println("Perimeter formula: " + FormulaProvider.getPerimeterFormulaForShape("EquilateralTriangle"));
                System.out.println();
                break;
            case 6:
                System.out.println(AsciiArts.regularPentagon);
                System.out.println("Area formula: " + FormulaProvider.getAreaFormulaForShape("RegularPentagon"));
                System.out.println("Perimeter formula: " + FormulaProvider.getPerimeterFormulaForShape("RegularPentagon"));
                System.out.println();
                break;
        }
    }

    /**
     * Asks the user to input the corresponding parameters for Shape object creation
     * @param shapeChoice shape choice as integer (from menu)
     * @return list of necessary parameters for corresponding Shape object creation
     */
    private ArrayList<Integer> getParametersForShapeCreation(int shapeChoice) {
        ArrayList<Integer> parameterList = new ArrayList<>();

        while (parameterList.isEmpty()) {
            try {
                switch (shapeChoice) {
                    case 1: // Circle
                        System.out.println(AsciiArts.circle);
                        if (inputWasWrong) System.out.println("Wrong input! Start over.");
                        int rCircle = parseInt(console.readLine("Define radius: "));
                        parameterList.add(rCircle);
                        break;
                    case 2: // Rectangle
                        System.out.println(AsciiArts.rectangle);
                        if (inputWasWrong) System.out.println("One of the inputs was wrong! Start over.");
                        int aRectangle = parseInt(console.readLine("Define side A: "));
                        int bRectangle = parseInt(console.readLine("Define side B: "));
                        parameterList.add(aRectangle);
                        parameterList.add(bRectangle);
                        break;
                    case 3: // Triangle
                        System.out.println(AsciiArts.triangle);
                        if (inputWasWrong) System.out.println("One of the inputs was wrong! Start over.");
                        int aTriangle = parseInt(console.readLine("Define side A: "));
                        int bTriangle = parseInt(console.readLine("Define side B: "));
                        int cTriangle = parseInt(console.readLine("Define side C: "));
                        parameterList.add(aTriangle);
                        parameterList.add(bTriangle);
                        parameterList.add(cTriangle);
                        break;
                    case 4: // Square
                        System.out.println(AsciiArts.square);
                        if (inputWasWrong) System.out.println("Wrong input! Start over.");
                        int aSquare = parseInt(console.readLine("Define side A: "));
                        parameterList.add(aSquare);
                        break;
                    case 5: // EquilateralTriangle
                        System.out.println(AsciiArts.equilateralTriangle);
                        if (inputWasWrong) System.out.println("Wrong input! Start over.");
                        int aEquilateralTriangle = parseInt(console.readLine("Define side A: "));
                        parameterList.add(aEquilateralTriangle);
                        break;
                    case 6: // RegularPentagon
                        System.out.println(AsciiArts.regularPentagon);
                        if (inputWasWrong) System.out.println("Wrong input! Start over.");
                        int aRegularPentagon = parseInt(console.readLine("Define side A: "));
                        parameterList.add(aRegularPentagon);
                        break;
                }
            } catch (NumberFormatException e) {
                inputWasWrong = true;
                consoleClear();
            }
        }

        return parameterList;
    }

    /**
     * Prints out the Main menu to console, and a "Wrong input!" message if the previous input was wrong
     * @param inputWasWrong variable used as a switch to keep the state of the last user input (correct/wrong)
     */
    public void showMainMenu(boolean inputWasWrong) {
        StringBuilder mainMenu = new StringBuilder()
                .append(AsciiArts.mainMenu)
                .append("1. Add new shape")
                .append("\n" + "2. Show all shapes")
                .append("\n" + "3. Show shape with the largest perimeter")
                .append("\n" + "4. Show shape with the largest area")
                .append("\n" + "5. Show formulas")
                .append("\n" + "6. Credits")
                .append("\n" + "0. Exit")
                .append("\n");

        if (inputWasWrong) {
            mainMenu.append("\n").append("Wrong input! Try again.");
        }

        consoleClear();
        System.out.println(mainMenu);
    }

    /**
     * Returns a list of available Shape types for console representation
     */
    private String shapeOptionsMenu() {
        StringBuilder shapeOptions = new StringBuilder()
                .append("1. Circle")
                .append("\n" + "2. Rectangle")
                .append("\n" + "3. Triangle")
                .append("\n" + "4. Square")
                .append("\n" + "5. Equilateral triangle")
                .append("\n" + "6. Regular pentagon")
                .append("\n" + "0. Back to Main menu")
                .append("\n");

        if (inputWasWrong) {
            shapeOptions.append("\n").append("Wrong input! Try again.");
        }

        return shapeOptions.toString();
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
