package com.marcellobologna.formazione.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

/**
 * Created by Marcello Bologna on 05/04/17.
 */
public class InetAddressExample {

    public static void main(String args[]) throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();

        System.out.println(address);

        address = InetAddress.getByName("www.ariadne.it");

        System.out.println(address);

        // The getAllByName( ) factory method returns an array of InetAddresses that represent all of the addresses
        // that a particular name resolves to.
        InetAddress SW[] = InetAddress.getAllByName("www.nba.com");

        for (int i = 0; i < SW.length; i++) {
            System.out.println(SW[i]);
        }
    }

}
