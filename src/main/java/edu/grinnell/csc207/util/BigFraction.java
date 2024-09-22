package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * A simple implementation of arbitrary-precision Fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Luis Lopez and Sheilla Muligande
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+

  /*
   * (1) Denominators are always positive. Therefore, negative fractions
   * are represented with a negative numerator. Similarly, if a fraction
   * has a negative numerator, it is negative.
   *
   * (2) Fractions are not necessarily stored in simplified form. To
   * obtain a fraction in simplified form, one must call the `simplify`
   * method.
   */

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /** The default numerator when creating fractions. */
  private static final BigInteger DEFAULT_NUMERATOR = BigInteger.valueOf(0);

  /** The default denominator when creating fractions. */
  private static final BigInteger DEFAULT_DENOMINATOR = BigInteger.valueOf(1);

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   *
   * @param numerator
   *   The numerator of the fraction.
   * @param denominator
   *   The denominator of the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   *
   * @param numerator
   *   The numerator of the fraction.
   * @param denominator
   *   The denominator of the fraction.
   */
  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);
  } // BigFraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   *
   * @param str
   *   The fraction in string form
   */
  public BigFraction(String str) {
    String[] fract = str.split("/");
    if (fract.length == 1) {
      this.num = new BigInteger(fract[0]);
      this.denom = DEFAULT_DENOMINATOR;
    } else if (fract.length == 2) {
      this.num = new BigInteger(fract[0]);
      this.denom = new BigInteger(fract[1]);
    } else {
      this.num = DEFAULT_NUMERATOR;
      this.denom = DEFAULT_DENOMINATOR;
    }
    
  } // BigFraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   *
   * @return the fraction approxiamted as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add another faction to this fraction.
   *
   * @param addend
   *   The fraction to add.
   *
   * @return the result of the addition.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(addend.denom);
    // The numerator is more complicated
    resultNumerator =
      (this.num.multiply(addend.denom)).add(addend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator).simplify();
  } // add(BigFraction)

  public BigFraction multiply(BigFraction multied) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultNum = this.num.multiply(multied.num);
    resultDenom = this.denom.multiply(multied.denom);

    return new BigFraction(resultNum, resultDenom);
  }

  public BigFraction divide(BigFraction divied) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultNum = this.num.multiply(divied.denom);
    resultDenom = this.denom.multiply(divied.num);


    return new BigFraction(resultNum, resultDenom);
  }

  public BigFraction subtract(BigFraction subed) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.multiply(subed.denom);
    resultNum =this.num.multiply(subed.denom).subtract(subed.num.multiply(this.denom));

    return new BigFraction(resultNum, resultDenom);
  }

  public BigFraction simplify() {
    BigInteger simpleNum;
    BigInteger simpleDenom;
    BigInteger comDenom;
    
    comDenom = this.num.gcd(this.denom);
    simpleNum = this.num.divide(comDenom);
    simpleDenom = this.denom.divide(comDenom);

    return new BigFraction(simpleNum, simpleDenom);
  }

  /**
   * Get the denominator of this fraction.
   *
   * @return the denominator
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   *
   * @return the numerator
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Convert this fraction to a string for ease of printing.
   *
   * @return a string that represents the fraction.
   */
  public String toString() {

    BigFraction simp = this.simplify();
    // Special case: It's zero
    if (simp.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    if (simp.denom.equals(BigInteger.valueOf(1))) {
      return simp.num + "";
    } else {
    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
     return simp.num + "/" + simp.denom;
    }
  } // toString()
} // class BigFraction