package com.marcellobologna.formazione.nio.channelbasedio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Marcello Bologna on 04/04/17.
 * <p>
 * The advantage to this approach is that the data written to the buffer will automatically be written to the file. No
 * explicit write operation is necessary.
 */
public class MappedChannelWrite {

    public static void main(String args[]) {
        // Obtain a channel to a file within a try-with-resources block.
        try (FileChannel fChan = (FileChannel)
                Files.newByteChannel(Paths.get("/home/local/ARIADNE/bologna/Documenti/prove/toglimi.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ,
                        StandardOpenOption.CREATE)) {

            // Then, map the file into a buffer.
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            // Write some bytes to the buffer.
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }

}
