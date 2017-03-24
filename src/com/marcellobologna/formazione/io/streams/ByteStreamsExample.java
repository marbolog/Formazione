package com.marcellobologna.formazione.io.streams;

import java.io.*;

/**
 * Created by Marcello Bologna on 23/03/17.
 */
public class ByteStreamsExample {

    public static void unbufferedByteStream() throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream("/home/local/ARIADNE/bologna/Documenti/prove/xanadu.txt");
            out = new FileOutputStream("/home/local/ARIADNE/bologna/Documenti/prove/outgain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void unbufferedCharStream() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("/home/local/ARIADNE/bologna/Documenti/prove/xanadu.txt");
            outputStream = new FileWriter("/home/local/ARIADNE/bologna/Documenti/prove/characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void copyLines() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("/home/local/ARIADNE/bologna/Documenti/prove/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("/home/local/ARIADNE/bologna/Documenti/prove/characteroutputbuffered.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        unbufferedByteStream();
        unbufferedCharStream();

    }
}
