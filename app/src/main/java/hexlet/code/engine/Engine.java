package hexlet.code.engine;

import hexlet.code.games.Game;
import hexlet.code.games.quest.Quest;
import hexlet.code.utils.Cli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static hexlet.code.engine.EngineContext.count;
import static hexlet.code.engine.EngineContext.currentPlayer;
import static java.util.stream.Collectors.toMap;

public class Engine {
    public static final String EXIT = "0";
    private Map<String, Game> gamesMap;
    private final Map<String, Consumer<Engine>> commands = new HashMap<>();

    private final Integer maxAttempts = 3;

    private EngineContext context;

    private final AtomicBoolean isEnd = new AtomicBoolean(false);

    public static Engine of(List<Game> games) {
        Engine engine = new Engine();
        engine.gamesMap = new HashMap<>( // avoid immutable
                IntStream.range(0, games.size()).boxed()
                        .collect(toMap(i -> String.valueOf(i + 1), games::get)));
        return engine;
    }

    public Engine up() {
        this.context = new EngineContext(new GameSelector(this.gamesMap));
        commands.put(EXIT, (s) -> s.isEnd.set(true));
        Cli.println("Welcome to the Brain Games!");
        return this;
    }

    public void start() {
        Cli.println(context.printSelect());
        final String input = Cli.readLine();
        if (commands.containsKey(input)) {
            commands.get(input).accept(this);
            return;
        }
        context.select(input);
        count.set(0);
        doGameplay();
    }

    public void start(Game game) {
        context.selectByName(game.name());
        count.set(0);
        doGameplay();
    }

    private void doGameplay() {
        while (!isEnd.get()) {
            Quest quest = context.currentGame().generateQuest();
            Cli.println(quest.question());

            final String input = Cli.readLine();

            if (commands.containsKey(input)) {
                commands.get(input).accept(this);
            } else {
                if (maxAttempts > count.incrementAndGet()) {
                    Cli.println("Your answer is: %s".formatted(input));

                    if (context.currentGame().isWin(input)) {
                        Cli.println(context.currentGame().congratulations(input));
                        start();
                    } else {
                        Cli.println(context.currentGame().failure(input));
                        Cli.println("Let's try again, %s!".formatted(currentPlayer.get().name()));
                    }
                } else {
                    Cli.println("Too many attempts!");
                    start();
                }
            }
        }

        Cli.println("Good bye, %s!".formatted(currentPlayer.get().name()));
    }

}
