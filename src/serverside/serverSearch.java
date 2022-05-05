package src.serverside;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class serverSearch extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static JTextArea displayIP;
	public static JTextArea incoming;
	public static JTextArea bottom;
	public static JTextArea userList = new JTextArea("User List:");
	public static JTextArea income;

	public serverSearch(){

		setSize(1000, 600);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// background color
		getContentPane().setBackground(new Color(247, 247, 247));
		
		JLabel titleLabel = new JLabel("Fanduel");
		titleLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(400, 20, 400, 40);
		contentPane.add(titleLabel);
	    
		// green panel on top
		JPanel greenPanel = new JPanel();
	    greenPanel.setBackground(new Color(51, 153, 255)); 
	    greenPanel.setLocation(0, 0);
	    greenPanel.setSize(1000, 85);
	    contentPane.add(greenPanel);
	    greenPanel.setLayout(null);
	  
	    // IP address
	    InetAddress ipAddress = null;
		try{
			ipAddress = InetAddress.getLocalHost();
		}catch (UnknownHostException el){
			el.printStackTrace();
		}
		
		String ip = "10.101.14.44";
	    
	    // display IP and port
		String display = "IP: " + ip + "        Listening on Port #: 3333";
	    displayIP = new JTextArea(display);
	    displayIP.setBounds(10, 100, 980, 30);
		displayIP.setEditable(false);
		displayIP.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		contentPane.add(displayIP);
	 
	    // search bar: filter activity
	    JTextField searchField = new JTextField("Search for user");
	    searchField.setToolTipText("Search for user");
	    searchField.setBounds(10, 135, 680, 40);
	    contentPane.add(searchField);
	    // display users
		//JTextArea userList = new JTextArea("User List:");
		// this is the textarea i used to test the updating of messages hehe
		userList.setBounds(10, 180, 680, 180);
		userList.setEditable(false);
		userList.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		contentPane.add(userList);
		
		// display incoming requests/msgs
		incoming = new JTextArea();
		incoming.setBounds(10, 370, 680, 140);
		incoming.setEditable(false);
		incoming.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		JScrollPane scroll = new JScrollPane (incoming);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 370, 680, 140);
		contentPane.add(scroll);
	   
		JLabel totalBets = new JLabel("Total Bets");
		totalBets.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		totalBets.setForeground(new Color(147,141,141));
		totalBets.setBounds(800, 145, 200, 25);
		contentPane.add(totalBets);

		income = new JTextArea();
		income.setBounds(800, 150, 100, 50);
		income.setEditable(false);
		income.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		contentPane.add(income);


		/*
	    // filter by label + uneditable text field
		JLabel filterBy = new JLabel("Filter By");
		filterBy.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		filterBy.setForeground(new Color(147,141,141));
		filterBy.setBounds(800, 145, 200, 25);
		contentPane.add(filterBy);
		
	    
		JButton nameBtn = new JButton("Name");
		nameBtn.setBounds(700, 200, 150, 25);
		nameBtn.setBorderPainted(false);
		nameBtn.setOpaque(false);
		nameBtn.setForeground(new Color(83,71,71));
		nameBtn.setBackground(new Color(28,255,79));
        nameBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        contentPane.add(nameBtn);
        
        JButton tagBtn = new JButton("ID");
        tagBtn.setBounds(710, 240, 150, 25);
		tagBtn.setBorderPainted(false);
		tagBtn.setOpaque(false);
		tagBtn.setForeground(new Color(147,141,141));
		tagBtn.setBackground(new Color(28,255,79));
		tagBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        contentPane.add(tagBtn);
       
        JButton locationBtn = new JButton("Location");
        locationBtn.setBounds(710, 290, 150, 25);
        locationBtn.setBorderPainted(false);
        locationBtn.setOpaque(false);
        locationBtn.setForeground(new Color(147,141,141));
        locationBtn.setBackground(new Color(28,255,79));
		locationBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        contentPane.add(locationBtn);
        
        JButton accAgeBtn = new JButton("Account Age");
        accAgeBtn.setBounds(710, 340, 200, 25);
		accAgeBtn.setBorderPainted(false);
		accAgeBtn.setOpaque(false);
		accAgeBtn.setForeground(new Color(147,141,141));
		accAgeBtn.setBackground(new Color(28,255,79));
		accAgeBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        contentPane.add(accAgeBtn); */
        
        // bottom area displays IP addresses connected 
        bottom = new JTextArea();
		bottom.setBounds(710, 370, 250, 140);
		bottom.setEditable(false);
		bottom.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		contentPane.add(bottom);
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int result = JOptionPane.showConfirmDialog(null, "Do you really want to exit the Fanduel Server?", "Exit Application", JOptionPane.INFORMATION_MESSAGE);
				//JOptionPane.INFORMATION_MESSAGE: Yes, No, Exit
				if(result == JOptionPane.OK_OPTION){
					dispose();
					System.exit(0);
				}
			}
		});
		exitButton.setBounds(25, 520, 110, 30);
		exitButton.setBorderPainted(false);
		exitButton.setOpaque(true);
		exitButton.setBackground(new Color(28,236,79));
		exitButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		exitButton.setForeground(Color.WHITE);
		contentPane.add(exitButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        /*
		JButton viewButton = new JButton("VIEW");
		viewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				serverGUI second = new serverGUI();   
		        setVisible(false); // Hide current frame
		        second.setVisible(true);
			}
		}); 
		viewButton.setBounds(150, 520, 110, 30);
		viewButton.setBorderPainted(false);
		viewButton.setOpaque(true);
		viewButton.setBackground(new Color(28,236,79));
		viewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		viewButton.setForeground(Color.WHITE);
		contentPane.add(viewButton); */
		
		// clock
        Thread refreshTitleBar = new Thread(){
            public void run(){ 
                 while (true){//Keep running while true (aka always)
                     try {
                       // Display time
                       Date date = new Date();
                       String str = String.format("%tc", date); //format the clock string

                       String title = "Fanduel Server | " + str; //concatenate the time with the title
                       setTitle(title);

                       // sleep for 1 secondxw
                       sleep(1000L); 
                       }
                     catch (InterruptedException e) {}//don't know what it does here cuz ide says so
                     finally{}//same as catch
                 }
             }
          };
          refreshTitleBar.start();
          
          Thread refreshThreadCA = new Thread(){
  			public void run(){ 	
  				socketServer.runSockServer();
  		    }
  		 };

  		 refreshThreadCA.start();
    }
	
}
