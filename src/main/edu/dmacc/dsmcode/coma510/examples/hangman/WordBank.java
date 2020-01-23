package edu.dmacc.dsmcode.coma510.examples.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordBank {

    public static final String WORD_BANK_FILE_PATH = "src/main/edu/dmacc/dsmcode/coma510/examples/hangman/word_bank.txt";

    private ArrayList<String> words = new ArrayList<>();

    public WordBank() throws FileNotFoundException {
        File file = new File(WORD_BANK_FILE_PATH);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                words.add(fileScanner.nextLine());
            }
        }

        if(words.size() == 0) {
            throw new IllegalStateException("Word bank has no words");
        }
    }

    public String getRandomWord() {
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }
}
