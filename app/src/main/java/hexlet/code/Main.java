package hexlet.code;

import hexlet.code.engine.Engine;

public class Main {

    public static void main(String[] args) {
        Engine.ofDefault()
              .up()
              .start();
    }

}