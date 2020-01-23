package edu.dmacc.dsmcode.coma510.examples.hangman;

import java.util.ArrayList;

public class RenderGame {

    private WordTracker tracker;

    public RenderGame(WordTracker tracker) {
        this.tracker = tracker;
    }

    public void printInstructions() {
        System.out.println("Welcome to Hangman!");
        System.out.println("Type a letter you think is in the word below and press <ENTER>. Get a letter wrong and ");
        System.out.println("another body part appears on the person. Get a full body and you lose!\n");
    }

    public void printLost() {
        System.out.println("\n----------- You lose... ----------");
    }

    public void printWon() {
        System.out.println("\n*********** You've won! **********");
    }

    public void printGame() {
        printHangMan();
        printWordWithBlanks();
    }

    private void printHangMan() {
        int numberOfWrongGuesses = tracker.getNumberWrongGuesses();
        System.out.println("   _____   ");
        System.out.println("  |     |  " + formatWrongGuesses(tracker.getWrongGuesses()));
        System.out.println("  |    " + formatHead(numberOfWrongGuesses));
        System.out.println("  |    " + formatArms(numberOfWrongGuesses));
        System.out.println("  |    " + formatTorso(numberOfWrongGuesses));
        System.out.println("  |    " + formatLegs(numberOfWrongGuesses));
        System.out.println("__|__  ");
    }

    private void printWordWithBlanks() {
        char[] wordWithBlanks = tracker.getWordWithBlanks();
        for (int i = 0; i < wordWithBlanks.length; i++) {
            System.out.print(wordWithBlanks[i] + " ");
        }
    }

    private String formatWrongGuesses(char[] wrongGuesses) {
        String formatted = "Wrong Guesses: ";
        for (char guess : wrongGuesses) {
            formatted += guess + " ";
        }
        return formatted;
    }

    private String formatHead(int wrongGuesses) {
        if (wrongGuesses >= 1) {
            return " 0 ";
        } else {
            return "   ";
        }
    }

    private String formatArms(int wrongGuesses) {
        if (wrongGuesses == 2) {
            return " | ";
        } else if (wrongGuesses == 3) {
            return "/| ";
        } else if (wrongGuesses >= 4) {
            return "/|\\";
        } else {
            return "   ";
        }
    }

    private String formatTorso(int wrongGuesses) {
        if (wrongGuesses >= 2) {
            return " | ";
        } else {
            return "   ";
        }
    }

    private String formatLegs(int wrongGuesses) {
        if (wrongGuesses == 5) {
            return "/  ";
        } else if (wrongGuesses == 6) {
            return "/ \\";
        } else {
            return "   ";
        }
    }

    public void printHighScores(HighScores scores) {
        ArrayList<HighScore> highScores = scores.getHighScores();

        System.out.println("Top 10 High Scores");
        System.out.println("# Wrong | Date       | Name");
        for(int i = 0; i < 10 && i < highScores.size(); i++) {
            HighScore score = highScores.get(i);
            System.out.println("   "
                    + score.getScore() + "    | "
                    + score.getDate() + " | "
                    + score.getName());
        }
    }
}
