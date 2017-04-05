package com.marcellobologna.formazione.networking;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Marcello Bologna on 05/04/17.
 * <p>
 * Demonstrate Sockets.
 */

public class Whois {
    public static void main(String args[]) throws Exception {
        int c;

        // Create a socket connected to internic.net, port 43.
        try (Socket s = new Socket("whois.internic.net", 43)) {

            // Obtain input and output streams.
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            // Construct a request string.
            String str = (args.length == 0 ? "google.com" : args[0]) + "\n";
            // Convert to bytes.
            byte buf[] = str.getBytes();
            // Send request.
            out.write(buf);
            // Read and display response.
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}