package hexlet.code.adapter;

public interface GameAdapter {
    void println(String s);
    String readInput(boolean allowEmptyInput);

    default String readInput(){
        return readInput(false);
    };
}
