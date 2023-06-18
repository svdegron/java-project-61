package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String DESCRIPTION = "What number is missing in the progression?";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 10;

    public static int[] createProgression(int length) {
        int[] numbers = new int[length];
        // шаг не меньше минимального зачения
        int step = Utils.randomNum();
        // начало от 0 до max
        numbers[0] = Utils.randomNum(Engine.MAX_NUMBER);

        for (int index = 1; index < length; index++) {
            numbers[index] = numbers[index - 1] + step;
        }

        return numbers;
    }

    public static String[] generateRoundData() {
        int[] progression = createProgression(Utils.randomNum(MIN_LENGTH, MAX_LENGTH));
        String[] dataset = new String[Engine.COUNT_DATA];
        StringBuilder line = new StringBuilder();
        int hide = progression[progression.length - Utils.randomNum(progression.length) - 1];

        for (int num: progression) {
            if (hide != num) {
                line.append(" " + num);
            } else {
                line.append(" ..");
            }
        }

        dataset[Engine.QUESTION] = String.format("Question:%s\nYour answer: ", line.toString());
        dataset[Engine.ANSWER] = String.valueOf(hide);

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
