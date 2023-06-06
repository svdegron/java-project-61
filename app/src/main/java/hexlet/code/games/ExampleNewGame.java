package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class ExampleNewGame {
    // Класс игры: В цикле генерируем вопрос и ответ (двумерный массив - строк)
    // В движок передается:
    // 1. Массив
    // 2. Описание игры
    // + Добавить класс игры:
    // 1. Генерирует вопросы
    // 2. Вызывает движок
    // ? Дополнительная строка меню: похоже отдельно ручками, а не в самом классе игры
    public static void begin(Scanner scanner) {
        final String description = "Описание игры примера.";
        final int countRounds = 3;
        final int structure = 2;
        String[][] content = new String[countRounds][structure];
        final int question = 0;
        final int answer = 1;
        Random generate = new Random();
        final int maxNumber = 100;
        // Генерируем вопрос-ответ
        for (int round = 0; round < countRounds; round++) {
            content[round][question] = String.format("Question: %s\nYour answer: ", generate.nextInt(maxNumber));
            content[round][answer] = "Правильный ответ строкой";
        }
        // Вызываем основную логику - движок игры
        Engine.start(content, description, scanner);
    }
}
