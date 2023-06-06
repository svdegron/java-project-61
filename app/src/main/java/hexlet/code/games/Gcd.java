package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Gcd {
    public static void begin(Scanner scanner) {
        final String description = "Find the greatest common divisor of given numbers.";
        final int countRounds = 3;
        final int structure = 2;
        String[][] content = new String[countRounds][structure];
        final int question = 0;
        final int answer = 1;
        Random generate = new Random();
        final int minNumber = 10;
        final int maxNumber = 100;

        // Генерируем вопрос-ответ
        for (int round = 0; round < countRounds; round++) {

            int firstNumber = generate.nextInt(minNumber, maxNumber);
            int secondNumber = generate.nextInt(minNumber, maxNumber);

            content[round][question] = String.format("Question: %s %s\nYour answer: ", firstNumber, secondNumber);

            int max = Math.max(firstNumber, secondNumber);
            int min = Math.min(firstNumber, secondNumber);
            int gcd = 0;

            do {
                gcd = max % min;
                max = min;
                min = gcd;
            } while (gcd != 0);

            content[round][answer] = String.valueOf(max);
        }
        // Вызываем основную логику - движок игры
        Engine.start(content, description, scanner);
    }

    public static boolean startGame(Scanner sc, String userName) {
        System.out.println("Find the greatest common divisor of given numbers.");
        Random rnd = new Random();
        final int minNumber = 10;
        final int maxNumber = 100;
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
