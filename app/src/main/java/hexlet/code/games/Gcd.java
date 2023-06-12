package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;
import java.util.Scanner;

public class Gcd {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void begin() {
        Scanner scanner = new Scanner(System.in);
        String[][] contents = new String[Engine.COUNT_ROUNDS][Engine.COUNT_DATA];

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {

            int firstNumber = Utils.randomNum();
            int secondNumber = Utils.randomNum();

            contents[round][Engine.QUESTION] = String.format("Question: %s %s\nYour answer: ", firstNumber, secondNumber);

            int max = Math.max(firstNumber, secondNumber);
            int min = Math.min(firstNumber, secondNumber);
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
