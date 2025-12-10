package hexlet.code.games;

import hexlet.code.games.quest.Quest;

public interface Game {
    String name();
    String congratulations(String answer);
    String failure(String answer);

    Quest generateQuest();

    Quest currentQuest();

    default boolean isWin(String request) {
        return currentQuest().matcher().test(request);
    }

    default String answer() {
        return currentQuest().answer();
    }

}
