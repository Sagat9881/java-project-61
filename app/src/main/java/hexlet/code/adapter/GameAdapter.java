package hexlet.code.adapter;

import java.io.InputStream;
import java.io.OutputStream;

public interface GameAdapter {
    void println(String s);
    void print(String s);
    String readInput(boolean allowEmptyInput);
    void setIn(InputStream in);
    void setOut(OutputStream out );


    default String readInput(){
        return readInput(false);
    };
}
