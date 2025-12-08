package hexlet.code.games;

import hexlet.code.games.quest.Quest;

public interface Game {
    String name();

    Quest quest();

    default boolean isWin(String request) {
        return quest().matcher().test(request);
    }

    default String answer() {
        return quest().answer();
    }
}
