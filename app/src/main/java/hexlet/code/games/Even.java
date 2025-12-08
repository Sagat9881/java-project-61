package hexlet.code.games;

import hexlet.code.games.quest.EvenQuest;
import hexlet.code.games.quest.Quest;

public class Even implements Game {
    private int value;
    private EvenQuest quest;

    @Override
    public String name() {
        return "Even";
    }

    @Override
    public boolean isWin(String request) {
        return Game.super.isWin(request);
    }

    @Override
    public Quest quest() {
        this.quest = new EvenQuest();
        return quest;
    }
}
