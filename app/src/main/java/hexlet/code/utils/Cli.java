package hexlet.code.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Cli {
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static PrintStream out = System.out;

    public static void println(String str) {
        out.println(str);
    }

    public static String readLine() {
        try {
            return in.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
