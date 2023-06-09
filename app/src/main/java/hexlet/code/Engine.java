package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void start(String[][] contents, String description) {
        Scanner scanner = new Scanner(System.in);

        String userName = Cli.greeting();

        System.out.println(description);

        for (String[] content: contents) {
            final int question = 0;
            final int answer = 1;

            System.out.print(content[question]);

            String userAnswer = scanner.next();

            if (userAnswer.equals(content[answer])) {
                System.out.println("Correct!");
            } else {
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                        + " %s!", userAnswer, content[answer], userName));
                return;
            }
        }

        System.out.println(String.format("Congratulations, %s!", userName));
    }
}
