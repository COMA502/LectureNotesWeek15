package edu.dmacc.dsmcode.coma510.examples.hangman;

public class WordTracker {

    private static final char WORD_BLANK = '_';
    private static final int MAX_WRONG_GUESSES = 6;

    private String actualWord;
    private char[] wordWithBlanks;
    private String wrongGuesses = "";

    public WordTracker(WordBank wordBank) {
        actualWord = wordBank.getRandomWord().toUpperCase();

        wordWithBlanks = new char[actualWord.length()];
        for (int i = 0; i < actualWord.length(); i++) {
            wordWithBlanks[i] = WORD_BLANK;
        }
    }

    public void addGuess(char guess) {
        guess = getGuessInUpperCase(guess);
        if (actualWord.indexOf(guess) >= 0) {
            for (int i = 0; i < actualWord.length(); i++) {
                if (actualWord.charAt(i) == guess) {
                    wordWithBlanks[i] = guess;
                }
            }
        } else {
            wrongGuesses += guess;
        }
    }

    private char getGuessInUpperCase(char guess) {
        return (guess + "").toUpperCase().charAt(0);
    }

    public boolean hasWon() {
        for (int i = 0; i < wordWithBlanks.length; i++) {
            if (wordWithBlanks[i] == WORD_BLANK) {
                return false;
            }
        }
        return true;
    }

    public boolean hasLost() {
        return wrongGuesses.length() >= MAX_WRONG_GUESSES;
    }

    public char[] getWordWithBlanks() {
        return wordWithBlanks;
    }

    public int getNumberWrongGuesses() {
        return wrongGuesses.length();
    }

    public char[] getWrongGuesses() {
        return wrongGuesses.toCharArray();
    }
}
