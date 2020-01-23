package edu.dmacc.dsmcode.coma510.examples.hangman;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HighScore implements Comparable<HighScore> {

    private String name;
    private String date;
    private int score;

    public HighScore(String highScoresFileLine) throws IllegalArgumentException {
        try {
            String[] split = highScoresFileLine.split(",");
            name = split[0];
            date = split[1];
            score = Integer.parseInt(split[2]);
        } catch(Exception e) {
            throw new IllegalArgumentException("High Scores file not formatted correctly");
        }
    }

    public HighScore(String name, int score) {
        this.name = name;
        this.date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        this.score = score;
    }

    public String formatAsHighScoresFileLine() {
        return name + "," + date + "," + score;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(HighScore o) {
        if(o == null) {
            return 1;
        }
        return Integer.compare(score, o.score);
    }
}
