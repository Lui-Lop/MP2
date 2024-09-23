package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BFCalculator;

/**
 * Calculator that takes in multiple math calls at the same time to be done in
 * one instance.
 */
public class QuickCalculator {
  /**
   * part of program to evaluate command line arguments.
   *
   * @param args
   *  command line arguments that are to be evalutated with proper
   *             return
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BFRegisterSet register = new BFRegisterSet();
    BFCalculator calc = new BFCalculator();
    for (String str : args) {
      pen.print(str + " -> ");

    

      String[] commands = str.split(" ");

      String lastCommand = "num";

      for (int i = 0; i < commands.length; i++) {
        String curr = commands[i];

        // pen.println(commands[i]);

        if (commands[0].equals("STORE")) {
          register.store(commands[1].charAt(0), calc.get());
          pen.println("STORED");
          break;
        } else if (i == 0) {
          if (curr.length() == 1 && curr.charAt(0) <= 'z' && curr.charAt(0) >= 'a') {
            calc.set(register.get(curr.charAt(0)));
          } else {
            BigFraction temp = new BigFraction(commands[i]);
            calc.set(temp);
          } // if statement to either get number from register or from input
        } else if (curr.equals("+") || curr.equals("/") || curr.equals("-") || curr.equals("*")) {
          if (lastCommand.equals("+") || lastCommand.equals("/") || lastCommand.equals("-")
              || lastCommand.equals("*")) {
            System.err.println("Can't Take Sucessive Math Functions");
            return;
          } // if statment to check if two math calls are given back to back, if so an error
          lastCommand = curr;
        } else if (lastCommand.equals("num")) {
          System.err.println("Can't Take Successive Numbers");
          return;
        } else if (lastCommand.equals("+")) {
          if (curr.length() == 1 && curr.charAt(0) <= 'z' && curr.charAt(0) >= 'a') {
            calc.add(register.get(curr.charAt(0)));
            pen.println(calc.get().toString());
          } else {
            BigFraction temp = new BigFraction(commands[i]);
            calc.add(temp);
            pen.println(calc.get().toString());
          } // if statement to either get number from register or from input
        } else if (lastCommand.equals("-")) {
          if (curr.length() == 1 && curr.charAt(0) <= 'z' && curr.charAt(0) >= 'a') {
            calc.subtract(register.get(curr.charAt(0)));
            pen.println(calc.get().toString());
          } else {
            BigFraction temp = new BigFraction(commands[i]);
            calc.subtract(temp);
            pen.println(calc.get().toString());
          } // if statement to either get number from register or from input
        } else if (lastCommand.equals("/")) {
          if (curr.length() == 1 && curr.charAt(0) <= 'z' && curr.charAt(0) >= 'a') {
            calc.divide(register.get(curr.charAt(0)));
            pen.println(calc.get().toString());
          } else {
            BigFraction temp = new BigFraction(commands[i]);
            calc.divide(temp);
            pen.println(calc.get().toString());
          } // if statement to either get number from register or from input
        } else if (lastCommand.equals("*")) {
          if (curr.length() == 1 && curr.charAt(0) <= 'z' && curr.charAt(0) >= 'a') {
            calc.multiply(register.get(curr.charAt(0)));
            pen.println(calc.get().toString());
          } else {
            BigFraction temp = new BigFraction(commands[i]);
            calc.multiply(temp);
            pen.println(calc.get().toString());
          } // if statement to either get number from register or from input
        } // if statement to check proper method call needed
      } // loop to check for proper method calls in this instance of commands
      pen.flush();
    } // for loop for each value in array args
  } // end of main
} // end of class
