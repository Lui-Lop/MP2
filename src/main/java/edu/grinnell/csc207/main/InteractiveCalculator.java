package edu.grinnell.csc207.main;

import java.util.Scanner;
import java.io.PrintWriter;

import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BFCalculator;

public class InteractiveCalculator {

    public static void main(String [] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        Scanner input = new Scanner(System.in);

        BFCalculator calc = new BFCalculator();
        BFRegisterSet register = new BFRegisterSet();

        for (;;) {
            String raw = input.nextLine();
            if (raw.equals("CLOSE")) {
                input.close();
                return;
            }

            String[] commands = raw.split(" ");



            String lastCommand = "num";
            
            for (int i = 0; i < commands.length; i++) {
                String curr = commands[i];

               // pen.println(commands[i]);

                if (curr.length() == 1 && curr.charAt(0) <= 'z' && curr.charAt(0) >= 'a') {
                    calc.set(register.get(curr.charAt(0)));
                }
                if (commands[0].equals("STORE")) {
                    register.store(commands[1].charAt(0), calc.get());
                    pen.println("STORED");
                    break;
                } else if (i == 0) {
                    BigFraction temp = new BigFraction(commands[i]);
                    calc.set(temp);
                } else if (curr.equals("+") || curr.equals("/") || curr.equals("-") || curr.equals("*")) {
                    if (lastCommand.equals("+") || lastCommand.equals("/") || lastCommand.equals("-") || lastCommand.equals("*")) {
                        System.err.println("Can't Take Sucessive Math Functions");
                        input.close();
                        return;
                    }
                    lastCommand = curr;
                } else if (lastCommand.equals("num")) {
                    System.err.println("Can't Take Successive Numbers");
                    input.close();
                    return;
                } else if (lastCommand.equals("+")) {
                    BigFraction temp = new BigFraction(commands[i]);
                    calc.add(temp);
                    pen.println(calc.get().toString());
                } else if (lastCommand.equals("-")) {
                    BigFraction temp = new BigFraction(commands[i]);
                    calc.subtract(temp);
                    pen.println(calc.get().toString());
                } else if (lastCommand.equals("/")) {
                    BigFraction temp = new BigFraction(commands[i]);
                    calc.divide(temp);
                    pen.println(calc.get().toString());
                } else if (lastCommand.equals("*")) {
                    BigFraction temp = new BigFraction(commands[i]);
                    calc.multiply(temp);
                    pen.println(calc.get().toString());
                }
            }

            pen.flush();
            
        }
        
    }

}
