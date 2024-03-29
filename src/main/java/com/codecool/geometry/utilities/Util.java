package com.codecool.geometry.utilities;

import java.io.Console;

/**
 * A class to store reusable static helper methods, to be used throughout the whole application
 */
public class Util {
    // Prevent instantiation of a fully static class
    private Util() {}

    /**
     * A console object for handling user input via reading the console
     */
    public static final Console console = System.console();

    /**
     * Stops the execution and waits for user input, as an "enter" key-press
     */
    public static void pressEnterToContinue() {
        console.readLine("Press enter to continue. ");
    }

    /**
     * Clears the console
     */
    public static void consoleClear() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred during console clear.");
            System.out.println(e);
        }
    }
}
