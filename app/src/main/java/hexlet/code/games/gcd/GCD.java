package hexlet.code.games.gcd;

import hexlet.code.games.SimpleGame;
import hexlet.code.games.Quest;

public class GCD extends SimpleGame {

    public GCD() {
        super(new GCDQuest());
    }

    @Override
    public Quest generateQuest() {
        super.quest = new GCDQuest();
        return quest;
    }

}
