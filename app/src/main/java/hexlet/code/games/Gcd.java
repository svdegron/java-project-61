package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class Gcd implements Game {
    private final String description = "Find the greatest common divisor of given numbers.";
    public Cli player;
    public Scanner scanner;
    private int correctAnswer;
    private int userAnswer;

    public Gcd(Cli player, Scanner scanner) {
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
        int minNumber = 10;
        int maxNumber = 100;
        int firstNumber = rnd.nextInt(minNumber, maxNumber);
        int secondNumber = rnd.nextInt(minNumber, maxNumber);

        System.out.print("Question: " + firstNumber + " " + secondNumber +  "\nYour answer: ");

        setUserAnswer(scanner.nextInt());

        int max = Math.max(firstNumber, secondNumber);
        int min = Math.min(firstNumber, secondNumber);
        int gcd = 0;

        do {
            gcd = max % min;
            max = Math.max(min, gcd);
            min = Math.min(min, gcd);
        } while (gcd != 0);

        setCorrectAnswer(max);

        return getUserAnswer() == getCorrectAnswer();
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
