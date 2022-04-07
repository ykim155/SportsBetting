package src.serverside;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server implements Runnable
{
    ServerSocket serverSocket;
    Scanner in;
    PrintWriter out;
    Socket connection = null;

    public void run()
    {
        try
        {
            serverSocket = new ServerSocket(4446); //Create server
            System.out.println("Waiting for a connection...");
            this.connection = serverSocket.accept(); //Accept connection
            System.out.println("Connection recieved from " + connection.getInetAddress() + " on port " + connection.getLocalPort());
            out = new PrintWriter(connection.getOutputStream()); //Gets output to connection
            out.flush();
            in = new Scanner(connection.getInputStream()); //Gets input to connection
            out.println("S: Connected to server at " + serverSocket.getLocalPort());
            out.flush();
            System.out.println("Waiting for response...");
            String msg = in.nextLine(); //STOPS HERE
            System.out.println("Returning message...");
            out.println("S: Your message was: " + msg);
            out.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}