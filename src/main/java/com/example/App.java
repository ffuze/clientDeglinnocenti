package com.example;

import java.io.IOException;
import java.net.Socket;

import com.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Client cliente = new Client();
        cliente.connetti();
        cliente.comunica();
    }
}
