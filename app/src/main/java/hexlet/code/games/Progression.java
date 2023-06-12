package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

public class Progression {
    public static final String DESCRIPTION = "What number is missing in the progression?";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 10;

    public static void begin() {
        Scanner scanner = new Scanner(System.in);
        String[][] contents = new String[Engine.COUNT_ROUNDS][Engine.COUNT_DATA];

        // Генерируем вопрос-ответ
        for (int round = 0; round < Engine.COUNT_ROUNDS; round++) {

            int progressionBegin = Utils.randomNum(MAX_LENGTH);
            int progressionStep = Utils.randomNum(Engine.MAX_NUMBER);
            int progressionLength = Utils.randomNum(MIN_LENGTH, MAX_LENGTH);
            StringBuilder progressionLine = new StringBuilder();

            progressionLine.append(" " + progressionBegin);

            int hide = Utils.randomNum(progressionLength);
            int temp = progressionBegin + progressionStep;

            for (int next = 0; next < progressionLength; next++) {
                if (next != hide) {
                    progressionLine.append(" " + temp);
                } else {
                    progressionLine.append(" ..");
                    contents[round][Engine.ANSWER] = String.valueOf(temp);
                }

                temp += progressionStep;
            }

            contents[round][Engine.QUESTION] = String.format("Question:%s\nYour answer: ", progressionLine.toString());
        }

        // Вызываем основную логику - движок игры
        Engine.start(contents, DESCRIPTION);
    }
}
