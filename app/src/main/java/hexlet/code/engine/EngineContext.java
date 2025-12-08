package hexlet.code.engine;

import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Greeting;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class EngineContext {
    public static List<Game> games = List.of(new Greeting(), new Even());
    public static ThreadLocal<Player> currentPlayer = ThreadLocal.withInitial(() -> new Player("John Doe"));
    static AtomicLong count = new AtomicLong(0);
    private final GameSelector selector;

    public EngineContext(GameSelector selector) {
        this.selector = selector;
    }

    public Game currentGame() {
        return selector.selectCurrent();
    }

    public String select() {
        return selector.select();
    }

    public Game select(Integer key) {
        return selector.select(key);
    }
    public Game select(String key) {
        return selector.select(key);
    }

}
