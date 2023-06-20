package hexlet.code;
import hexlet.code.games.Calc;
import hexlet.code.games.Eval;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вывод меню
        printMenu();

        // Выбор игры
        String option = scanner.next();

        switch (option) {
            case "0" -> scanner.close();
            case "1" -> Cli.greeting();
            case "2" -> Eval.begin();
            case "3" -> Calc.begin();
            case "4" -> Gcd.begin();
            case "5" -> Progression.begin();
            case "6" -> Prime.begin();
            default -> throw new RuntimeException("Unknown option: " + option);
        }
    }
    public static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }
}
