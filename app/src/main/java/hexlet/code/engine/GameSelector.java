package hexlet.code.engine;

import hexlet.code.games.Game;

import java.util.Map;

import static java.util.stream.Collectors.joining;

public class GameSelector {
    private final String CHOOSE_GAME_STRING;
    private final Map<Integer, Game> gamesMap;
    private static final ThreadLocal<Game> currentGame = new ThreadLocal<>();

    public GameSelector(Map<Integer, Game> gamesMap) {
        this.gamesMap = gamesMap;
        this.CHOOSE_GAME_STRING = this.gamesMap.entrySet()
                .stream()
                .map(e -> "%d - %s".formatted(e.getKey(), e.getValue().name()))
                .collect(joining("\n"));
    }

    public Game select(Integer key) {
        currentGame.set(gamesMap.get(key));
        return currentGame.get();
    }

    public Game select(String key) {
        currentGame.set
                (gamesMap.values()
                        .stream()
                        .filter(g -> key.equals(g.name()))
                        .findAny()
                        .orElse(null)
                );
        return currentGame.get();
    }

    public String select() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append("\n");
        sb.append(CHOOSE_GAME_STRING).append("\n");
        sb.append("Please enter the game number and press Enter.").append("\n");

        return sb.toString();
    }

    public Game selectCurrent() {
        return currentGame.get();
    }
}
