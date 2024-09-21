package edu.grinnell.csc207.util;

import java.math.BigInteger;
import edu.grinnell.csc207.util.BigFraction;

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
        lastValue = BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(0));
    }
}
