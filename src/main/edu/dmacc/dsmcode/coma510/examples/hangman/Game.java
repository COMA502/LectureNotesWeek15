package edu.dmacc.dsmcode.coma510.examples.hangman;

import java.io.FileNotFoundException;

public class Game {

    private UserInput input;
    private WordTracker tracker;
    private RenderGame renderer;
    private HighScores scores;

    public Game(UserInput input, WordTracker tracker, RenderGame renderer, HighScores scores) {
        this.input = input;
        this.tracker = tracker;
        this.renderer = renderer;
        this.scores = scores;
    }

    public void runGame() {
        renderer.printInstructions();
        runGameLoop();
    }

    private void runGameLoop() {
        while (!tracker.hasLost() && !tracker.hasWon()) {
            renderer.printGame();

            char guess = input.getValidGuess();
            tracker.addGuess(guess);
        }
    }

    public void showResults() throws FileNotFoundException {
        renderer.printGame();

        if (tracker.hasLost()) {
            renderer.printLost();
        } else {
            renderer.printWon();
            addToHighScores();
            renderer.printHighScores(scores);
        }
    }

    private void addToHighScores() throws FileNotFoundException {
        String name = input.getName();
        HighScore score = new HighScore(name, tracker.getNumberWrongGuesses());
        scores.addScore(score);
    }
}
