package com.marcellobologna.formazione.io.scanningandformatting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * By default, a scanner uses white space to separate tokens. (White space characters include blanks, tabs, and line
 * terminators. For the full list, refer to the documentation for Character.isWhitespace.)
 */
public class ScanningExample {

    public static void main(String[] args) throws IOException {

        try (Scanner s = new Scanner(new BufferedReader(new FileReader("/home/local/ARIADNE/bologna/Documenti/prove/xanadu.txt")));) {

            // To use a different token separator, invoke useDelimiter(), specifying a regular expression.
            // For example, suppose you wanted the token separator to be a comma, optionally followed by white space.
            // You would invoke,

            s.useDelimiter(",\\s*");

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }

}
