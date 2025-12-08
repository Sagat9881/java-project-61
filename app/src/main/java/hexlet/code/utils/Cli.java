package hexlet.code.utils;

import java.io.PrintStream;
import java.util.Scanner;

public class Cli {
    final static Scanner in = new Scanner(System.in);
    final static PrintStream out = System.out;

    public static void println(String str){
        out.println(str);
    }

    public static String readLine(){
        return in.nextLine();
    }
}
