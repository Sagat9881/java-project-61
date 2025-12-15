package hexlet.code.games;

public interface Game {
    String name();
    int attempts();

    String congratulations(String answerRequest);
    String failure(String answerRequest);

    Quest generateQuest();
    Quest currentQuest();

    default boolean isWin(String request) {
        return currentQuest().matcher().test(request);
    }
}
