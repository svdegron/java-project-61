package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    public static final String DESCRIPTION = "What is the result of the expression?";
    public static final int MAX_NUMBER = 10;
    public static final int PROBABILITY = 3;
    public static final char[] OPERATIONS = new char[] {'+', '-', '*'};

    public static String resultExpression(char operation, int num1, int num2) {
        if (operation == '-') {
            return String.valueOf(num1 - num2);
        } else if (operation == '*') {
            return String.valueOf(num1 * num2);
        } else {
            // потому что сложить проще всего
            return String.valueOf(num1 + num2);
        }
    }

    public static String[] generateRoundData() {
        String[] dataset = new String[Engine.COUNT_DATA];
        Random generate = new Random();

        char operation = OPERATIONS[generate.nextInt(PROBABILITY) % PROBABILITY];
        int num1 = generate.nextInt(MAX_NUMBER);
        int num2 = generate.nextInt(MAX_NUMBER);
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
