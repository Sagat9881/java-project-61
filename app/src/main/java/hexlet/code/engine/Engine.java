package hexlet.code.engine;

import hexlet.code.adapter.ConsoleGameAdapter;
import hexlet.code.adapter.GameAdapter;
import hexlet.code.games.Game;
import hexlet.code.games.greeting.Greeting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static hexlet.code.engine.EngineContext.*;
import static java.util.stream.Collectors.toMap;

public class Engine {
    public static final String NO = "n";
    public static final String YES = "y";
    public static final String JOHN_DOE = "John Doe";

    private Map<String, Game> gamesMap;
    private final Map<String, Consumer<Engine>> commands = new HashMap<>();

    private EngineContext context;
    private GameAdapter cli;

    private final AtomicBoolean isNotEnd = new AtomicBoolean(true);

    public static Engine ofDefault() {
        return Engine.of(games);
    }

    public static Engine of(List<Game> games) {
        Engine engine = new Engine();
        engine.gamesMap = new HashMap<>( // avoid immutable
                IntStream.range(0, games.size()).boxed()
                        .collect(toMap(i -> String.valueOf(i + 1), games::get)));
        return engine;
    }

    public Engine up() {
        return up(new ConsoleGameAdapter());
    }

    public Engine up(GameAdapter cli) {
        this.context = new EngineContext(new GameSelector(this.gamesMap));
        this.cli = cli;
        commands.put(EXIT_KEY, (s) -> s.isNotEnd.set(false));

        cli.setIn(new BufferedReader(new InputStreamReader(System.in)));
        cli.setOut(System.out);

        cli.println("Welcome to the Brain Games!");
        return this;
    }

    private void doStart() {
        cli.println(context.printSelect());
        final String userAnswer = cli.readInput(true);

        if (commands.containsKey(userAnswer)) {
            commands.get(userAnswer).accept(this);
            return;
        }

        if (JOHN_DOE.equals(currentPlayer.get().name())) {
            start(Greeting.class);
        }

        context.selectByKey(userAnswer);
        doGameplay();
    }

    public void start() {
        doStart();
        printGoodbye();
    }


    public void start(Class<? extends Game> game) {
        start(game.getSimpleName());
    }

    private void start(String game) {
        context.selectByName(game);
        doGameplay();
    }

    private void printGoodbye() {
        cli.println("Good bye, %s!".formatted(currentPlayer.get().name()));
    }

    private void doGameplay() {
        for (int count = 0; (count < context.currentGame().attempts()) && isNotEnd.get(); count++) {
            cli.println
                    (context.currentGame()
                            .generateQuest()
                            .question()
                    );

            final String input = cli.readInput();
            cli.println("Your answer: %s".formatted(input));

            if (context.currentGame().isWin(input)) {
                cli.println(context.currentGame().congratulations(input));
            } else {
                cli.println(context.currentGame().failure(input));
                cli.println("Let's try again, %s!".formatted(currentPlayer.get().name()));
            }
        }
    }

}


