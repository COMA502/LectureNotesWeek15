package edu.dmacc.dsmcode.coma510.examples.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighScores {

    private static final String HIGH_SCORES_FILE_PATH = "src/main/edu/dmacc/dsmcode/coma510/examples/hangman/high_scores.txt";

    private ArrayList<HighScore> highScores = new ArrayList<>();
    private final File file;

    public HighScores() throws IOException {
        file = new File(HIGH_SCORES_FILE_PATH);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    highScores.add(new HighScore(scanner.nextLine()));
                }
            }
        }
    }

    public ArrayList<HighScore> getHighScores() {
        return highScores;
    }

    public void addScore(HighScore score) throws FileNotFoundException {
        highScores.add(score);
        Collections.sort(highScores);
        saveToFile();
    }

    private void saveToFile() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(file)) {
            for(int i = 0; i < 10 && i < highScores.size(); i++) {
                writer.println(highScores.get(i).formatAsHighScoresFileLine());
            }
        }
    }
}
