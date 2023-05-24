package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");

        Cli.greeting();

        String userName = scanner.next();
        Cli user = new Cli(userName);

        System.out.println(String.format("Hello, %s!", user.getName()));

        scanner.close();
    }
}
