package hexlet.code.games;

import hexlet.code.Cli;
import java.util.Random;
import java.util.Scanner;

public class Progression implements Game {
    private final String description = "What number is missing in the progression?";
    private Cli player;
    private Scanner scanner;
    private int correctAnswer;
    private int userAnswer;

    public Progression(Cli player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    private void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    private void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
    @Override
    public boolean launch() {
        Random rnd = new Random();

        int countProgression = rnd.nextInt(5, 10);
        int hideElement = rnd.nextInt(0, countProgression);
        int startProgression = rnd.nextInt(1, 10);
        int stepProgression = rnd.nextInt(1, 10);
        StringBuilder stringProgression = new StringBuilder();

        stringProgression.append(" " + startProgression);

        int temp = startProgression + stepProgression;

        for (int i = 0; i < countProgression; i++) {
            if (i != hideElement) {
                stringProgression.append(" " + temp);
            } else {
                stringProgression.append(" ..");
                setCorrectAnswer(temp);
            }

            temp += stepProgression;
        }

        System.out.print("Question:" + stringProgression.toString() +  "\nYour answer: ");

        setUserAnswer(scanner.nextInt());

        return getCorrectAnswer() == getUserAnswer();
    }

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void printError() {
        System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                + " %s!", getUserAnswer(), getCorrectAnswer(), player.getName()));
    }

    @Override
    public String getPlayerName() {
        return player.getName();
    }
}
