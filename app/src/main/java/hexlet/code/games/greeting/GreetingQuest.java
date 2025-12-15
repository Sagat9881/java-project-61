package hexlet.code.games.greeting;

import hexlet.code.games.Quest;

public class GreetingQuest extends Quest {

    public GreetingQuest() {
        super("May I have your name?", "", (string) -> true);
    }

}
