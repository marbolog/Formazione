package com.marcellobologna.formazione.nio.streambased;

// Demonstrate NIO-based, stream output. Requires JDK 7 or later.

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

class NIOStreamWrite {
    public static void main(String args[]) {
        // Open the file and obtain a stream linked to it.
        try (OutputStream fout =
                     new BufferedOutputStream(
                             Files.newOutputStream(Paths.get("/home/local/ARIADNE/bologna/Documenti/prove/toglimi.txt")))) {
            // Write some bytes to the stream.
            for (int i = 0; i < 26; i++)
                fout.write((byte) ('A' + i));
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
