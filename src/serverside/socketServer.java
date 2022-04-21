package src.serverside;

import java.io.IOException;
import java.io.BufferedReader;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class socketServer implements Runnable
{
	   Socket csocket;
	   String ipString;
	   char threadType;

	   static Vector<String> vec = new Vector<String>(5);
	   
	   static final String newline = "\n";
	   static int first_time = 1;
	   
	   static int port_num = 3333;
	   
	   static int numOfConnections = 0;
	   static int numOfMessages = 0;
	   static int max_connections = 5;
	   static int numOfTransactions = 0; 
	   static volatile Vector<String> messagStrings = new Vector<String>(30);

	   

	   socketServer(Socket csocket, String ip)
	   {
	      this.csocket  = csocket;
	      this.ipString = ip;
	   } 

	   public static void runSockServer()   // throws Exception
	   {
	     boolean sessionDone = false;
	  
	     ServerSocket ssock = null;
	   
	     try
	     {
		   ssock = new ServerSocket(port_num);
	     }
	     catch (BindException e)
	     {
		    e.printStackTrace();
	     }
	     catch (IOException e)
	     {
		    e.printStackTrace();
	     }
	 
	     // update the status text area to show progress of program
	     try 
	     {
		     InetAddress ipAddress = InetAddress.getLocalHost();
		     serverSearch.incoming.append("IP Address : " + ipAddress.getHostAddress() + newline);
	     }
	     catch (UnknownHostException e1)
	     {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
	     }
	 
	     serverSearch.incoming.append("Listening on port " + port_num + newline);
	 
	     
	     sessionDone = false;
	     while (sessionDone == false)
	     {
	        Socket sock = null;
		    try
		    {
		       //	
  	     	   // blocking system call
		       //	
			   sock = ssock.accept();
		    }
		    catch (IOException e)
		    {
			   e.printStackTrace();
		    }
		 
		    // update the status text area to show progress of program
	        serverSearch.incoming.append("Client Connected : " + sock.getInetAddress() + newline);
	        
	        //
	        // start a NEW THREAD process
	        //
	        new Thread(new socketServer(sock, sock.getInetAddress().toString())).start();
	     }
	 
	     try 
	     {
		    ssock.close();
	     }
	     catch (IOException e) 
	     {
		    e.printStackTrace();
	     }
	}	  

	
	//
	// CLIENT THREAD CODE - This is the thread code that ALL clients will run()
	//
	public void run()
	{
	   try
	   {
		  boolean session_done = false; 
	      long threadId;
	      String clientString;
	      String keyString = "";
	    
	      threadId = Thread.currentThread().getId();
	      
	      numOfConnections++;
	      
	      serverSearch.incoming.append("Num of Connections = " + numOfConnections + newline);
	      
	      keyString = ipString + ":" + threadId;
	      
	      //
	      // write IP address of the client who just connected to the main screen
	      //
	      if (vec.contains(keyString) == false)
	      {
	    	    int counter = 0;
	        	vec.addElement(keyString);
	        	
	        	serverSearch.bottom.setText("");
	        	Enumeration<String> en = vec.elements();
	        	while (en.hasMoreElements())
	        	{
	        		serverSearch.bottom.append(en.nextElement() + " || ");
	        		
	        		if (++counter >= 6)
	        		{
	        			serverSearch.bottom.append("\r\n");
	        			counter = 0;
	        		}
	        	}
	      }
	       
	      PrintStream pstream = new PrintStream (csocket.getOutputStream());
	      BufferedReader rstream = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
	       
	      while (session_done == false)
	      {
	       	if (rstream.ready())   // check for any data messages
	       	{
	              clientString = rstream.readLine();
	              
	              // update the status text area to show progress of program
	              serverSearch.incoming.append("RECV : " + clientString + newline);
	     	       
	     	       // update the status text area to show progress of program
	              serverSearch.incoming.append("RLEN : " + clientString.length() + newline);
	              
	              if (clientString.length() > 60) // we need to add more cases i guess, to update the corresponding serverSearch field
	              {
	           	   	session_done = true;
					messagStrings.addElement(clientString);
					serverSearch.userList.append(messagStrings.toString() + newline);
	           	   	continue;
	              }

	              if (clientString.contains("quit"))
	              {
	                session_done = true;
	                fileIO fio = new fileIO();
	                fio.wrTransactionData(serverSearch.incoming.getText());
	              }
	              else if (clientString.contains("QUIT"))
	              {
	                session_done = true;
	                fileIO fio = new fileIO();
	                fio.wrTransactionData(serverSearch.incoming.getText());
	              }
	              else if (clientString.contains("Quit"))
	              {
	                session_done = true;
	                fileIO fio = new fileIO();
	                fio.wrTransactionData(serverSearch.incoming.getText());
	              }
	              else if (clientString.contains("Date>"))
	              {
	            	numOfMessages++;
	            	  
	            	// Create an instance of SimpleDateFormat used for formatting 
	            	// the string representation of date (month/day/year)
	            	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	            	// Get the date today using Calendar object.
	            	Date today = Calendar.getInstance().getTime();
	            	
	            	// Using DateFormat format method we can create a string 
	            	// representation of a date with the defined format.
	            	String reportDate = df.format(today);

	            	//
	            	// Print what date is today! Send to the individual THREAD
	            	//
	            	pstream.println("Num Of Messages : " + numOfMessages + "   Simple Date: " + reportDate);
	              }
	              else
	              {
	            	  pstream.println("NACK : ERROR : No such command!");
	              }
	       	   }
	         			    		        	
	           Thread.sleep(500);
	           
	        }    // end while loop
	
            keyString = ipString + ":" + threadId;
	      
	      
	        numOfConnections--;

	        // close client socket
	        csocket.close();
	       
	        // update the status text area to show progress of program
	        serverSearch.incoming.append("Child Thread : " + threadId + " : is Exiting!!!" + newline);
	        serverSearch.incoming.append("Num of Connections = " + numOfConnections);
	        
		     
	     } // end try  
	     catch (SocketException e)
	     {
		  // update the status text area to show progress of program
	    	 serverSearch.incoming.append("ERROR : Socket Exception!" + newline);
	     }
	     catch (InterruptedException e)
	     {
		  // update the status text area to show progress of program
	    	 serverSearch.incoming.append("ERROR : Interrupted Exception!" + newline);
	     }
	     catch (UnknownHostException e)
	     {
		  // update the status text area to show progress of program
	    	 serverSearch.incoming.append("ERROR : Unkonw Host Exception" + newline);
	     }
	     catch (IOException e) 
	     {
	     // update the status text area to show progress of program
	    	 serverSearch.incoming.append("ERROR : IO Exception!" + newline);
	     }     
	     catch (Exception e)
	     { 
		  numOfConnections--;
		  
		  // update the status text area to show progress of program
		  serverSearch.incoming.append("ERROR : Generic Exception!" + newline);
	     }
	   
	  }  // end run() thread method
//public String decodeMessage(String clientString){
//	return clientString;
//}
}