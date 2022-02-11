package src;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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
        TitledBorder title = new TitledBorder(new LineBorder(login.getBackground(), 1), "           Welcome to FanDuel");
        title.setTitleFont(Shentox);
        login.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
        setContentPane(login);


        // Logo
        BufferedImage logojpg = null;
        try {
            logojpg = ImageIO.read(new File("src/resources/FanDuel-shield-logo.png"));
            Image conv = logojpg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            JLabel logo = new JLabel(new ImageIcon(conv));
            logo.setBounds(20,5,50,50);
            login.add(logo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        JLabel loginAsk = new JLabel("Login:");
        loginAsk.setFont(NovaBold);
        loginAsk.setBounds(150, 150, 100, 50);
        login.add(loginAsk);

        JTextField nameField = new JTextField();
        nameField.setEditable(true);
        nameField.setBounds(250, 165, 150, 20);
        login.add(nameField);

        JLabel passwordAsk = new JLabel("Password:");
        passwordAsk.setFont(NovaBold);
        passwordAsk.setBounds(150, 200, 100, 50);
        login.add(passwordAsk);

        JTextField passwordField = new JTextField();
        passwordField.setEditable(true);
        passwordField.setBounds(250, 213, 150, 20);
        login.add(passwordField);

        JButton log = new JButton("Login");
        log.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        log.setBounds(250, 250, 150, 20);
        login.add(log);

        JLabel signUp = new JLabel("Need to sign up?");
        signUp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        signUp.setBounds(250, 265, 150, 20);
        login.add(signUp);

        JButton sign = new JButton("Sign Up");
        sign.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        sign.setBounds(250, 280, 150, 20);
        login.add(sign);

    }
}
