package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class Prime implements Game {
    private final String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private Cli player;
    private Scanner scanner;
    private String correctAnswer;
    private String userAnswer;

    public Prime(Cli player, Scanner scanner) {
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
    @Override
    public boolean launch() {
        Random rnd = new Random();
        int currentNumber = rnd.nextInt(1, 32);

        setCorrectAnswer(isPrime(currentNumber));

        System.out.print("Question: " + currentNumber +  "\nYour answer: ");

        setUserAnswer(scanner.next());

        return getUserAnswer().equals(getCorrectAnswer());
    }

    private String isPrime(int num) {
        if (num == 1) {
            return "no";
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return "no";
            }
        }

        return "yes";
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
