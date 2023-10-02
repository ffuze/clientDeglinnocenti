package com;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
    String nomeServer = "localhost";
    int portaServer = 1248;
    Socket mySocket;
    BufferedReader tastiera;
    String stringUtente;
    String stringDest;
    DataOutputStream outputServer;
    BufferedReader inputServer;

    public Socket connetti() throws IOException{
        System.out.println("Il client sta ascoltando...");

        try{
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mySocket = new Socket(nomeServer, portaServer);
            outputServer = new DataOutputStream(mySocket.getOutputStream());
            inputServer = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            
        } catch(UnknownHostException e){
            System.out.println("Host sconosciuto");
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1);
        }

        return mySocket;
    }

    public void comunica(){
        try{
            System.out.println("Inserisci la stringa da trasmettere al server: " + "\n");
            stringUtente = tastiera.readLine();
            System.out.println("Ora invio la stringa ed attendo...");
            outputServer.writeBytes(stringUtente + "\n");
            stringDest = inputServer.readLine();
            System.out.println("Ho ricevuto una risposta dal server: " + "\n"+ stringDest);
            System.out.println("Client: termina elaborazione e chiude connessione");
            mySocket.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione del server");
            System.exit(1);
        }
    }

}