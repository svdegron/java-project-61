package hexlet.code.games;

public interface Game {
    boolean launch();
    void printDescription();
    void printError();
    String getPlayerName();
}
