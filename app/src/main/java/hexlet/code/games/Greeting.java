package hexlet.code.games;

import hexlet.code.engine.Player;
import hexlet.code.games.quest.GreetingQuest;
import hexlet.code.games.quest.Quest;

import static hexlet.code.engine.EngineContext.currentPlayer;

public class Greeting implements Game {
    private final Quest quest;

    @Override
    public boolean isWin(String request) {
        currentPlayer.set(new Player(request));
        return Game.super.isWin(request);
    }

    public Greeting() {
        quest = new GreetingQuest();
    }

    @Override
    public String name() {
        return "Greeting";
    }


    @Override
    public Quest quest() {
        return quest;
    }
}
