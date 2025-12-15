package hexlet.code.engine.interceptors.in;

import hexlet.code.engine.Engine;
import hexlet.code.games.greeting.Greeting;

import static hexlet.code.engine.Engine.JOHN_DOE;
import static hexlet.code.engine.EngineContext.currentPlayer;

public class GreetingInterceptor implements InputInterceptor {
    private final Engine engine;

    public GreetingInterceptor(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String doIntercept(String input) {
         engine.start(Greeting.class);
         return input;
    }

    @Override
    public boolean isAcceptable(String input) {
        return JOHN_DOE.equals(currentPlayer.get().name());
    }
}
