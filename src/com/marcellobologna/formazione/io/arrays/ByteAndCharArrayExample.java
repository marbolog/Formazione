package com.marcellobologna.formazione.io.arrays;

import java.io.*;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * Byte and char arrays are often used in Java to temporarily store data internally in an application. As such arrays
 * are also a common source or destination of data. You may also prefer to load a file into an array, if you need to
 * access the contents of that file a lot while the program is running. Of course you can access these arrays directly
 * by indexing into them. But what if you have a component that is designed to read some specific data from an
 * InputStream or Reader and not an array?
 */
public class ByteAndCharArrayExample {

    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[1024];
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};

        //write data into byte array...
        InputStream inputByteStream = new ByteArrayInputStream(bytes);
        Reader inputCharStream = new CharArrayReader(chars);


        //read first byte
        int data = inputByteStream.read();
        while (data != -1) {
            //do something with data
            System.out.println(data);

            //read next byte
            data = inputByteStream.read();
        }

        data = inputCharStream.read();
        while (data != -1) {
            System.out.println(data);

            data = inputCharStream.read();
        }

        ByteArrayOutputStream outputByteStream = new ByteArrayOutputStream();
        Writer outputCharStream = new CharArrayWriter();

        outputByteStream.write("This text is converted to bytes".getBytes("UTF-8"));
        outputCharStream.write("This text is converted to bytes");

        bytes = outputByteStream.toByteArray();
    }

}
