package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Progression {
    public static boolean startGame(Scanner sc, String userName) {
        System.out.println("What number is missing in the progression?");
        Random rnd = new Random();
        int minLength = 5;
        int maxLength = 10;
        int countProgression = rnd.nextInt(minLength, maxLength);
        int hideElement = rnd.nextInt(countProgression);
        int startProgression = rnd.nextInt(maxLength);
        int stepProgression = rnd.nextInt(maxLength);
        StringBuilder stringProgression = new StringBuilder();
        stringProgression.append(" " + startProgression);
        int temp = startProgression + stepProgression;
        int answer = 0;
        for (int i = 0; i < countProgression; i++) {
            if (i != hideElement) {
                stringProgression.append(" " + temp);
            } else {
                stringProgression.append(" ..");
                answer = temp;
            }
            temp += stepProgression;
        }
        System.out.print("Question:" + stringProgression.toString() + "\nYour answer: ");
        int userAnswer = sc.nextInt();
        boolean checkAnswer = (userAnswer == answer);
        if (!checkAnswer) {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                    + " %s!", userAnswer, answer, userName));
        }
        return checkAnswer;
    }
}
