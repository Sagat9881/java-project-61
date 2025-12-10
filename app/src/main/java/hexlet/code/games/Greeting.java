package hexlet.code.games;

import hexlet.code.engine.Player;
import hexlet.code.games.quest.GreetingQuest;
import hexlet.code.games.quest.Quest;

import static hexlet.code.engine.EngineContext.currentPlayer;

public class Greeting extends SimpleGame {

    @Override
    public String congratulations(String answer) {
        currentPlayer.set(new Player(answer));
        return "Hellow, %s!".formatted(answer);
    }

    public Greeting() {
        super(new GreetingQuest());
    }

    @Override
    public Quest generateQuest() {
        return quest;
    }
}
