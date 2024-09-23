package edu.grinnell.csc207.util;

/**
 * util functions for classes InteractiveCalculator and QuickCalculator.
 */
public class BFCalculator {

  /**
   * variable to store last value that has been computed.
   */
  BigFraction lastValue = new BigFraction(0, 1);

  /**
   * gets teh value from the object called upon.
   *
   * @return
   *  big fraction is returned that is stored in lastValue
   */
  public BigFraction get() {
    return lastValue;
  } // end of get

  /**
   * sets last value to be parameter val.
   *
   * @param val
   *  big fraction that is meant to be set
   */
  public void set(BigFraction val) {
    lastValue = val;
  } // end of set

  /**
   * adds parameter val and big fraction called upon.
   *
   * @param val
   *  big fraction that is to be added
   */
  public void add(BigFraction val) {
    lastValue = get().add(val);
  } // end of add

  /**
   * subtractions big fraciton val from big fraction called upon.
   *
   * @param val
   *  big fraction to be subtracted
   */
  public void subtract(BigFraction val) {
    lastValue = get().subtract(val);
  } // end of subtract

  /**
   * multiplies parameter val with big fraction called upon.
   *
   * @param val
   *  big fraction to be multiplied
   */
  public void multiply(BigFraction val) {
    lastValue = get().multiply(val);
  } // end of multiply

  /**
   * divides parameter val from calle upon big fraction.
   *
   * @param val
   *  big fration to divided by
   */
  public void divide(BigFraction val) {
    lastValue = get().divide(val);
  } // end of divide

  /**
   * clears las value called upon.
   */
  public void clear() {
    lastValue = new BigFraction(0, 1);
  } // end of clear
} // end of class
