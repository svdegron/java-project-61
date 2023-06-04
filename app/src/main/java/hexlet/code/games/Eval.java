package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Eval {
    public static boolean startGame(Scanner sc, String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random rnd = new Random();
        int maxNum = 100;
        int num = rnd.nextInt(maxNum);
        System.out.print("Question: " + num + "\nYour answer: ");
        String answer = "not ready";
        if (num % 2 == 0) {
            answer = "yes";
        } else {
            answer = "no";
        }
        String userAnswer = sc.next();
        boolean checkAnswer = userAnswer.equals(answer);
        if (!checkAnswer) {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                    + " %s!", userAnswer, answer, userName));
        }
        return checkAnswer;
    }
}
