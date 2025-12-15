package hexlet.code.games.math;

import hexlet.code.games.SimpleGame;
import hexlet.code.games.Quest;

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
