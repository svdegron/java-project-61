package hexlet.code;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        Engine.chooseGame(scanner);
        scanner.close();

    }
    public static void printMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Please enter the game number and press Enter.\n");
        menu.append("1 - Greet\n");
        menu.append("2 - Even\n");
        menu.append("3 - Calc\n");
        menu.append("4 - GCD\n");
        menu.append("5 - Progression\n");
        menu.append("6 - Prime\n");
        menu.append("0 - Exit\n");
        menu.append("Your choice: ");
        System.out.print(menu.toString());
    }
}
