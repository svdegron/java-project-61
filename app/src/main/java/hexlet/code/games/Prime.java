package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Prime {
    public static String isPrime(int num) {
        if (num == 0 || num == 1) {
            return "no";
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
    public static boolean startGame(Scanner sc, String userName) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Random rnd = new Random();
        final int lastNumber = 32;
        int currentNumber = rnd.nextInt(lastNumber);
        System.out.print("Question: " + currentNumber +  "\nYour answer: ");
        String answer = isPrime(currentNumber);
        String userAnswer = sc.next();
        boolean checkAnswer = userAnswer.equals(answer);
        if (!checkAnswer) {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                    + " %s!", userAnswer, answer, userName));
        }
        return checkAnswer;
    }
}
