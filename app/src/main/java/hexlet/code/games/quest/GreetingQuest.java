package hexlet.code.games.quest;

public class GreetingQuest extends Quest {

    public GreetingQuest() {
        super("May I have your name?", "", (string) -> true);
    }

}
