package com.example;
import java.io.*;
import java.net.*;


public class Servernt {
    ServerSocket server = null;
    Socket client = null;
    String stringRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi(){
        try{
        server = new ServerSocket(6789);
        client = server.accept();
        server.close();
        inDalClient = new BufferedReader(new InputStreamReader (client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
    }
    catch(Exception e){
        System.exit(1);
    }
    return client;
    }

    public void comunica(){
        try{
            stringRicevuta = inDalClient.readLine();
            stringaModificata = stringRicevuta.toUpperCase();
            outVersoClient.writeBytes(stringaModificata+'\n');
            client.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
