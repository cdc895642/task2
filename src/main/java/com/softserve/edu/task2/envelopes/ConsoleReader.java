package com.softserve.edu.task2.envelopes;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by cdc89 on 03.06.2017.
 * use for input data from user
 */
public class ConsoleReader {
    private BufferedReader reader;
    private PrintStream out;

    /**
     * set stream for user input
     *
     * @param in stream for user input
     */
    public ConsoleReader(InputStream in, PrintStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        this.out = out;
    }

    public ConsoleReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = System.out;
    }

    /**
     * close opened reader
     *
     * @throws IOException
     */
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * read string from user
     *
     * @return string from user
     */
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * read double as string and try to convert it to the double. If
     * an exception is occur than try again.
     *
     * @return double value inserted by user
     */
    public double nextDouble() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale
                .ENGLISH);
        double value;
        try {
            String input = reader.readLine();
            value = numberFormat.parse(input).doubleValue();
            if (value <= 0) {
                throw new ParseException("incorrect value", 0);
            }
        } catch (ParseException | IOException e) {
            out.println("Inserted incorrect value! Please try again !");
            return nextDouble();
        }
        return value;
    }
}
