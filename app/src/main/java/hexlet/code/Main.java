package hexlet.code;

import hexlet.code.adapter.ConsoleGameAdapter;
import hexlet.code.engine.Engine;

import static hexlet.code.engine.EngineContext.games;

public class Main {
    public static void main(String[] args) {
        Engine.of(games)
              .up(new ConsoleGameAdapter())
              .start();
    }

}