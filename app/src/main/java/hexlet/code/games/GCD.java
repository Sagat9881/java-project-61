package hexlet.code.games;

import hexlet.code.games.quest.GCDQuest;
import hexlet.code.games.quest.Quest;

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
