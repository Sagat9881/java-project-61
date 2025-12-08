package hexlet.code;

import hexlet.code.engine.Engine;
import hexlet.code.games.Game;
import hexlet.code.games.Greeting;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Game> games = List.of(new Greeting());

        Engine.of(games).up().start();
    }

}