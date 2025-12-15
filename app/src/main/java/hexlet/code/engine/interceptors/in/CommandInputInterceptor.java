package hexlet.code.engine.interceptors.in;

import hexlet.code.engine.Engine;

import java.util.Map;
import java.util.function.Consumer;

public class CommandInputInterceptor implements InputInterceptor {
    private final Map<String, Consumer<Engine>> commands;
    private final Engine engine;

    public CommandInputInterceptor(Map<String, Consumer<Engine>> commands, Engine engine) {
        this.commands = commands;
        this.engine = engine;
    }

    @Override
    public String doIntercept(String input) {
        commands.get(input).accept(engine);
        return input;
    }

    @Override
    public boolean isAcceptable(String input) {
        return commands.containsKey(input);
    }
}
