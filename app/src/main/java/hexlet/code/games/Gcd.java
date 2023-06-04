package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Gcd {
    public static boolean startGame(Scanner sc, String userName) {
        System.out.println("Find the greatest common divisor of given numbers.");
        Random rnd = new Random();
        int minNumber = 10;
        int maxNumber = 100;
        int firstNumber = rnd.nextInt(minNumber, maxNumber);
        int secondNumber = rnd.nextInt(minNumber, maxNumber);
        System.out.print("Question: " + firstNumber + " " + secondNumber +  "\nYour answer: ");
        int max = Math.max(firstNumber, secondNumber);
        int min = Math.min(firstNumber, secondNumber);
        int gcd = 0;
        do {
            gcd = max % min;
            max = Math.max(min, gcd);
            min = Math.min(min, gcd);
        } while (gcd != 0);
        int answer = max;
        int userAnswer = sc.nextInt();
        boolean checkAnswer = (userAnswer == answer);
        if (!checkAnswer) {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                    + " %s!", userAnswer, answer, userName));
        }
        return checkAnswer;
    }
}
