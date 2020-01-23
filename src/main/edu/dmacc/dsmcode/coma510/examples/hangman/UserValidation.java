package edu.dmacc.dsmcode.coma510.examples.hangman;

public class UserValidation {

    public boolean isValidInput(String input) {
        if (input.length() != 1) {
            System.err.println("You must enter a single character");
            return false;
        }

        char guess = input.toUpperCase().charAt(0);
        if (guess < 'A' || guess > 'Z') {
            System.err.println("You must enter A-Z");
            return false;
        }

        return true;
    }
}
