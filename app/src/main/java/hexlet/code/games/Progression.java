package hexlet.code.games;

import hexlet.code.games.quest.ProgressionQuest;
import hexlet.code.games.quest.Quest;

public class Progression extends SimpleGame{

    public Progression() {
        super(new ProgressionQuest());
    }

    @Override
    public Quest generateQuest() {
        super.quest = new ProgressionQuest();
        return super.quest;
    }
}
