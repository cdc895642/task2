package com.softserve.edu.task2;

import com.softserve.edu.task2.envelopes.CheckExecutor;
import com.softserve.edu.task2.envelopes.ConsoleReader;

/**
 * entry point
 */
public class App {
    public static void main(String[] args) {
        CheckExecutor checkExecutor = new CheckExecutor(new ConsoleReader
                (System.in, System.out),
                System.out);
        checkExecutor.execute();
    }
}
