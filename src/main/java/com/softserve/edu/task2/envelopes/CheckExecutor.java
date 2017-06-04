package com.softserve.edu.task2.envelopes;

import java.io.IOException;
import java.io.PrintStream;

/**
 * check if possible insert one envelope into the another one
 * Created by cdc89 on 25.05.2017.
 */
public class CheckExecutor {
    private ConsoleReader consoleReader;
    private PrintStream out;

    /**
     * set streams for input and output data
     *
     * @param consoleReader stream for input data
     * @param out           stream for output data
     */
    public CheckExecutor(ConsoleReader consoleReader, PrintStream out) {
        this.consoleReader = consoleReader;
        this.out = out;
    }

    /**
     * check if possible insert one envelope into the another one
     */
    public void execute() {
        boolean end = false;
        while (!end) {
            out.println("Insert width of the first envelope :");
            double firstWidth = getSide();
            out.println("Insert length of the first envelope :");
            double firstLength = getSide();
            Envelope firstEnvelope = new Envelope(firstLength, firstWidth);
            out.println("Insert width of the second envelope :");
            double secondWidth = getSide();
            out.println("Insert length of the second envelope :");
            double secondLength = getSide();
            Envelope secondEnvelope = new Envelope(secondLength, secondWidth);
            if (firstEnvelope.isCanInsert(secondEnvelope)) {
                out.println("Second envelope can be inserted into the "
                        + "first one");
            } else {
                out.println("Second envelope can not be inserted into "
                        + "the first one");
            }
            end = isEnd();
        }
        closeReader();
    }

    private void closeReader() {
        if (consoleReader != null) {
            try {
                consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isEnd() {
        out.println("Do you want to proceed ?");
        String input = consoleReader.readLine();
        if (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    private double getSide() {
        double side = consoleReader.nextDouble();
        return side;
    }
}
