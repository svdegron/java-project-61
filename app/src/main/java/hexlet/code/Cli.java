package hexlet.code;

public class Cli {
    public String name;

    Cli() {
    }

    Cli(String name) {
        this.name = name;
    }

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
    }
}
