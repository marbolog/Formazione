package com.marcellobologna.formazione.io.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * The Java DataInputStream class enables you to read Java primitives (int, float, long etc.) from an InputStream
 * instead of only raw bytes. You wrap an InputStream in a DataInputStream and then you can read Java primitives from
 * the DataInputStream. That is why it is called DataInputStream - because it reads data (numbers) instead of just
 * bytes.
 * <p>
 * The DataInputStream is handy if the data you need to read consists of Java primitives larger than one byte each, like
 * int, long, float, double etc. The DataInputStream expects the multi byte primitives to be written in network byte
 * order (Big Endian - most significant byte first).
 */
public class DataInputStreamExample {

    public static void main(String[] args) {

        try (
                DataOutputStream dataOutputStream =
                        new DataOutputStream(
                                new FileOutputStream("/home/local/ARIADNE/bologna/Documenti/prove/fileoutputstream.bin"));

                DataInputStream dataInputStream =
                        new DataInputStream(
                                new FileInputStream("/home/local/ARIADNE/bologna/Documenti/prove/fileoutputstream.bin"));
        ) {

            dataOutputStream.writeInt(123);
            dataOutputStream.writeFloat(123.45F);
            dataOutputStream.writeLong(789);

            dataOutputStream.close();

            int int123 = dataInputStream.readInt();
            float float12345 = dataInputStream.readFloat();
            long long789 = dataInputStream.readLong();

            dataInputStream.close();

            System.out.println("int123     = " + int123);
            System.out.println("float12345 = " + float12345);
            System.out.println("long789    = " + long789);

        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }

}
