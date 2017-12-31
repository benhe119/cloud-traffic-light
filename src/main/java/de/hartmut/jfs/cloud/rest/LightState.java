package de.hartmut.jfs.cloud.rest;

/**
 * Created by hartmut on 28.02.16.
 */
public class LightState {
    boolean red;
    boolean yellow;
    boolean green;
    long count = 0L;

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isYellow() {
        return yellow;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
