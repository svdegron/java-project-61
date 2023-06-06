package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Eval {
    public static void begin(Scanner scanner) {
        final String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        final int countRounds = 3;
        final int structure = 2;
        String[][] content = new String[countRounds][structure];
        final int question = 0;
        final int answer = 1;
        Random generate = new Random();
        final int maxNumber = 100;

        // Генерируем вопрос-ответ
        for (int round = 0; round < countRounds; round++) {
            int currentNumber = generate.nextInt(maxNumber);

            content[round][question] = String.format("Question: %s\nYour answer: ", currentNumber);

            if (currentNumber % 2 == 0) {
                content[round][answer] = "yes";
            } else {
                content[round][answer] = "no";
            }
        }

        // Вызываем основную логику - движок игры
        Engine.start(content, description, scanner);
    }
    public static boolean startGame(Scanner sc, String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random rnd = new Random();
        final int maxNum = 100;
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
