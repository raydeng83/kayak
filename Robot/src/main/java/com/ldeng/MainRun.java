package com.ldeng;

/**
 * Created by Le on 9/8/2016 0008.
 */
public class MainRun {
    public static void main(String[] args) {
        Robot r2d2 = new Robot();
        String command = "LLFFRRFFRFRF";
        System.out.println("The input command is "+command);
        r2d2.commandParser(command);
        r2d2.execute();
    }
}
