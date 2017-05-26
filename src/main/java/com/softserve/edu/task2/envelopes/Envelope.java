package com.softserve.edu.task2.envelopes;

/**
 * represent envelope
 * Created by cdc89 on 25.05.2017.
 */
public class Envelope {
    private double height;
    private double width;

    public Envelope(double height, double width) {
        this.height = height;
        this.width = width;
    }

    /**
     * check if envelope from method parameter can be inserted in this envelope
     *
     * @param envelope envelope that should be inserted
     * @return true if envelope from method parameter can be inserted
     */
    public boolean isCanInsert(Envelope envelope) {
        if (envelope.getLowerSize() < getLowerSize() && envelope.getBiggerSize() < getBiggerSize()) {
            return true;
        }
        return false;
    }

    /**
     * get lower size of this envelope
     *
     * @return lower size of this envelope
     */
    public double getLowerSize() {
        return Math.min(height,width);
    }

    /**
     * get bigger size of this envelope
     *
     * @return bigger size of this envelope
     */
    public double getBiggerSize() {
        return Math.max(height,width);
    }
}
