package edu.grinnell.csc207.main;

import java.util.Scanner;
import java.io.PrintWriter;

import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BFCalculator;

public class InteractiveCalculator {

    public static void main() {
        PrintWriter pen = new PrintWriter(System.out, true);
        Scanner input = new Scanner(System.in);

        for (;;) {
            String raw = input.nextLine();
            if (raw.equals("EXIT")) {
                input.close();
                return;
            }

            String[] commands = raw.split(" ");
            String lastInput;
            
            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equals("+")) {
                    lastInput = new String("+");
                } else if (commands[i].equals("-")) {

                }
            }


            pen.flush();
        }

    }

}
