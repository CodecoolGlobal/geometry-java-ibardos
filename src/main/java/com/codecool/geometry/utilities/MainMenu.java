package com.codecool.geometry.utilities;

import com.codecool.geometry.containers.ShapeCollection;
import com.codecool.geometry.shapes.Shape;

import java.io.IOException;
import java.util.ArrayList;
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
