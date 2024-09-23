package edu.grinnell.csc207.main;

import java.util.Scanner;
import java.io.PrintWriter;

import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BFCalculator;

/**
 * Class to create a calculator that takes constant input until called to close.
 *
 * @author Luis Lopez
 */
public class InteractiveCalculator {
/**
 * Part of program where method calls are made to evaluate input.
 * @param args
 *  command line arguments.
 */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner input = new Scanner(System.in);

    BFCalculator calc = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    for (;;) {
      String raw = input.nextLine();
      if (raw.equals("CLOSE") || raw.equals("QUIT") || raw.equals("EXIT")) {
        input.close();
        return;
      } // if statement to check if argument given is meant to close program.

      String[] commands = raw.split(" ");

      String lastCommand = "num";

      for (int i = 0; i < commands.length; i++) {
        String curr = commands[i];
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
            input.close();
            return;
          } // if statement to return error if two math calls are made back to back
          lastCommand = curr;
        } else if (lastCommand.equals("num")) {
          System.err.println("Can't Take Successive Numbers");
          input.close();
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
        } // if statement to check command argument and assign proper method
      } // for loop to check each command arugment in input line
      pen.flush();
    } // for loop that allows for continuous input
  } // end of main
} // end of class
