package edu.dmacc.dsmcode.coma510.examples.hangman;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;
    private UserValidation validation;

    public UserInput() {
        this.scanner = new Scanner(System.in);
        this.validation = new UserValidation();
    }

    public char getValidGuess() {
        String guess;
        do {
            guess = getGuess();
        } while (!validation.isValidInput(guess));

        return guess.toUpperCase().charAt(0);
    }

    private String getGuess() {
        System.out.print("\nWhat's your guess? ");
        return scanner.next();
    }

    public String getName() {
        System.out.print("\nWhat's your name? ");
        return scanner.next();
    }

    public void close() {
        scanner.close();
    }
}
