package com.softserve.edu.task2.envelopes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdc89 on 03.06.2017.
 */
public class EnvelopeTest {
    @Test
    public void GetLowerSize_TenSix_SixReturn() {
        //Arrange
        double lowerSize = 6;
        double biggerSize = 10;
        double delta = 0;
        Envelope envelope = new Envelope(biggerSize, lowerSize);

        //Act
        double result = envelope.getLowerSize();

        //Assert
        assertEquals(result, lowerSize, delta);
    }

    @Test
    public void GetLowerSize_SixSix_SixReturn() {
        //Arrange
        double lowerSize = 6;
        double biggerSize = 6;
        double delta = 0;
        Envelope envelope = new Envelope(biggerSize, lowerSize);

        //Act
        double result = envelope.getLowerSize();

        //Assert
        assertEquals(result, lowerSize, delta);
    }

    @Test
    public void GetLowerSize_SevenTen_SevenReturn() {
        //Arrange
        double lowerSize = 7;
        double biggerSize = 10;
        double delta = 0;
        Envelope envelope = new Envelope(lowerSize, biggerSize);

        //Act
        double result = envelope.getLowerSize();

        //Assert
        assertEquals(result, lowerSize, delta);
    }

    @Test
    public void GetBiggerSize_TenSix_TenReturn() {
        //Arrange
        double lowerSize = 6;
        double biggerSize = 10;
        double delta = 0;
        Envelope envelope = new Envelope(biggerSize, lowerSize);

        //Act
        double result = envelope.getBiggerSize();

        //Assert
        assertEquals(result, biggerSize, delta);
    }

    @Test
    public void GetBiggerSize_TenTen_TenReturn() {
        //Arrange
        double lowerSize = 10;
        double biggerSize = 10;
        double delta = 0;
        Envelope envelope = new Envelope(biggerSize, lowerSize);

        //Act
        double result = envelope.getBiggerSize();

        //Assert
        assertEquals(result, biggerSize, delta);
    }

    @Test
    public void GetBiggerSize_FourTen_TenReturn() {
        //Arrange
        double lowerSize = 4;
        double biggerSize = 10;
        double delta = 0;
        Envelope envelope = new Envelope(lowerSize, biggerSize);

        //Act
        double result = envelope.getBiggerSize();

        //Assert
        assertEquals(result, biggerSize, delta);
    }

    @Test
    public void IsCanInsert_SmallerEnvelope_TrueReturn() {
        //Arrange
        Envelope smallEnvelope = new Envelope(10.0, 15.0);
        Envelope bigEnvelope = new Envelope(15.4, 19.0);

        //Act
        boolean result = bigEnvelope.isCanInsert(smallEnvelope);

        //Assert
        assertTrue(result);
    }

    @Test
    public void IsCanInsert_BiggerEnvelope_FalseReturn() {
        //Arrange
        Envelope smallEnvelope = new Envelope(10.0, 15.0);
        Envelope bigEnvelope = new Envelope(15.4, 10.0);

        //Act
        boolean result = smallEnvelope.isCanInsert(bigEnvelope);

        //Assert
        assertFalse(result);
    }

    @Test
    public void IsCanInsert_EqualEnvelope_FalseReturn() {
        //Arrange
        Envelope firstEnvelope = new Envelope(10.0, 15.0);
        Envelope secondEnvelope = new Envelope(15.0, 10.0);

        //Act
        boolean result = firstEnvelope.isCanInsert(secondEnvelope);

        //Assert
        assertFalse(result);
    }
}
