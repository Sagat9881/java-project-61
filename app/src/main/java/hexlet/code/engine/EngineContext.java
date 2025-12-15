package hexlet.code.engine;

import hexlet.code.games.gcd.GCD;
import hexlet.code.games.math.Math;
import hexlet.code.games.*;
import hexlet.code.games.even.Even;
import hexlet.code.games.greeting.Greeting;
import hexlet.code.games.prime.Prime;
import hexlet.code.games.progression.Progression;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class EngineContext {
    public static final String EXIT = "0";
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
