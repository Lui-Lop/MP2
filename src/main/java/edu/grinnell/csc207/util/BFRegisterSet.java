package edu.grinnell.csc207.util;

/**
 * util function to be used in main classes.
 */
public class BFRegisterSet {
  /**
   * Creates array of registers for each alphabetic letter.
   */
  BigFraction[] registerAll = new BigFraction[26];

  /**
   * stores big fraction value in register called upon.
   * @param register
   *  character that is used to find register
   * @param val
   */
  public void store(char register, BigFraction val) {
    int index = (int) register - (int) 'a';

    registerAll[index] = new BigFraction(val.num, val.denom);
  } // end of store

  /**
   * Gets the big fraciton value from register called upone using the register wanted.
   * @param register
   *  character that is used to find register
   * @return
   *  big fraction of register
   */
  public BigFraction get(char register) {
    int index = (int) register - (int) 'a';

    return registerAll[index];
  } // end of get
} // end of class
