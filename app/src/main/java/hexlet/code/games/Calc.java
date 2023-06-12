package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Calc {
    public static final String DESCRIPTION = "What is the result of the expression?";
    public static final int PROBABILITY = 3;
    public static final char[] OPERATIONS = new char[] {'+', '-', '*'};

    public static String resultExpression(char operation, int num1, int num2) {
        if (operation == '+') {
            return String.valueOf(num1 + num2);
        } else if (operation == '-') {
            return String.valueOf(num1 - num2);
        } else if (operation == '*') {
            return String.valueOf(num1 * num2);
        } else {
            throw new Error(String.format("Unknown operation \"%s\"!", operation));
        }
    }

    public static String[] generateRoundData() {
        String[] dataset = new String[Engine.COUNT_DATA];
        Random generate = new Random();

        char operation = OPERATIONS[generate.nextInt(PROBABILITY) % PROBABILITY];
        int num1 = generate.nextInt(Utils.randomNum());
        int num2 = generate.nextInt(Utils.randomNum());
        String expression = String.format("%s %s %s", num1, operation, num2);

        dataset[Engine.QUESTION] = String.format("Question: %s\nYour answer: ", expression);
        dataset[Engine.ANSWER] = resultExpression(operation, num1, num2);

        return dataset;
    }

    public static void begin() {
        String[][] contents = new String[Engine.COUNT_ROUNDS][];

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {
            contents[round] = generateRoundData();
        }

        // Вызываем основную логику - движок игры
        Engine.start(contents, DESCRIPTION);
    }
}
