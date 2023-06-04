package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greeting(Scanner sc) {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = sc.next();
        System.out.println(String.format("Hello, %s!", userName));
        return userName;
    }
}
