package com.marcellobologna.formazione.networking;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by Marcello Bologna on 05/04/17.
 */
public class URLConnectionDemo {

    public static void main(String args[]) throws Exception {
        int c;
        URL hp = new URL("http://www.internic.net");

        // Set these if behind a proxy
        System.setProperty("http.proxyHost", "proxy.ariadne.it");
        System.setProperty("http.proxyPort", "3128");

        URLConnection hpCon = hp.openConnection();

        // get date
        long d = hpCon.getDate();
        if (d == 0)
            System.out.println("No date information.");
        else
            System.out.println("Date: " + new Date(d));

        // get content type
        System.out.println("Content-Type: " + hpCon.getContentType());

        // get expiration date
        d = hpCon.getExpiration();
        if (d == 0)
            System.out.println("No expiration information.");
        else
            System.out.println("Expires: " + new Date(d));

        // get last-modified date
        d = hpCon.getLastModified();
        if (d == 0)
            System.out.println("No last-modified information.");
        else
            System.out.println("Last-Modified: " + new Date(d));

        // get content length
        long len = hpCon.getContentLengthLong();
        if (len == -1)
            System.out.println("Content length unavailable.");
        else
            System.out.println("Content-Length: " + len);
        if (len != 0) {
            System.out.println("=== Content ===");
            InputStream input = hpCon.getInputStream();
            while (((c = input.read()) != -1)) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("No content available.");
        }
    }
}
