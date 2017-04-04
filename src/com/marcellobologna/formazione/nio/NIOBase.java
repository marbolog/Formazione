package com.marcellobologna.formazione.nio;

import java.nio.Buffer;
import java.nio.channels.Channel;
import java.nio.file.Path;

/**
 * Created by Marcello Bologna on 04/04/17.
 * <p>
 * The NIO system is built on two foundational items: buffers and channels. A buffer holds
 * data. A channel represents an open connection to an I/O device, such as a file or a socket.
 * In general, to use the NIO system, you obtain a channel to an I/O device and a buffer to
 * hold data. You then operate on the buffer, inputting or outputting data as needed.
 */
public class NIOBase {

    /*
    All buffers are subclasses of the Buffer class,
    which defines the core functionality common to all buffers: current position, limit, and
    capacity. The current position is the index within the buffer at which the next read or write
    operation will take place. The current position is advanced by most read or write operations.
    The limit is the index value one past the last valid location in the buffer. The capacity is the
    number of elements that the buffer can hold. Often the limit equals the capacity of the
    buffer. Buffer also supports mark and reset.
     */
    private Buffer b;

    /*
    A channel represents an open connection to an I/O source or destination. Channels implement the Channel interface.
    It extends Closeable, and it extends AutoCloseable.
    */
    private Channel c;

    /*
    Path is the glue that binds together many of the NIO.2 file-based features. It describes a file’s location within the directory structure.
    Path is packaged in java.nio.file, and it inherits the following interfaces: Watchable, Iterable<Path>, and Comparable<Path>.
    (Watchable describes an object that can be monitored for changes.)
     */
    private Path p;


}
