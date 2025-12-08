package hexlet.code;

import java.io.PrintStream;
import java.util.Scanner;

public class Cli {
    final static Scanner in = new Scanner(System.in);
    final static PrintStream out = System.out;

    public static void print(String str){
        out.print(str);
    }

    public static String read(){
        return in.nextLine();
    }
}
