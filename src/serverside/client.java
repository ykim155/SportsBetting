
package src.serverside;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client
{
    PrintWriter out;
    Scanner incom;

    //public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException
    //{
      //  client c = new client();
        //c.run();
    //}

    public void run(String message) throws UnknownHostException, IOException
    {
        System.out.println("Connecting to server...");
        Socket connection = new Socket("localhost", 4446); //Connects to server
        out = new PrintWriter(connection.getOutputStream());
        incom = new Scanner(connection.getInputStream());
        String msg = incom.nextLine();
        System.out.println(msg);
        //String s = "Oranges";
        System.out.println("You sent " + message + ", sending message...");
        out.println(message);
        out.flush();
        msg = incom.nextLine();
        System.out.println(msg);
        out.flush();
    }
}