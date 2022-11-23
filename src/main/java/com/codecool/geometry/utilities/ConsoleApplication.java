package com.codecool.geometry.utilities;

import com.codecool.geometry.containers.ShapeCollection;

import java.io.IOException;

import static com.codecool.geometry.utilities.Util.*;

/**
 * This class is intended to contain the main logic of the application
 */
public class ConsoleApplication {
    // Dependencies
    private final MainMenu mainMenu;

    // Fields
    private boolean isRunning = true;
    private boolean inputWasWrong = false;
    private int option = -1;

    // Constructor
    public ConsoleApplication() {
        this.mainMenu = new MainMenu(new ShapeCollection());
    }

    /**
     * Runs the main logic of the console application
     */
    public void run() throws IOException {

        greeting();

        while (isRunning) {
            askForInputAndShowMainMenu();

            switch (option) {
                case 1:
                    mainMenu.addNewShape();
                    inputWasWrong = false;
                    break;
                case 2:
                    mainMenu.showAllShapes();
                    inputWasWrong = false;
                    break;
                case 3:
                    mainMenu.showShapeWithLargestPerimeter();
                    inputWasWrong = false;
                    break;
                case 4:
                    mainMenu.showShapeWithLargestArea();
                    inputWasWrong = false;
                    break;
                case 5:
                    mainMenu.showFormulas();
                    inputWasWrong = false;
                    break;
                case 6:
                    mainMenu.credits();
                    inputWasWrong = false;
                    break;
                case 0:
                    mainMenu.exit();
                    isRunning = false;
                    break;
            }
        }
    }

    /**
     * Greets the user before Main menu
     */
    private void greeting() throws IOException {
        consoleClear();
        System.out.println(AsciiArts.welcome);
        pressEnterToContinue();
    }

}
