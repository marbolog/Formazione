package com.marcellobologna.formazione.nio.paths;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Marcello Bologna on 05/04/17.
 */
public class DirList {
    public static void main(String args[]) {
        String dirname = "/home/local/ARIADNE/bologna/Documenti/prove/";

        // FILTER:
        // Create a filter that returns true only for writable files.
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path filename) throws IOException {
                if (Files.isWritable(filename)) return true;
                return false;
            }
        };

        // Obtain and manage a directory stream within a try block.

        // Alternative: This obtains a directory stream that contains only those files whose names begin with either
        // "Path" or "Dir" and use either the "java" or "class" extension.
        //Files.newDirectoryStream(Paths.get(dirname), "{Path,Dir}*.{java,class}")

        try (DirectoryStream<Path> dirstrm =
                     Files.newDirectoryStream(Paths.get(dirname), how)) {

            System.out.println("Directory of " + dirname);

            // Because DirectoryStream implements Iterable, we
            // can use a "foreach" loop to display the directory.
            for (Path entry : dirstrm) {
                BasicFileAttributes attribs =
                        Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("<FILE> ");
                System.out.println(entry.getFileName());
            }
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirname + " is not a directory.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}