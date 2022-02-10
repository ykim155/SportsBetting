package src;

// Fanduel Java Swing App

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*; 


public class fanduel extends JFrame{

    // Main Function
    public static void main(String[] args){
        fanduel frame = new fanduel();
        frame.setVisible(true);
    }

    Font Shentox;
    Font NovaBold;
    Font NovaReg;

    public fanduel(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Custom Fanduel Fonts
        try {
            Shentox = Font.createFont(Font.TRUETYPE_FONT, new File("src/ShentoxBold.ttf")).deriveFont(32f);
            NovaBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/Proxima Nova Bold.ttf")).deriveFont(18f);
            NovaReg = Font.createFont(Font.TRUETYPE_FONT, new File("src/Promixa Nova Reg.ttf")).deriveFont(14f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/ShentoxBold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Proxima Nova Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Promixa Nova Reg.ttf")));
        } 
        catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Set the size of the app.
        setSize(960, 720);

        // Dashboard Panel and Border
        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);
        TitledBorder title = new TitledBorder(new LineBorder(dashboard.getBackground(), 1), "DASHBOARD");
        title.setTitleFont(Shentox);
        dashboard.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
        setContentPane(dashboard);

        // Sports Label
        JLabel sports = new JLabel("Sports:");
        sports.setFont(NovaBold);
        sports.setBounds(20, 50, 100, 50);
        dashboard.add(sports);

        // Sports Buttons
        

    }

}