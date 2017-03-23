package com.marcellobologna.formazione.io.pipes;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * Pipes in Java IO provides the ability for two threads running in the same JVM to communicate. Therefore pipes can
 * also be sources or destinations of data.
 * <p>
 * You cannot use a pipe to communicate with a thread in a different JVM (different process). The pipe concept in Java
 * is different from the pipe concept in Unix / Linux, where two processes running in different address spaces can
 * communicate via a pipe. In Java, the communicating parties must be running in the same process, and should be
 * different threads.
 */
public class PipeExample {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream outputStream = new PipedOutputStream();
        final PipedInputStream inputStream = new PipedInputStream(outputStream);

        // alternatively:
        // inputStream.connect(outputStream);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    /*
                    The read() and write() calls on the streams are blocking, meaning if you try to use the same
                    thread to both read and write, this may result in the thread deadlocking itself
                    */

                    outputStream.write("Hello world, pipe!".getBytes());
                } catch (IOException e) {
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = inputStream.read();
                    while (data != -1) {
                        System.out.print((char) data);
                        data = inputStream.read();
                    }
                } catch (IOException e) {
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
