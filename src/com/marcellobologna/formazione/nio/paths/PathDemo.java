package com.marcellobologna.formazione.nio.paths;

/**
 * Created by Marcello Bologna on 05/04/17.
 * <p>
 * Obtain information about a path and a file.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

class PathDemo {
    public static void main(String args[]) {
        Path filepath = Paths.get("/home/local/ARIADNE/bologna/Documenti/prove/toglimi.txt");

        System.out.println("File Name: " + filepath.getName(1));
        System.out.println("Path: " + filepath);
        System.out.println("Absolute Path: " + filepath.toAbsolutePath());
        System.out.println("Parent: " + filepath.getParent());
        try {
            if (Files.isHidden(filepath))
                System.out.println("File is hidden");
            else
                System.out.println("File is not hidden");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        Files.isWritable(filepath);
        System.out.println("File is writable");
        Files.isReadable(filepath);
        System.out.println("File is readable");
        try {
            BasicFileAttributes attribs =
                    Files.readAttributes(filepath, BasicFileAttributes.class);
            if (attribs.isDirectory())
                System.out.println("The file is a directory");
            else
                System.out.println("The file is not a directory");
            if (attribs.isRegularFile())
                System.out.println("The file is a normal file");
            else
                System.out.println("The file is not a normal file");
            if (attribs.isSymbolicLink())
                System.out.println("The file is a symbolic link");
            else
                System.out.println("The file is not a symbolic link");
            System.out.println("File last modified: " + attribs.lastModifiedTime());
            System.out.println("File size: " + attribs.size() + " Bytes");
        } catch (IOException e) {
            System.out.println("Error reading attributes: " + e);
        }
    }
}