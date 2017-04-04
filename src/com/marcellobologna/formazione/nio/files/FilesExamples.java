package com.marcellobologna.formazione.nio.files;

/**
 * Created by Marcello Bologna on 04/04/17.
 * <p>
 * Many of the actions that you perform on a file are provided by static methods within the Files class. The file to be
 * acted upon is specified by its Path. Thus, the Files methods use a Path to specify the file that is being operated
 * upon. Files contains a wide array of functionality. For example, it has methods that let you open or create a file
 * that has the specified path. You can obtain information about a Path, such as whether it is executable, hidden, or
 * read- only. Files also supplies methods that let you copy or move files.
 * <p>
 * Notice that several of the methods of Files take an argument of type OpenOption. This is an interface that describes
 * how to open a file. It is implemented by the StandardOpenOption class, which defines an enumeration that has the
 * values: - APPEND Causes output to be written to the end of the file. - CREATE Creates the file if it does not already
 * exist. - CREATE_NEW Creates the file only if it does not already exist. - DELETE_ON_CLOSE Deletes the file when it is
 * closed. - DSYNC Causes changes to the file to be immediately written to the physical file. Normally, changes to a
 * file are buffered by the file system in the interest of efficiency, being written to the file only as needed. - READ
 * Opens the file for input operations. - SPARSE Indicates to the file system that the file is sparse, meaning that it
 * may not be completely filled with data. If the file system does not support sparse files, this option is ignored. -
 * SYNC Causes changes to the file or its metadata to be immediately written to the physical file. Normally, changes to
 * a file are buffered by the file system in the interest of efficiency, being written to the file only as needed. -
 * TRUNCATE_EXISTING Causes a preexisting file opened for output to be reduced to zero length. - WRITE Opens the file
 * for output operations.
 */
public class FilesExamples {
}
