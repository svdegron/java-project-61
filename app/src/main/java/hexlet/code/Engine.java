package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int COUNT_ROUNDS = 3;
    public static final int COUNT_DATA = 2;
    public static final int QUESTION = 0;
    public static final int ANSWER = 1;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 100;

    public static void start(String[][] contents, String description) {
        Scanner scanner = new Scanner(System.in);

        String userName = Cli.greeting();

        System.out.println(description);

        for (String[] content: contents) {
            System.out.print(String.format("Question: %s\nYour answer: ", content[QUESTION]));

            String userAnswer = scanner.next();

            if (userAnswer.equals(content[ANSWER])) {
                System.out.println("Correct!");
            } else {
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                        + " %s!", userAnswer, content[ANSWER], userName));
                return;
            }
        }

        System.out.println(String.format("Congratulations, %s!", userName));
    }
}
