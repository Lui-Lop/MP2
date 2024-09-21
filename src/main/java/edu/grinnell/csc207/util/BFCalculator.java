package edu.grinnell.csc207.util;

public class BFCalculator {

    BigFraction lastValue;

    public BigFraction get() {
        return lastValue;
    }

    public void add(BigFraction val) {
        lastValue = get().add(val);
    }
    
    public void subtract(BigFraction val) {
        lastValue = get().subtract(val);
    }

    public void multiply(BigFraction val) {
        lastValue = get().multiply(val);
    }

    public void divide(BigFraction val) {
        lastValue = get().divide(val);
    }

    public void clear() {
        lastValue = new BigFraction(0, 0);
    }
}
