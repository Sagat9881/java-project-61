package hexlet.code.adapter;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ConsoleGameAdapter implements GameAdapter {
    private BufferedReader in;
    private PrintStream out;

    private final static int maxRetryCount = 3;

    @Override
    public void println(String s) {
        out.println(s);
    }

    @Override
    public String readInput(boolean allowEmptyInput) {
        return retryableRead(allowEmptyInput);
    }

    @Override
    public void setIn(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void setOut(PrintStream out) {
        this.out = out;
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
