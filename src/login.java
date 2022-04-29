package src;

import java.awt.event.*;
import javax.swing.*;

import src.serverside.serverSearch;

import java.awt.*;
import java.io.*; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class login extends JFrame{
    public static void main(String[] args){
        login frame = new login();
        frame.setVisible(true);
    }
    Font Shentox;
    Font NovaBold;
    Font NovaReg;

    private String username;
    private String password;

    public login()
    {
			// Frame title display current time
			//
			Date  date = new Date();
			String str = String.format("%tc", date);
			   
       	   
			String titleString = "--- FanDuel --- " + str; 				    
			setTitle(titleString);
			
			NumberFormat formatter = new DecimalFormat("#0.00");
			
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Custom Fanduel Fonts
        try {
            Shentox = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/ShentoxBold.ttf")).deriveFont(32f);
            NovaBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/Proxima Nova Bold.ttf")).deriveFont(18f);
            NovaReg = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/Proxima Nova Reg.ttf")).deriveFont(14f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/ShentoxBold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/Proxima Nova Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/Proxima Nova Reg.ttf")));
        } 
        catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Set the size of the app.
        setSize(960, 620);

        // login Panel and Border
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setBackground(Color.decode("#CFD6DB"));
        setContentPane(login);


        // Logo
        BufferedImage logojpg = null;
        try {
            logojpg = ImageIO.read(new File("src/resources/fanduel-vertical-logo.png"));
            Image conv = logojpg.getScaledInstance(409, 290, Image.SCALE_SMOOTH);
            JLabel logo = new JLabel(new ImageIcon(conv));
            logo.setBounds(280,5,409,290);
            login.add(logo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        JLabel loginAsk = new JLabel("Login:");
        loginAsk.setFont(NovaBold);
        loginAsk.setBounds(380, 315, 100, 50);
        login.add(loginAsk);

        JTextField nameField = new JTextField();
        nameField.setEditable(true);
        nameField.setBounds(430, 330, 150, 20);
        login.add(nameField);

        JLabel passwordAsk = new JLabel("Password:");
        passwordAsk.setFont(NovaBold);
        passwordAsk.setBounds(345, 350, 100, 50);
        login.add(passwordAsk);

        JTextField passwordField = new JTextField();
        passwordField.setEditable(true);
        passwordField.setBounds(430, 365, 150, 20);
        login.add(passwordField);

        JButton log = new JButton("Login");
        log.setFont(NovaReg);
        log.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                String nameString = nameField.getText();
                nameString = nameString.trim();
                if (!nameString.equals("user"))
                {
                    JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Wrong username!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
                }

                String passwordString = passwordField.getText();
                passwordString = passwordString.trim();
                if (!passwordString.equals("123"))
                {
                    JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Wrong password!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
                }
                /*if (nameString.equals("admin") && passwordString.equals("321"))
                {
                    serverSearch serv = new serverSearch();
                    serv.setVisible(true);
                } */

                nameField.setText("");
                passwordField.setText("");

                fanduel fanD = new fanduel();   
                setVisible(false); // Hide current frame
                fanD.setVisible(true);
                dispose();
            }
        });

        log.setBounds(420, 400, 100, 20);
        login.add(log);

        JLabel signUp = new JLabel("Need to sign up?");
        signUp.setFont(NovaReg);
        signUp.setBounds(417, 450, 150, 20);
        login.add(signUp);

        JButton sign = new JButton("Sign Up");
        sign.setFont(NovaReg);
        sign.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                signup sign = new signup();
                setVisible(false);
                sign.setVisible(true);
                dispose();
            }
        });
        sign.setBounds(395, 470, 150, 20);
        login.add(sign);

        JButton test = new JButton("Test");
        test.setFont(NovaReg);
        test.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                String nameString = nameField.getText();
                nameString = nameString.trim();
                if (!nameString.equals("admin"))
                {
                    JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Wrong username!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
                }

                String passwordString = passwordField.getText();
                passwordString = passwordString.trim();
                if (!passwordString.equals("321"))
                {
                    JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Wrong password!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
                }
                serverSearch serv = new serverSearch();
                    serv.setVisible(true);
                    //test = new socketUtils();
            }
        }
        );
        test.setBounds(395, 500, 150, 20);
        login.add(test);
        

        

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
	              	   
					   String titleString = "--- Login --- " + str; 				 
					   
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
