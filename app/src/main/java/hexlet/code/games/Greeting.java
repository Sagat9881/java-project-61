package hexlet.code.games;

import hexlet.code.games.quest.GreetingQuest;
import hexlet.code.games.quest.Quest;

public class Greeting extends SimpleGame {

    public Greeting() {
        super(new GreetingQuest());
    }

    @Override
    public Quest generateQuest() {
        return quest;
    }
}
