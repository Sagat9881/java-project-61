package hexlet.code.games.prime;

import hexlet.code.games.SimpleGame;
import hexlet.code.games.Quest;

public class Prime extends SimpleGame {
    public Prime() {
        super(new PrimeQuest());
    }

    @Override
    public Quest generateQuest() {
        super.quest = new PrimeQuest();
        return super.quest;
    }
}
