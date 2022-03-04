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
		userF.setBounds(30, 100, 150, 400);
		server.add(userF);

        JLabel currentL = new JLabel("Current Users: ");
		currentL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		currentL.setBounds(220, 20, 150, 100);
		server.add(currentL);

		JTextArea currentF = new JTextArea();
		currentF.setEditable(false);
		currentF.setBounds(220, 100, 150, 400);
		server.add(currentF);

        JLabel moneyBL = new JLabel("Money Bet Today: ");
		moneyBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		moneyBL.setBounds(410, 20, 150, 100);
		server.add(moneyBL);

        JLabel betL = new JLabel("Total Bets Today: ");
		betL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		betL.setBounds(410, 120, 150, 100);
		server.add(betL);

        JLabel payoutL = new JLabel("Total Payouts Today: ");
		payoutL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		payoutL.setBounds(410, 220, 200, 100);
		server.add(payoutL);

        JLabel profitL = new JLabel("Total Profit Today: ");
		profitL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profitL.setBounds(410, 320, 150, 100);
		server.add(profitL);

        JLabel requestL = new JLabel("Total Requests Today: ");
		requestL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		requestL.setBounds(410, 420, 200, 100);
		server.add(requestL);

        JLabel statesL = new JLabel("Trending States: ");
		statesL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		statesL.setBounds(600, 20, 150, 100);
		server.add(statesL);

		JTextArea statesText = new JTextArea();
		statesText.setEditable(false);
		statesText.setBounds(600, 100, 150, 400);
		server.add(statesText);

        JLabel sportsL = new JLabel("Trending Sports: ");
		sportsL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sportsL.setBounds(790, 20, 150, 100);
		server.add(sportsL);

		JTextArea sportsText = new JTextArea();
		sportsText.setEditable(false);
		sportsText.setBounds(790, 100, 150, 400);
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
    }
}