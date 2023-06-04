package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class Calc implements Game {
    private final String description = "What is the result of the expression?";
    public Cli player;
    public Scanner scanner;
    private int correctAnswer;
    private int userAnswer;

    public Calc(Cli player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    private void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    private void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void printError() {
        System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                + " %s!", getUserAnswer(), getCorrectAnswer(), player.name));
    }

    @Override
    public String getPlayerName() {
        return player.name;
    }

    @Override
    public boolean launch() {
        Random rnd = new Random();
        int maxNumber = 100;
        int firstNumber = rnd.nextInt(maxNumber);
        int secondNumber = rnd.nextInt(maxNumber);
        int probability = 3;
        int chooseOperation = rnd.nextInt(maxNumber) % probability;
        char operation = '?';

        switch (chooseOperation) {
            case 0:
                operation = '+';
                setCorrectAnswer(firstNumber + secondNumber);
                break;
            case 1:
                operation = '-';
                setCorrectAnswer(firstNumber - secondNumber);
                break;
            case 2:
                operation = '*';
                setCorrectAnswer(firstNumber * secondNumber);
                break;
            default:break;
        }

        System.out.print(String.format("Question: %s %s %s\nYour answer: ", firstNumber, operation, secondNumber));

        setUserAnswer(scanner.nextInt());

        return getCorrectAnswer() == getUserAnswer();
    }
}
