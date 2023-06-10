package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    public static final String DESCRIPTION = "What is the result of the expression?";
    public static final int QUESTION = 0;
    public static final int ANSWER = 1;
    public static final int MAX_NUMBER = 10;
    public static final int PROBABILITY = 3;

//    public static final char[] OPERATIONS = new char[] {"Addition", "Subtraction", "Multiplication"};
    public static final char[] OPERATIONS = new char[] {'+', '-', '*'};

    public static String resultExpression(char operation, int firstNum, int secondNum) {
        if (operation == '+') {
            return String.valueOf(firstNum + secondNum);
        } else if (operation == '-') {
            return String.valueOf(firstNum - secondNum);
        } else {
            return String.valueOf(firstNum * secondNum);
        }
    }

    public static String[] generateRoundData() {
        String[] dataset = new String[Engine.COUNT_DATA];
        Random generate = new Random();

        char operation = OPERATIONS[generate.nextInt(PROBABILITY) % PROBABILITY];
        int firstNum = generate.nextInt(MAX_NUMBER);
        int secondNum = generate.nextInt(MAX_NUMBER);
        String expression = String.format("%s %s %s", firstNum, operation, secondNum);

        dataset[QUESTION] = String.format("Question: %s\nYour answer: ", expression);
        dataset[ANSWER] = resultExpression(operation, firstNum, secondNum);

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
