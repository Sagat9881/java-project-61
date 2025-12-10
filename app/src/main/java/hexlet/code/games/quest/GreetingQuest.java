package hexlet.code.games.quest;

public class GreetingQuest extends Quest {
    private static String welcome = "Welcome to the Brain Games!";
    private static String askName = "May I have your name?";

    public GreetingQuest() {
        super(String.join("\n", welcome, askName), "", (string) -> true);
    }

}
