package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static int gcdBy(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        // После вычисления остатка num2 всегда больше num1
        return gcdBy(num2, num1 % num2);
    }

    public static String[] generateRoundData(int num1, int num2) {
        String[] dataset = new String[Engine.COUNT_DATA];

        dataset[Engine.QUESTION] = String.format("Question: %s %s\nYour answer: ", num1, num2);
        dataset[Engine.ANSWER] = String.valueOf(gcdBy(num1, num2));

        return dataset;
    }

    public static void begin() {
        String[][] contents = new String[Engine.COUNT_ROUNDS][];

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {
            contents[round] = generateRoundData(Utils.randomNum(), Utils.randomNum());
        }
        // Вызываем основную логику - движок игры
        Engine.start(contents, DESCRIPTION);
    }
}
