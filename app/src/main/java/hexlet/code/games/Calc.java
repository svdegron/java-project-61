package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final String DESCRIPTION = "What is the result of the expression?";
    public static final char[] OPERATIONS = new char[] {'+', '-', '*'};
    public static final int PROBABILITY = OPERATIONS.length;

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
        int num1 = Utils.randomNum();
        int num2 = Utils.randomNum();
        String[] dataset = new String[Engine.COUNT_DATA];

        char operation = OPERATIONS[Utils.randomNum(PROBABILITY) % PROBABILITY];

        dataset[Engine.QUESTION] = String.format("Question: %s %s %s\nYour answer: ", num1, operation, num2);
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
