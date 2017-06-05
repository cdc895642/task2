package com.softserve.edu.task2.envelopes;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by cdc89 on 05.06.2017.
 */
public class ConsoleReaderTest {
    @Test
    public void ReadLine_InputString_ReturnString() throws IOException {
        //Arrange
        final String EXPECTED = "INPUT";
        ConsoleReader reader = new ConsoleReader();
        BufferedReader in = mock(BufferedReader.class);
        reader.setReader(in);
        when(in.readLine()).thenReturn("INPUT");

        //Act
        String result = reader.readLine();

        //Assert
        assertEquals(EXPECTED, result);
        reader.close();
    }

    @Test
    public void Close_ConstructorByDefaultCloseTwoTimes_NoExceptions() throws
            IOException {
        //Arrange
        ConsoleReader reader = new ConsoleReader();

        //Act
        reader.close();
        reader.close();
    }

    @Test
    public void Close_ConstructorWithParamsCloseTwoTimes_NoExceptions() throws
            IOException {
        //Arrange
        ConsoleReader reader1 = new ConsoleReader(System.in, System.out);

        //Act
        reader1.close();
        reader1.close();
    }

    @Test
    public void Close_SetReaderCloseTwoTimes_NoExceptions() throws
            IOException {
        //Arrange
        ConsoleReader reader2 = new ConsoleReader();
        BufferedReader in = mock(BufferedReader.class);
        reader2.setReader(new BufferedReader(in));

        //Act
        reader2.close();
        reader2.close();
    }

    @Test
    public void NextDouble_Double_getDouble() throws IOException {
        //Arrange
        final double DELTA = 0.000000001;
        ConsoleReader reader = new ConsoleReader();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        BufferedReader in = mock(BufferedReader.class);
        reader.setReader(in);
        reader.setOut(new PrintStream(outContent));
        when(in.readLine()).thenReturn("10.7");
        double expected = 10.7;

        //Act
        double result = reader.nextDouble();

        //Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void NextDouble_NotDigit1Time_Repeat1Time() throws IOException {
        //Arrange
        final int EXPECTED_TIMES = 2;
        final double DELTA = 0.000000001;
        final double EXPECTED = 10;
        ConsoleReader reader = new ConsoleReader();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        BufferedReader in = mock(BufferedReader.class);
        reader.setReader(in);
        reader.setOut(new PrintStream(outContent));
        when(in.readLine()).thenReturn("incorrect", "10.0");

        //Act
        double result = reader.nextDouble();

        //Assert
        verify(in, times(EXPECTED_TIMES)).readLine();
        assertEquals(EXPECTED, result, DELTA);
    }
}
