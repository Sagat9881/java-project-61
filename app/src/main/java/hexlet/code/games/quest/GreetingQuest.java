package hexlet.code.games.quest;

import hexlet.code.engine.Engine;
import hexlet.code.engine.Player;

import static hexlet.code.engine.EngineContext.currentPlayer;

public class GreetingQuest extends Quest {
    private static String welcome = "Welcome to the Brain Games!";
    private static String askName = "May I have your name?";

    public GreetingQuest() {
        super(String.join("\n", welcome, askName), "", (string) -> true);
    }

    @Override
    public String answer() {
        Player player = currentPlayer.get();
        return "Hellow, %s!".formatted(player.name());
    }
}
