package hexlet.code.engine;

import hexlet.code.games.Game;
import hexlet.code.games.quest.Quest;
import hexlet.code.utils.Cli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

import static hexlet.code.engine.EngineContext.count;
import static hexlet.code.engine.EngineContext.currentPlayer;
import static java.util.stream.Collectors.toMap;

public class Engine {
    public static final String EXIT = "e";
    private Map<Integer, Game> gamesMap;
    private final Map<String, Consumer<Engine>> commands = new HashMap<>();
    private Integer maxAttempts = 3;
    private EngineContext context;
    private final AtomicBoolean isEnd = new AtomicBoolean(false);

    public static Engine of(List<Game> games) {
        Engine engine = new Engine();
        engine.gamesMap = new HashMap<>( // avoid immutable
                IntStream.range(0, games.size()).boxed()
                        .collect(toMap(Function.identity(), games::get)));
        return engine;
    }

    public Engine up() {
        this.context = new EngineContext(new GameSelector(this.gamesMap));
        commands.put(EXIT, (s) -> s.isEnd.set(true));
        Cli.println("Welcome to the Brain Games!");
        return this;
    }

    public void start() {
        Cli.println(context.select());
        context.select(Cli.readInt());
        doGameplay();
    }

    public void start(Game game) {
        context.select(game.name());
        doGameplay();
    }

    private void doGameplay() {
        Quest quest = context.currentGame().quest();
        Cli.println(quest.question());

        while (!isEnd.get()) {
            final String input = Cli.readLine();

            if (commands.containsKey(input)) {
                commands.get(input).accept(this);
            } else {
                if (maxAttempts > count.incrementAndGet()) {
                    Cli.println("Your answer is: %s".formatted(input));
                    Cli.println(context.currentGame().quest().answer());

                    if (context.currentGame().isWin(input)) {
                        Cli.println("Correct!");
                        start();
                    } else {
                        Cli.println("Let's try again, %s!".formatted(currentPlayer.get().name()));
                    }
                } else {
                    Cli.println("Too many attempts!");
                    start();
                }
            }
        }

        Cli.println("good bye, %s!".formatted(currentPlayer.get().name()));
    }

}
