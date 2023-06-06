package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression {
    public static void begin(Scanner scanner) {
        final String description = "What number is missing in the progression?";
        final int countRounds = 3;
        final int structure = 2;
        String[][] content = new String[countRounds][structure];
        final int question = 0;
        final int answer = 1;
        Random generate = new Random();
        final int maxNumber = 100;
        final int minLength = 5;
        final int maxLength = 10;

        // Генерируем вопрос-ответ
        for (int round = 0; round < countRounds; round++) {
            int progressionBegin = generate.nextInt(maxLength);
            int progressionStep = generate.nextInt(maxLength);
            int progressionLength = generate.nextInt(minLength, maxLength);
            StringBuilder progressionLine = new StringBuilder();

            progressionLine.append(" " + progressionBegin);

            int hide = generate.nextInt(progressionLength);
            int temp = progressionBegin + progressionStep;

            for (int next = 0; next < progressionLength; next++) {
                if (next != hide) {
                    progressionLine.append(" " + temp);
                } else {
                    progressionLine.append(" ..");
                    content[round][answer] = String.valueOf(temp);
                }

                temp += progressionStep;
            }

            content[round][question] = String.format("Question: %s\nYour answer: ", progressionLine.toString());
        }

        // Вызываем основную логику - движок игры
        Engine.start(content, description, scanner);
    }
}
