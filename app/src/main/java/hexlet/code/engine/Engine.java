package hexlet.code.engine;

import hexlet.code.adapter.ConsoleGameAdapter;
import hexlet.code.adapter.GameAdapter;
import hexlet.code.engine.interceptors.in.CommandInputInterceptor;
import hexlet.code.engine.interceptors.in.GreetingInterceptor;
import hexlet.code.engine.interceptors.in.InputInterceptor;
import hexlet.code.engine.interceptors.in.InterceptorChain;
import hexlet.code.games.Game;
import hexlet.code.utils.Chain;
import hexlet.code.utils.EngineHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static hexlet.code.engine.EngineContext.*;
import static hexlet.code.utils.EngineHelper.buildGamesMap;

public class Engine {
    public static final String NO = "no";
    public static final String YES = "yes";
    public static final String JOHN_DOE = "John Doe";

    private Map<String, Game> gamesMap;
    private Map<String, Consumer<Engine>> commands;
    private InterceptorChain inputInterceptors;
    private EngineContext context;
    private GameAdapter cli;

    private final AtomicBoolean isNotEnd = new AtomicBoolean(true);

    public static Engine ofDefault() {
        return Engine.of(games);
    }

    public static Engine of(List<Game> games) {
        Engine engine = new Engine();
        engine.gamesMap = buildGamesMap(games);
        engine.commands = new HashMap<>();
        return engine;
    }

    public Engine up() {
        return up(
                new ConsoleGameAdapter(),
                Chain.of(
                        new GreetingInterceptor(this),
                        new CommandInputInterceptor(this.commands, this))
        );
    }

    public Engine up(GameAdapter cli, Chain<InputInterceptor> inputInterceptors) {
        this.inputInterceptors = InterceptorChain.ofDelegateChain(inputInterceptors);
        this.cli = cli;

        this.context = new EngineContext(new GameSelector(this.gamesMap));
        commands.put(EXIT_KEY, (s) -> s.isNotEnd.set(false));

        cli.setIn(new BufferedReader(new InputStreamReader(System.in)));
        cli.setOut(System.out);

        return this;
    }

    public void start() {
        doStart();
        printGoodbye();
    }

    public void start(Class<? extends Game> game) {
        startByName(game.getSimpleName());
    }

    private void startByName(String game) {
        context.selectByName(game);
        doGameplay();
    }

    private void doStart() {
        cli.println(context.printSelect());

        cli.print("Your choice: ");
        String answer = cli.readInput(true);
        cli.println("Welcome to the Brain Games!");

        final String interceptedAnswer = inputInterceptors.process(answer);
        if (!interceptedAnswer.isBlank()) {
            context.selectByKey(interceptedAnswer);
            doGameplay();
        }
    }

    private void doGameplay() {
        for (int count = 0; (count < context.currentGame().attempts()) && isNotEnd.get(); count++) {
            cli.println
                    (context.currentGame()
                            .generateQuest()
                            .question()
                    );

            final String userAnswer = cli.readInput();
            cli.println("Your answer: %s".formatted(userAnswer));

            if (context.currentGame().isWin(userAnswer)) {
                cli.println(context.currentGame().congratulations(userAnswer));
            } else {
                cli.println(context.currentGame().failure(userAnswer));
                cli.println("Let's try again, %s!".formatted(currentPlayer.get().name()));
            }
        }
    }

    private void printGoodbye() {
        cli.println("Good bye, %s!".formatted(currentPlayer.get().name()));
    }
}


