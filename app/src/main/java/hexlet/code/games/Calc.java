package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static void begin(Scanner scanner) {
        final String description = "What is the result of the expression?";
        final int countRounds = 3;
        final int structure = 2;
        String[][] content = new String[countRounds][structure];
        final int question = 0;
        final int answer = 1;
        Random generate = new Random();
        final int maxNumber = 10;

        // Генерируем вопрос-ответ
        for (int round = 0; round < countRounds; round++) {
            int firstNumber = generate.nextInt(maxNumber);
            int secondNumber = generate.nextInt(maxNumber);
            final int probability = 3;
            int chooseOperation = generate.nextInt(maxNumber) % probability;
            String expression = "";
            int result = 0;

            switch (chooseOperation) {
                case 0:
                    expression = String.format("%s + %s", firstNumber, secondNumber);
                    result = firstNumber + secondNumber;
                    break;
                case 1:
                    expression = String.format("%s - %s", firstNumber, secondNumber);
                    result = firstNumber - secondNumber;
                    break;
                case 2:
                    expression = String.format("%s * %s", firstNumber, secondNumber);
                    result = firstNumber * secondNumber;
                    break;
                default:break;
            }

            content[round][question] = String.format("Question: %s\nYour answer: ", expression);
            content[round][answer] = String.valueOf(result);
        }

        // Вызываем основную логику - движок игры
        Engine.start(content, description, scanner);
    }
}
