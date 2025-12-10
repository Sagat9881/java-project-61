package hexlet.code.engine;

import hexlet.code.games.Math;
import hexlet.code.games.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class EngineContext {
    public static List<Game> games = List.of(new Greeting(), new Even(),new Math(),new GCD(),new Progression(),new Prime());

    public static ThreadLocal<Player> currentPlayer = ThreadLocal.withInitial(() -> new Player("John Doe"));
    static AtomicLong count = new AtomicLong(0);
    private final GameSelector selector;

    public EngineContext(GameSelector selector) {
        this.selector = selector;
    }

    public Game currentGame() {
        return selector.selectCurrent();
    }

    public String printSelect() {
        return selector.toPrint();
    }

    public Game selectByName(String name) {
        return selector.selectByName(name);
    }
    public Game select(String key) {
        return selector.select(key);
    }

}
