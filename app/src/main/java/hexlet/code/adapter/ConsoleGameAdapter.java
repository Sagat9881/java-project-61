package hexlet.code.adapter;

import hexlet.code.engine.Engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConsoleGameAdapter implements GameAdapter {
    private final Map<String, Consumer<Engine>> commands = new HashMap<>();
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private final static PrintStream out = System.out;
    private final static int maxRetryCount = 3;

    @Override
    public void println(String s) {
        out.println(s);
    }

    @Override
    public String readInput(boolean allowEmptyInput) {
        return retryableRead(allowEmptyInput);
    }

    private String retryableRead(boolean allowEmptyInput) {
        try {
            String s = in.readLine();
            if (!allowEmptyInput && s.isEmpty()) {
                out.println("Empty input!  Please enter a value.");
                s = retryableRead(allowEmptyInput);
            }
            return s;
        } catch (Exception e) {
            out.println(e.getMessage());
            return null;
        }
    }
}
