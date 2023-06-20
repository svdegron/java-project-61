package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String DESCRIPTION = "What number is missing in the progression?";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 10;

    public static String[] getProgression(int num, int step, int length) {
        String[] numbers = new String[length];

        for (int index = 0; index < length; index++) {
            numbers[index] = Integer.toString(num + step * index);
        }

        return numbers;
    }

    public static String[] generateRoundData() {
        int length = Utils.randomNum(MIN_LENGTH, MAX_LENGTH);
        String[] progression = getProgression(Utils.randomNum(Engine.MAX_NUMBER), Utils.randomNum(), length);
        String[] dataset = new String[Engine.COUNT_DATA];
        StringBuilder line = new StringBuilder();
        String hide = progression[length - Utils.randomNum(length) - 1];

        for (String num: progression) {
            if (hide.equals(num)) {
                line.append(".. ");
            } else {
                line.append(num + " ");
            }
        }

        dataset[Engine.QUESTION] = line.toString().replaceAll(".$", "");
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
