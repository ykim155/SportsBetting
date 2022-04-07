
package src.serverside;

// Java implementation for a client
// Save file as Client.java

import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class client
{
	public void run() throws UnknownHostException, IOException
	{
		try
		{
			Scanner scn = new Scanner(System.in);
	
			// establish the connection with server port 4446
			Socket s = new Socket("192.168.1.11", 4446);
	
			// obtaining input and out streams
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	
			// the following loop performs the exchange of
			// information between client and client handler
			while (true)
			{
				System.out.println(dis.readUTF());
				String tosend = scn.nextLine();
				dos.writeUTF(tosend);
				
				// If client sends exit,close this connection
				// and then break from the while loop
				if(tosend.equals("Exit"))
				{
					System.out.println("Closing this connection : " + s);
					s.close();
					System.out.println("Connection closed");
					break;
				}
				
				// printing date or time as requested by client
				String received = dis.readUTF();
				System.out.println(received);
			}
			
			// closing resources
			scn.close();
			dis.close();
			dos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
