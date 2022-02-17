package src;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class signup extends JFrame{
    public static void main(String[] args){
        signup frame = new signup();
        frame.setVisible(true);
    }
    Font Shentox;
    Font NovaBold;
    Font NovaReg;

    private String name;
    private String password;
    private String address;
    private String zipcode;

    private int year;
    private int month;

    public signup(){
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

        // signup Panel and Border
        JPanel signup = new JPanel();
        signup.setLayout(null);
        TitledBorder title = new TitledBorder(new LineBorder(signup.getBackground(), 1), "           Signup");
        title.setTitleFont(Shentox);
        signup.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
        setContentPane(signup);


        // Logo
        BufferedImage logojpg = null;
        try {
            logojpg = ImageIO.read(new File("src/resources/FanDuel-shield-logo.png"));
            Image conv = logojpg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            JLabel logo = new JLabel(new ImageIcon(conv));
            logo.setBounds(20,5,50,50);
            signup.add(logo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //
		//  create a label for status
		//
		JLabel statusLabel = new JLabel("Status : ");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(360, 330, 100, 23);
		signup.add(statusLabel);
		
		//
		// field where to see status information
		//
		JTextField status = new JTextField();
		status.setEditable(false);
		status.setBounds(420, 330, 100, 34);
		signup.add(status);
		status.setColumns(40);
		status.setBackground(Color.LIGHT_GRAY);
        //
		//  create a Name Label
		//
		JLabel nameL = new JLabel("     Name : ");
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameL.setBounds(30, 50, 200, 23);
		signup.add(nameL);
		
		//
		// field where user full name
		//
		JTextField nameF = new JTextField();
		nameF.setEditable(true);
		nameF.setBounds(100, 50, 150, 34);
		nameF.setColumns(30);
		nameF.addMouseListener(new MouseListener() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				status.setText("");;
				status.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
		});
		signup.add(nameF);
		
		
		
		//
		//  create a Address Label
		//
		JLabel addressL = new JLabel("  Address : ");
		addressL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressL.setBounds(30, 100, 200, 23);
		signup.add(addressL);
		
		//
		// field where user address
		//
		JTextField addressF = new JTextField();
		addressF.setEditable(true);
		addressF.setBounds(100, 100, 150, 34);
		nameF.setColumns(40);
		signup.add(addressF);
		
		
		//
		//  create a city Label
		//
		JLabel cityL = new JLabel("     City : ");
		cityL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cityL.setBounds(30, 150, 200, 23);
		signup.add(cityL);
		
		//
		// field where user city
		//
		JTextField cityF = new JTextField();
		cityF.setEditable(true);
		cityF.setBounds(100, 150, 150, 34);
		cityF.setColumns(40);
		signup.add(cityF);
		
		
		//
		//  create a state Label
		//
		JLabel stateL = new JLabel("   State : ");
		stateL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stateL.setBounds(30, 200, 200, 23);
		signup.add(stateL);
		
		//
		// field where user state
		//
		
		// array of string containing state
        String s1[] = { "", "CT", "NY", "MA", "RI", "NJ", "VT", "NH" };
        @SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox stateF = new JComboBox(s1);
		stateF.setBounds(100, 200, 150, 34);
		signup.add(stateF);
		
		//
		//  create a zip Label
		//
		JLabel zipL = new JLabel("      Zip : ");
		zipL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		zipL.setBounds(30, 250, 200, 23);
		signup.add(zipL);
		
		//
		// field where user zip
		//
		JTextField zipF = new JTextField();
		zipF.setEditable(true);
		zipF.setBounds(100, 250, 150, 34);
		zipF.setColumns(40);
		signup.add(zipF);
		
		
		//
		//  create a phone Label
		//
		JLabel phoneL = new JLabel("    Phone : ");
		phoneL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneL.setBounds(30, 300, 200, 23);
		signup.add(phoneL);
		
		//
		// field where user phone
		//
		JTextField phoneF = new JTextField();
		phoneF.setEditable(true);
		phoneF.setBounds(100, 300, 150, 34);
		phoneF.setColumns(40);
		signup.add(phoneF);
		
		//
		//  create a email Label
		//
		JLabel emailL = new JLabel("    Email : ");
		emailL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailL.setBounds(30, 350, 200, 23);
		signup.add(emailL);
		
		//
		// field where user email
		//
		JTextField emailF = new JTextField();
		emailF.setEditable(true);
		emailF.setBounds(100, 350, 150, 34);
		emailF.setColumns(40);
		signup.add(emailF);
		

        // DOB label
		JLabel dobL = new JLabel("     Date of Birth : ");
		dobL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dobL.setBounds(450, 50, 200, 23);
		signup.add(dobL);
		
		//
		// month
		//
		JTextField monthF = new JTextField();
		monthF.setEditable(true);
		monthF.setBounds(570, 50, 30, 34);
		monthF.setColumns(30);
        signup.add(monthF);
		
        //
		// day
		//
		JTextField dayF = new JTextField();
		dayF.setEditable(true);
		dayF.setBounds(600, 50, 30, 34);
		dayF.setColumns(30);
        signup.add(dayF);

        //
		// year
		//
		JTextField yearF = new JTextField();
		yearF.setEditable(true);
		yearF.setBounds(630, 50, 50, 34);
		yearF.setColumns(30);
        signup.add(yearF);
		
		//
		//  Social Security
		//
		JLabel socialL = new JLabel("  Social Security : ");
		socialL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		socialL.setBounds(450, 100, 200, 23);
		signup.add(socialL);
		
		//
		// field where user address
		//
		JTextField socialF = new JTextField();
		socialF.setEditable(true);
		socialF.setBounds(570, 100, 150, 34);
		socialF.setColumns(40);
		signup.add(socialF);
		
		//bank label
		JLabel bankL = new JLabel("     Bank # : ");
		bankL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bankL.setBounds(450, 150, 200, 23);
		signup.add(bankL);
		
		//
		// field for bank number
		//
		JTextField bankF = new JTextField();
		bankF.setEditable(true);
		bankF.setBounds(570, 150, 150, 34);
		bankF.setColumns(40);
		signup.add(bankF);

        //routing label
		JLabel routeL = new JLabel("     Routing # : ");
		routeL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		routeL.setBounds(450, 200, 200, 23);
		signup.add(routeL);
		
		//
		// field for bank number
		//
		JTextField routeF = new JTextField();
		routeF.setEditable(true);
		routeF.setBounds(570, 200, 150, 34);
		routeF.setColumns(40);
		signup.add(routeF);

        //
		//  create a password Label
		//
		JLabel passwordL = new JLabel("      Password : ");
		passwordL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordL.setBounds(450, 250, 200, 23);
		signup.add(passwordL);
		
		//
		// field where user zip
		//
		JTextField passwordF = new JTextField();
		passwordF.setEditable(true);
		passwordF.setBounds(570, 250, 150, 34);
		passwordF.setColumns(40);
		signup.add(passwordF);


        //
		// EXIT Button
		//
		JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{			
				    dispose();
			}
			
		});
		exit.setBounds(30, 420, 133, 34);
		signup.add(exit);		
		
		//
		// SUBMIT Button
		//
		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{			
				String nameFieldStr = nameF.getText();
				nameFieldStr        = nameFieldStr.trim();
				if (nameFieldStr == "" || nameFieldStr == null || nameFieldStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Name field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				String addressFieldStr = addressF.getText();
				addressFieldStr           = addressFieldStr.trim();
				if (addressFieldStr == "" || addressFieldStr == null || addressFieldStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Address field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				
				String cityFieldStr = cityF.getText();
				cityFieldStr        = cityFieldStr.trim();
				if (cityFieldStr == "" || cityFieldStr == null || cityFieldStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  City field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				
				//
				// state filed is a Combo Box
				//
				String selectedStateStr  = (String) stateF.getSelectedItem();
				selectedStateStr        = selectedStateStr.trim();
				if (selectedStateStr == "" || selectedStateStr == null || selectedStateStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  State field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				
				
				String zipFieldStr = zipF.getText();
				zipFieldStr        = zipFieldStr.trim();
				if (zipFieldStr == "" || zipFieldStr == null || zipFieldStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Zip Code field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean rc = checkZipCode(zipFieldStr);
				if (rc == false)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Invalid zip code number was found in the field!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
		
				String phoneFieldStr = phoneF.getText();
				phoneFieldStr        = phoneFieldStr.trim();
				if (phoneFieldStr == "" || phoneFieldStr == null || phoneFieldStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Phone Number field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				
				String emailFieldStr = emailF.getText();
				emailFieldStr         = emailFieldStr.trim();
				if (emailFieldStr == "" || emailFieldStr == null || emailFieldStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  E-mail field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
                String yearStr = yearF.getText();
				yearStr        = yearStr.trim();
				if (yearStr == "" || yearStr == null || yearStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Year field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean bc = checkYear(yearStr);
				if (bc == false)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Invalid birth year was found in the field!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}

                String monthStr = monthF.getText();
				monthStr        = monthStr.trim();
				if (monthStr == "" || monthStr == null || monthStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Month field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean oc = checkMonth(monthStr);
				if (oc == false)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Invalid month was found in the field!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}

                String dayStr = dayF.getText();
				dayStr        = dayStr.trim();
				if (dayStr == "" || dayStr == null || dayStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Day field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean xc = checkDay(dayStr);
				if (xc == false)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Invalid Day was found in the field!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
                String socialStr = socialF.getText();
				socialStr        = socialStr.trim();
				if (socialStr == "" || socialStr == null || socialStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Social Security field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean zc = checkSocial(socialStr);
				if (zc == false)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Invalid SSN was found in the field!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}

                String bankStr = bankF.getText();
				bankStr        = bankStr.trim();
				if (bankStr == "" || bankStr == null || bankStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Bank Number field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean vc = checkBank(bankStr);
				if (vc == false)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Invalid Bank Number was found in the field!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}

                String routeStr = routeF.getText();
				routeStr        = routeStr.trim();
				if (routeStr == "" || routeStr == null || routeStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Routing Number field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean kc = checkRoute(routeStr);
				if (kc == false)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Invalid Routing Number was found in the field!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}

                String passwordStr = passwordF.getText();
				passwordStr        = passwordStr.trim();
				if (passwordStr == "" || passwordStr == null || passwordStr.length() == 0)
				{
					JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Password field is empty!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				nameF.setText("");
				addressF.setText("");
				cityF.setText("");
				
				stateF.setSelectedItem("");
				
				zipF.setText("");
				phoneF.setText("");
				emailF.setText("");

                monthF.setText("");
                dayF.setText("");
                yearF.setText("");

                socialF.setText("");
                bankF.setText("");
                routeF.setText("");

                passwordF.setText("");
		
			    status.setText("Success!");
			    status.setBackground(Color.GREEN);

                fanduel fanD = new fanduel();   
                setVisible(false); // Hide current frame
                fanD.setVisible(true);
                dispose();
			}
		});
		submit.setBounds(250, 420, 133, 34);
		signup.add(submit);		
		
		
		
		
		//
		// HELP Button
		//
		JButton help = new JButton("HELP");
		help.setFont(new Font("Tahoma", Font.PLAIN, 16));
		help.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{			
                   
			}
			
		});
		help.setBounds(450, 420, 133, 34);
		signup.add(help);		
		
		
		
		
		
		// user will do the layout
		signup.setLayout(null);
		
		// position frame in the middle of the screen
		this.setLocationRelativeTo(null);
	}
	
	
	//
	// checks for valid zip code string
	//
	private boolean checkZipCode(String s)
	{
		int length, i;
		char c;
		
		
		if (s.length() != 5)
			return false;
		
		length = s.length();
		for (i=0;i < length;i++)
		{
			c = s.charAt(i);
			
			if (c >= '0' && c <= '9')
				continue;
			else
				return false;
		}
		
		return true;
	}

    private boolean checkDay(String s)
	{
		int length, i;
		char c;
		
		
		if (s.length() > 2)
			return false;
		
		length = s.length();
		for (i=0;i < length;i++)
		{
			c = s.charAt(i);
			
			if (c >= '0' && c <= '9')
				continue;
			else
				return false;
		}
		
		return true;
	}
    private boolean checkMonth(String s)
	{
		int length, i;
		char c;
		
		
		if (s.length() > 2)
			return false;
		
		length = s.length();
		for (i=0;i < length;i++)
		{
			c = s.charAt(i);
			
			if (c >= '0' && c <= '9')
				continue;
			else
				return false;
		}

        month = Integer.parseInt(s);
        if (month > 12)
        {
            return false;
        }
		
		return true;
	}
    private boolean checkYear(String s)
	{
		int length, i;
		char c;
		
		
		if (s.length() != 4)
			return false;
		
		length = s.length();
		for (i=0;i < length;i++)
		{
			c = s.charAt(i);
			
			if (c >= '0' && c <= '9')
				continue;
			else
				return false;
		}

        year = Integer.parseInt(s);
        if (2022 - year <= 18)
        {
            return false;
        }
		
		return true;
	}

    private boolean checkSocial(String s)
	{
		int length, i;
		char c;
		
		
		if (s.length() != 9)
			return false;
		
		length = s.length();
		for (i=0;i < length;i++)
		{
			c = s.charAt(i);
			
			if (c >= '0' && c <= '9')
				continue;
			else
				return false;
		}
		
		return true;
	}

    private boolean checkBank(String s)
	{
		int length, i;
		char c;
		
		length = s.length();
		for (i=0;i < length;i++)
		{
			c = s.charAt(i);
			
			if (c >= '0' && c <= '9')
				continue;
			else
				return false;
		}
		
		return true;
	}

    private boolean checkRoute(String s)
	{
		int length, i;
		char c;
		
		length = s.length();
		for (i=0;i < length;i++)
		{
			c = s.charAt(i);
			
			if (c >= '0' && c <= '9')
				continue;
			else
				return false;
		}
		
		return true;
	}
}

