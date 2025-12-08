package hexlet.code;

public class Main {
    public static void main(String[] args) {
        Cli.print("Welcome to the Brain Games!");
        Cli.print("May I have your name?");
        Cli.print("Hello, %s!".formatted(Cli.read()));
    }
}