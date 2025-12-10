package hexlet.code.games;

import hexlet.code.games.quest.EvenQuest;
import hexlet.code.games.quest.Quest;

public class Even extends SimpleGame {

    public Even() {
        super(new EvenQuest());
    }

    @Override
    public Quest generateQuest() {
        this.quest = new EvenQuest();
        return quest;
    }

}
