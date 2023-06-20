package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Eval {
    public static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static String[] generateRoundData() {
        int num = Utils.randomNum();
        String[] dataset = new String[Engine.COUNT_DATA];

        dataset[Engine.QUESTION] = Integer.toString(num);
        dataset[Engine.ANSWER] = isEven(num) ? "yes" : "no";

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
