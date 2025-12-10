package hexlet.code.games;

import hexlet.code.games.quest.PrimeQuest;
import hexlet.code.games.quest.Quest;

public class Prime extends SimpleGame{
    public Prime() {
        super(new PrimeQuest());
    }

    @Override
    public Quest generateQuest() {
        super.quest = new PrimeQuest();
        return super.quest;
    }
}
