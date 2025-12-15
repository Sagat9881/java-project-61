package hexlet.code.engine;

import hexlet.code.adapter.GameAdapter;
import hexlet.code.games.Game;

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
    private Map<String, Game> gamesMap;
    private final Map<String, Consumer<Engine>> commands = new HashMap<>();

    private final Integer maxAttempts = 3;

    private EngineContext context;
    private GameAdapter cli;

    private final AtomicBoolean isEnd = new AtomicBoolean(false);

    public static Engine of(List<Game> games) {
        Engine engine = new Engine();
        engine.gamesMap = new HashMap<>( // avoid immutable
                IntStream.range(0, games.size()).boxed()
                        .collect(toMap(i -> String.valueOf(i + 1), games::get)));
        return engine;
    }

    public Engine up(GameAdapter cli) {
        this.context = new EngineContext(new GameSelector(this.gamesMap));
        this.cli = cli;
        commands.put(EXIT, (s) -> s.isEnd.set(true));

        cli.setIn(new BufferedReader(new InputStreamReader(System.in)));
        cli.setOut(System.out);

        cli.println("Welcome to the Brain Games!");
        return this;
    }

    public void reStart() {
        cli.println(context.printSelect());
        final String input = cli.readInput(true);

        if (commands.containsKey(input)) {
            commands.get(input).accept(this);
            return;
        }

        if(input.isBlank()){
            commands.get(EXIT).accept(this);
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

        cli.println("Good bye, %s!".formatted(currentPlayer.get().name()));
    }

    private void doGameplay() {
        while (!isEnd.get()) {
            if (maxAttempts >= count.incrementAndGet()) {
                cli.println
                        (context.currentGame()
                                .generateQuest()
                                .question()
                        );

                final String input = cli.readInput();
                cli.println("Your answer is: %s".formatted(input));

                if (context.currentGame().isWin(input)) {
                    cli.println(context.currentGame().congratulations(input));
                    reStart();
                } else {
                    cli.println(context.currentGame().failure(input));
                    cli.println("Let's try again, %s!".formatted(currentPlayer.get().name()));
                }

            } else {
                cli.println("Too many attempts!");
                reStart();
            }
        }
    }

}


