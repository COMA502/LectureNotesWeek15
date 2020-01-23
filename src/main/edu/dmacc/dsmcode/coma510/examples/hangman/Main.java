package edu.dmacc.dsmcode.coma510.examples.hangman;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        UserInput input = new UserInput();
        try {
            WordBank wordBank = getWordBank();
            if (wordBank == null) return;
            WordTracker tracker = new WordTracker(wordBank);
            RenderGame renderer = new RenderGame(tracker);
            HighScores scores = getHighScores();
            if (scores == null) return;

            Game game = new Game(input, tracker, renderer, scores);
            game.runGame();

            try {
                game.showResults();
            } catch (FileNotFoundException e) {
                System.err.println("Unable to save updated high scores");
            }
        } finally {
            input.close();
        }
    }

    private static WordBank getWordBank() {
        WordBank wordBank;
        try {
            wordBank = new WordBank();
        } catch (FileNotFoundException e) {
            System.err.println("The word bank file doesn't exist");
            return null;
        } catch (IllegalStateException e) {
            System.err.println("The word bank has no words");
            return null;
        }
        return wordBank;
    }

    private static HighScores getHighScores() {
        HighScores scores = null;
        try {
            scores = new HighScores();
        } catch (Exception e) {
            System.err.println("Unable to read high scores");
            return null;
        }
        return scores;
    }
}
