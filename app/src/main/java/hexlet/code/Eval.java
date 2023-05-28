package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Eval {
    private final String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private final int needWin = 3;
    private Cli player;
    private int countWin;

    Eval(Cli player) {
        this.player = player;
        this.countWin = 0;
    }

    private int getCountWin() {
        return countWin;
    }

    public String getDescription() {
        return description;
    }

    private void addWin() {
        countWin++;
    }

    private void printCongratulation() {
        if (getCountWin() == needWin) {
            System.out.println("Congratulations, " + player.getName() + "!");
        }
    }

    public void printDescription() {
        System.out.println(getDescription());
    }

    public void startGame(Scanner scanner) {
        printDescription();

        boolean repeatGame = false;

        do {
            repeatGame = gameProcess(scanner);

            if (repeatGame) {
                addWin();
            }

        } while (repeatGame && getCountWin() < needWin);

        printCongratulation();
    }

    private boolean gameProcess(Scanner scanner) {
        Random rnd = new Random();
        int currentNumber = rnd.nextInt(100);

        System.out.println("Question: " + currentNumber);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();

        String correctAnswer;

        if (currentNumber % 2 == 0) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }

        boolean result = correctAnswer.equals(userAnswer);

        if (result) {
            System.out.println("Correct!");
        } else {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!",
                    userAnswer, correctAnswer, player.getName()));
        }

        return result;
    }
}
