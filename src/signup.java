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

    private String username;
    private String password;
    private String address;
    private String zipcode;

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
        TitledBorder title = new TitledBorder(new LineBorder(signup.getBackground(), 1), "           signup");
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

        /* 
        Sports Module (Maybe move this to a different file?)
        */
        JLabel sportsLabel = new JLabel("Sports:");
        sportsLabel.setFont(NovaBold);
        sportsLabel.setBounds(20, 50, 100, 50);
        signup.add(sportsLabel);
    }
}
