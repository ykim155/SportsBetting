package src;

// Fanduel Java Swing App

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import java.lang.Math;

public class server extends JFrame{
    public static void main(String[] args){
        server frame = new server();
        frame.setVisible(true);
    }

    public Font Shentox;
    public Font NovaBold;
    public Font NovaReg;


    public server()
    {
        setSize(960, 620);

		Date  date = new Date();
		String str = String.format("%tc", date);
			   
       	   
		String titleString = "--- Fanduel Server --- " + str; 				    
		setTitle(titleString);
			
		NumberFormat formatter = new DecimalFormat("#0.00");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel server = new JPanel();
        server.setLayout(null);
        TitledBorder title = new TitledBorder(new LineBorder(server.getBackground(), 1), "Server");
        title.setTitleFont(Shentox);
        server.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
        setContentPane(server);

        JLabel userL = new JLabel("Registered Users: ");
		userL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userL.setBounds(30, 20, 150, 100);
		server.add(userL);

		JTextArea userF = new JTextArea();
		userF.setEditable(false);
		userF.setBounds(30, 80, 150, 400);
		server.add(userF);

        JLabel currentL = new JLabel("Current Users: ");
		currentL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		currentL.setBounds(220, 20, 150, 100);
		server.add(currentL);

		JTextArea currentF = new JTextArea();
		currentF.setEditable(false);
		currentF.setBounds(220, 80, 150, 400);
		server.add(currentF);

        JLabel moneyBL = new JLabel("Money Bet Today: ");
		moneyBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		moneyBL.setBounds(410, 20, 150, 100);
		server.add(moneyBL);

		JTextArea moneyF = new JTextArea();
		moneyF.setEditable(false);
		moneyF.setBounds(410, 80, 150, 50);
		server.add(moneyF);

        JLabel betL = new JLabel("Total Bets Today: ");
		betL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		betL.setBounds(410, 120, 150, 100);
		server.add(betL);

		JTextArea betF = new JTextArea();
		betF.setEditable(false);
		betF.setBounds(410, 180, 150, 50);
		server.add(betF);

        JLabel payoutL = new JLabel("Total Payouts Today: ");
		payoutL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		payoutL.setBounds(410, 220, 200, 100);
		server.add(payoutL);

		JTextArea payoutF = new JTextArea();
		payoutF.setEditable(false);
		payoutF.setBounds(410, 280, 150, 50);
		server.add(payoutF);

        JLabel profitL = new JLabel("Total Profit Today: ");
		profitL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profitL.setBounds(410, 320, 150, 100);
		server.add(profitL);

		JTextArea profitText = new JTextArea();
		profitText.setEditable(false);
		profitText.setBounds(410, 380, 150, 50);
		server.add(profitText);

        JLabel requestL = new JLabel("Total Requests Today: ");
		requestL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		requestL.setBounds(410, 420, 200, 100);
		server.add(requestL);

		JTextArea requestText = new JTextArea();
		requestText.setEditable(false);
		requestText.setBounds(410, 480, 150, 50);
		server.add(requestText);

        JLabel statesL = new JLabel("Trending States: ");
		statesL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		statesL.setBounds(600, 20, 150, 100);
		server.add(statesL);

		JTextArea statesText = new JTextArea();
		statesText.setEditable(false);
		statesText.setBounds(600, 80, 150, 400);
		server.add(statesText);

        JLabel sportsL = new JLabel("Trending Sports: ");
		sportsL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sportsL.setBounds(790, 20, 150, 100);
		server.add(sportsL);

		JTextArea sportsText = new JTextArea();
		sportsText.setEditable(false);
		sportsText.setBounds(790, 80, 150, 400);
		server.add(sportsText);

        JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Helvetica", Font.BOLD, 16));
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{			
				    dispose();
			}
			
		});
		exit.setBounds(800, 560, 133, 34);
		server.add(exit);

		refreshTitleBar();
    }

	private void refreshTitleBar()
	    {	
		   Thread refreshAllTitleBar = new Thread()
		   {
			  public void run()
			  { 
				 while (true)
				 {
					 try 
					 {
					   //
					   // display current time
					   //
					   Date  date = new Date();
					   String str = String.format("%tc", date);
	              	   
					   String titleString = "--- Fanduel --- " + str; 				 
					   
					   setTitle(titleString);
						 
					   sleep(5000L);                   // sleep for 5 seconds or 5,000 milliseconds
					   
	                 } // end try block
				  
			         catch (InterruptedException e) 
			         {
			        	 JOptionPane.showMessageDialog(null, 
	                              "ERROR. Interrupt Exception! Check Internet Connection!",
	                              "Title Top Bar",
	                              JOptionPane.WARNING_MESSAGE);
			        	 
			        	 continue;
				     }
			         finally
			         {
				   
			         }
				 } // end while true
		     }
		  };

	      refreshAllTitleBar.start();
	    }
}