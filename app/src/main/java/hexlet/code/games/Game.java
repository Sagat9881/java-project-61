package hexlet.code.games;

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
