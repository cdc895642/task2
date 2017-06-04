package com.softserve.edu.task2.envelopes;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

/**
 * Created by cdc89 on 03.06.2017.
 */
public class CheckExecutorTest {
    @Test
    public void IsEnd_ProceedOneTimes_Return() {
        //Arrange
        final int EXPECTED_TIMES = 2;
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.nextDouble()).thenReturn(10.0);
        when(reader.readLine()).thenReturn("y", "n");
        CheckExecutor checkExecutor = new CheckExecutor(reader, System.out);

        //Act
        checkExecutor.execute();

        //Assert
        verify(reader, times(EXPECTED_TIMES)).readLine();
    }

    @Test
    public void IsEnd_NoProceed_Return() {
        //Arrange
        final int EXPECTED_TIMES = 1;
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.nextDouble()).thenReturn(10.0);
        when(reader.readLine()).thenReturn("n", "y");
        CheckExecutor checkExecutor = new CheckExecutor(reader, System.out);

        //Act
        checkExecutor.execute();

        //Assert
        verify(reader, times(EXPECTED_TIMES)).readLine();
    }

    @Test
    public void Execute_FirstEnvelopeBigger_CanInsertSecond() {
        //Arrange
        final String EXPECTED = "Second envelope can be inserted into the "
                + "first one";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.nextDouble()).thenReturn(10.0, 20.0, 15.0, 9.0);
        when(reader.readLine()).thenReturn("n");
        CheckExecutor checkExecutor = new CheckExecutor(reader, new
                PrintStream(outContent));

        //Act
        checkExecutor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED));
    }

    @Test
    public void Execute_SecondEnvelopeBigger_CanNotInsertSecond() {
        //Arrange
        final String EXPECTED = "Second envelope can not be inserted into the "
                + "first one";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.nextDouble()).thenReturn(10.0, 20.0, 21.0, 9.0);
        when(reader.readLine()).thenReturn("n", "y");
        CheckExecutor checkExecutor = new CheckExecutor(reader, new
                PrintStream(outContent));

        //Act
        checkExecutor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED));
    }

    @Test
    public void Execute_EqualEnvelopes_CanNotInsert() {
        //Arrange
        final String EXPECTED = "Second envelope can not be inserted into the "
                + "first one";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.nextDouble()).thenReturn(10.0, 20.0, 10.0, 20.0);
        when(reader.readLine()).thenReturn("n");
        CheckExecutor checkExecutor = new CheckExecutor(reader, new
                PrintStream(outContent));

        //Act
        checkExecutor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED));
    }

    @Test
    public void Execute_InsertIncorrectValue_TryInsertAgain() throws
            IOException {
        //Arrange
        final String EXPECTED_ANSWER = "Inserted incorrect value! Please try "
                + "again !";
        final String EXPECTED_QUESTION = "Do you want to proceed ?";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleReader reader = new ConsoleReader();
        BufferedReader in = mock(BufferedReader.class);
        reader.setReader(in);
        reader.setOut(new PrintStream(outContent));
        when(in.readLine()).thenReturn("incorrect", "10.0", "20.0", "10.0",
                "20.0", "n");
        CheckExecutor checkExecutor = new CheckExecutor(reader,
                new PrintStream(outContent));

        //Act
        checkExecutor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED_QUESTION));
        assertTrue(outContent.toString().contains(EXPECTED_ANSWER));
    }
}
