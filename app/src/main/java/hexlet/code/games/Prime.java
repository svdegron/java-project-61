package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;
import java.util.Scanner;

public class Prime {
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static String isPrime(int num) {
        if (num == 0 || num == 1) {
            return "no";
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return "no";
            }
        }

        return "yes";
    }

    public static void begin() {
        Scanner scanner = new Scanner(System.in);
        String[][] content = new String[Engine.COUNT_ROUNDS][Engine.COUNT_DATA];

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {
            int currentNumber = Utils.randomNum();

            content[round][Engine.QUESTION] = String.format("Question: %s\nYour answer: ", currentNumber);
            content[round][Engine.ANSWER] = isPrime(currentNumber);
        }

        // Вызываем основную логику - движок игры
        Engine.start(content, DESCRIPTION);
    }
}
