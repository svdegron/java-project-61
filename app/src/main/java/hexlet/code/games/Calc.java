package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static boolean startGame(Scanner sc, String userName) {
        System.out.println("What is the result of the expression?");
        Random rnd = new Random();
        int maxNum = 100;
        int firstNumber = rnd.nextInt(maxNum);
        int secondNumber = rnd.nextInt(maxNum);
        int probability = 3;
        int chooseOperation = rnd.nextInt(maxNum) % probability;
        char operation = '?';
        int answer = 0;
        switch (chooseOperation) {
            case 0:
                operation = '+';
                answer = firstNumber + secondNumber;
                break;
            case 1:
                operation = '-';
                answer = firstNumber - secondNumber;
                break;
            case 2:
                operation = '*';
                answer = firstNumber * secondNumber;
                break;
            default:break;
        }
        System.out.print(String.format("Question: %s %s %s\nYour answer: ", firstNumber, operation, secondNumber));
        int userAnswer = sc.nextInt();
        boolean checkAnswer = (userAnswer == answer);
        if (!checkAnswer) {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                    + " %s!", userAnswer, answer, userName));
        }
        return checkAnswer;
    }
}
