package com.codecool.geometry.utilities;

import java.io.Console;
import java.io.IOException;

/**
 * A class to store reusable static helper methods, to be used throughout the whole application
 */
public class Util {
    /**
     * A console object for handling user input via reading the console
     */
    public static final Console console = System.console();

    /**
     * Stops the execution and waits for user input, as an "enter" keypress
     */
    public static void pressEnterToContinue() throws IOException {
        System.out.println("Press enter to continue.");
        System.in.read();
    }

}
