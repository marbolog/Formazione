package com.marcellobologna.formazione.networking;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Marcello Bologna on 05/04/17.
 */
public class URLDemo {

    public static void main(String args[]) throws MalformedURLException {
        URL hp = new URL("http://www.google.com:80/search");
        System.out.println("Protocol: " + hp.getProtocol());
        System.out.println("Port: " + hp.getPort());
        System.out.println("Host: " + hp.getHost());
        System.out.println("File: " + hp.getFile());
        System.out.println("Ext:" + hp.toExternalForm());
    }

}
