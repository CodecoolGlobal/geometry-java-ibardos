package com.codecool.geometry.utilities;

import com.codecool.geometry.containers.ShapeCollection;

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
}
