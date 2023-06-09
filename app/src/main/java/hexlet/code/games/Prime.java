package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Prime {
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
        final String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        final int countRounds = 3;
        final int structure = 2;
        String[][] content = new String[countRounds][structure];
        final int question = 0;
        final int answer = 1;
        Random generate = new Random();
        final int maxNumber = 100;

        // Генерируем вопрос-ответ
        for (int round = 0; round < countRounds; round++) {
            int currentNumber = generate.nextInt(maxNumber);

            content[round][question] = String.format("Question: %s\nYour answer: ", currentNumber);
            content[round][answer] = isPrime(currentNumber);
        }

        // Вызываем основную логику - движок игры
        Engine.start(content, description);
    }
}
