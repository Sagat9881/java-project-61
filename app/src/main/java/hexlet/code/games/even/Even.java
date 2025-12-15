package hexlet.code.games.even;

import hexlet.code.games.SimpleGame;
import hexlet.code.games.Quest;

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
