package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Eval {
    public static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int MAX_NUMBER = 100;

    public static String isEven(int num) {
        if (num % 2 == 0) {
            return "yes";
        }

        return "no";
    }

    public static String[] generateRoundData(int num) {
        String[] dataset = new String[Engine.COUNT_DATA];

        dataset[Engine.QUESTION] = String.format("Question: %s\nYour answer: ", num);
        dataset[Engine.ANSWER] = isEven(num);

        return dataset;
    }

    public static void begin() {
        Scanner scanner = new Scanner(System.in);
        String[][] contents = new String[Engine.COUNT_ROUNDS][];
        Random generate = new Random();

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {
            contents[round] = generateRoundData(generate.nextInt(MAX_NUMBER));
        }

        // Вызываем основную логику - движок игры
        Engine.start(contents, DESCRIPTION);
    }
}
