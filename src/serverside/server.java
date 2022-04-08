package src.serverside;

// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// Server class
public class server
{
	public void run() throws IOException
	{
		// server is listening on port 4446
		ServerSocket ss = new ServerSocket(4446);
		
		// running infinite loop for getting
		// client request
		while (true)
		{
			Socket s = null;
			
			try
			{
				// socket object to receive incoming client requests
				s = ss.accept();
				
				System.out.println("A new client is connected : " + s);
				
				// obtaining input and out streams
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				
				System.out.println("Assigning new thread for this client");

				// create a new thread object
				Thread t = new ClientHandler(s, dis, dos);

				// Invoking the start() method
				t.start();
				
			}
			catch (Exception e){
				s.close();
				e.printStackTrace();
			}
		}
	}
}

// ClientHandler class
class ClientHandler extends Thread
{
	final DataInputStream dis;
	final DataOutputStream dos;
	final Socket s;
	

	// Constructor
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
	{
		this.s = s;
		this.dis = dis;
		this.dos = dos;
	}

	@Override
	public void run()
	{
		String received;
		String toreturn;
		while (true)
		{
			try {

				// Ask user what he wants
				dos.writeUTF("What sport are you betting on?..\n"+
							"Type Exit to terminate connection.");
				
				// receive the answer from client
				received = dis.readUTF();
				
				if(received.equals("Exit"))
				{
					System.out.println("Client " + this.s + " sends exit...");
					System.out.println("Closing this connection.");
					this.s.close();
					System.out.println("Connection closed");
					break;
				}
				
				// write on output stream based on the
				// answer from the client
				switch (received) {
				
					case "Basketball" :
						toreturn = "You're betting on Basketball";
						dos.writeUTF(toreturn);
						break;
						
					case "Football" :
						toreturn = "You're betting on Football";
						dos.writeUTF(toreturn);
						break;

                    case "Hockey":
                        toreturn = "You're betting on Hockey";
                        dos.writeUTF(toreturn);
                        break;

                    case "Baseball":
                        toreturn = "You're betting on Baseball";
                        dos.writeUTF(toreturn);
                        break;
						
					default:
						dos.writeUTF("Invalid input");
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try
		{
			// closing resources
			this.dis.close();
			this.dos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
