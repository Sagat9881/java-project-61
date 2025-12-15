package hexlet.code.games.progression;

import hexlet.code.games.SimpleGame;
import hexlet.code.games.Quest;

public class Progression extends SimpleGame {

    public Progression() {
        super(new ProgressionQuest());
    }

    @Override
    public Quest generateQuest() {
        super.quest = new ProgressionQuest();
        return super.quest;
    }
}
