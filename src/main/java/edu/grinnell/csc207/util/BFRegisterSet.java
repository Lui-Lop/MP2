package edu.grinnell.csc207.util;

public class BFRegisterSet {
    BigFraction[] registerAll = new BigFraction[26];

    public void store(char register, BigFraction val) {
        int index = (int) register - (int) 'a';

        registerAll[index] = new BigFraction(val.num, val.denom);
    }

    public BigFraction get(char register) {
        int index = (int) register - (int) 'a';
        
        return registerAll[index];
    }
}
