package com.marcellobologna.formazione.io.console;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * The Java platform supports three Standard Streams: Standard Input, accessed through System.in; Standard Output,
 * accessed through System.out; and Standard Error, accessed through System.err. These objects are defined automatically
 * and do not need to be opened.
 * <p>
 * A more advanced alternative to the Standard Streams is the Console. This is a single,
 * predefined object of type Console that has most of the features provided by the Standard Streams, and others besides.
 * The Console is particularly useful for secure password entry. The Console object also provides input and output
 * streams that are true character streams, through its reader and writer methods.
 */
public class ConsoleExample {

    public static void main(String args[]) throws IOException {

        // retreive System console, if any is available
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String login = c.readLine("Enter your login: ");
        char[] oldPassword = c.readPassword("Enter your old password: ");

        if (verify(login, oldPassword)) {
            boolean noMatch;
            do {
                char[] newPassword1 = c.readPassword("Enter your new password: ");
                char[] newPassword2 = c.readPassword("Enter new password again: ");
                noMatch = !Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwords don't match. Try again.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);
        }

        Arrays.fill(oldPassword, ' ');
    }

    // Dummy change method.
    static boolean verify(String login, char[] password) {
        // This method always returns
        // true in this example.
        // Modify this method to verify
        // password according to your rules.
        return true;
    }

    // Dummy change method.
    static void change(String login, char[] password) {
        // Modify this method to change
        // password according to your rules.
    }

}
