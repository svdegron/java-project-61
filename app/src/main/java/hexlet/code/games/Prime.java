package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

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

    public static String[] generateRoundData(int num) {
        String[] dataset = new String[Engine.COUNT_DATA];

        dataset[Engine.QUESTION] = String.format("Question: %s\nYour answer: ", num);
        dataset[Engine.ANSWER] = isPrime(num);

        return dataset;
    }

    public static void begin() {
        String[][] contents = new String[Engine.COUNT_ROUNDS][];

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {
            contents[round] = generateRoundData(Utils.randomNum(Engine.MAX_NUMBER));
        }

        // Вызываем основную логику - движок игры
        Engine.start(contents, DESCRIPTION);
    }
}
