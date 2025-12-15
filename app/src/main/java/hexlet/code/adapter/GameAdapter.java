package hexlet.code.adapter;

import java.io.BufferedReader;
import java.io.PrintStream;

public interface GameAdapter {
    void println(String s);
    String readInput(boolean allowEmptyInput);
    void setIn(BufferedReader in);
    void setOut(PrintStream out );


    default String readInput(){
        return readInput(false);
    };
}
