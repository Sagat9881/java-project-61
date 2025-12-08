package hexlet.code.engine;

import hexlet.code.games.Game;

import java.util.concurrent.atomic.AtomicLong;

public class EngineContext {
   public static ThreadLocal<Player> currentPlayer = new ThreadLocal<>();
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

    public Game select(String key) {
        return selector.select(key);
    }

}
