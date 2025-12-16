package hexlet.code.games.greeting;

import hexlet.code.engine.Player;
import hexlet.code.games.Quest;
import hexlet.code.games.SimpleGame;

import static hexlet.code.engine.Engine.JOHN_DOE;
import static hexlet.code.engine.EngineContext.currentPlayer;

public class Greeting extends SimpleGame {

    @Override
    public String congratulations(String answerRequest) {
        currentPlayer.set(new Player(answerRequest));
        return "Hellow, %s!".formatted(answerRequest);
    }

    public Greeting() {
        super(new GreetingQuest());
    }

    @Override
    public Quest generateQuest() {
        return quest;
    }

    @Override
    public int attempts() {
        return JOHN_DOE.equals(currentPlayer.get().name()) ? 1 : 0;
    }
}
