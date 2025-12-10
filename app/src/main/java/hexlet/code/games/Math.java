package hexlet.code.games;

import hexlet.code.games.quest.MathQuest;
import hexlet.code.games.quest.Quest;

public class Math extends SimpleGame {

    public Math() {
        super(new MathQuest());
    }

    @Override
    public Quest generateQuest() {
        super.quest = new MathQuest();
        return super.quest;
    }

}
