package com.marcellobologna.formazione.io.system;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * System.in is an InputStream which is typically connected to keyboard input of console programs.
 * <p>
 * System.out is a PrintStream. System.out normally outputs the data you write to it to the console. This is often used
 * from console-only programs like command line tools. This is also often used to print debug statements of from a
 * program (though it may arguably not be the best way to get debug info out of a program).
 * <p>
 * System.err is a PrintStream. System.err works like System.out except it is normally only used to output error texts.
 */
public class SystemInOutErrExample {

    /*
     * Even if the 3 System streams are static members of the java.lang.System class, and are pre-instantiated at JVM
     * startup, you can change what streams to use for each of them. Just set a new InputStream for System.in or a new
     * OutputStream for System.out or System.err, and all further data will be read / written to the new stream.
     */

    public static void main(String[] args) throws FileNotFoundException {
        OutputStream output = new FileOutputStream("/home/local/ARIADNE/bologna/Documenti/prove/out.txt");
        PrintStream printOut = new PrintStream(output);

        System.setOut(printOut);

        System.out.println("Hello new Out!");

        // Remember: always close the streams!
        printOut.close();
    }

}
