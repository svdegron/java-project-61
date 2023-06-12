package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void begin() {
        String[][] contents = new String[Engine.COUNT_ROUNDS][Engine.COUNT_DATA];

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {

            int num1 = Utils.randomNum();
            int num2 = Utils.randomNum();

            contents[round][Engine.QUESTION] = String.format("Question: %s %s\nYour answer: ", num1, num2);

            int max = Math.max(num1, num2);
            int min = Math.min(num1, num2);
            int gcd = 0;

            do {
                gcd = max % min;
                max = min;
                min = gcd;
            } while (gcd != 0);

            contents[round][Engine.ANSWER] = String.valueOf(max);
        }
        // Вызываем основную логику - движок игры
        Engine.start(contents, DESCRIPTION);
    }
}
