package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class Eval implements Game {
    private final String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private Cli player;
    private Scanner scanner;
    private String correctAnswer;
    private String userAnswer;


    public Eval(Cli player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    private void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    private void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

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

    private boolean equalsAnswer() {
        return getCorrectAnswer().equals(getUserAnswer());
    }

    @Override
    public boolean launch() {
        Random rnd = new Random();
        int currentNumber = rnd.nextInt(100);

        System.out.print("Question: " + currentNumber + "\nYour answer: ");

        setUserAnswer(scanner.next());

        if (currentNumber % 2 == 0) {
            setCorrectAnswer("yes");
        } else {
            setCorrectAnswer("no");
        }

        return equalsAnswer();
    }
}
