package hexlet.code.adapter;

import java.io.*;

public class ConsoleGameAdapter implements GameAdapter {
    private BufferedReader in;
    private PrintStream out;

    /* TODO: Хотелось бы интерпретировать пользовтельский ввод как сообщение для Engine в дальнейшем.
        private Engine engine;     */


    private final static int maxRetryCount = 3;

    @Override
    public void println(String s) {
        out.println(s);
    }

    @Override
    public void print(String s) {
        out.print(s);
    }

    @Override
    public String readInput(boolean allowEmptyInput) {
        return retryableRead(allowEmptyInput);
    }

    @Override
    public void setIn(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public void setOut(OutputStream out) {
        this.out =new PrintStream(out, true);
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
