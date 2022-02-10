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
            NovaReg = Font.createFont(Font.TRUETYPE_FONT, new File("src/Proxima Nova Reg.ttf")).deriveFont(14f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/ShentoxBold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Proxima Nova Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Proxima Nova Reg.ttf")));
        } 
        catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Set the size of the app.
        setSize(960, 720);

        // Dashboard Panel and Border
        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);
        TitledBorder title = new TitledBorder(new LineBorder(dashboard.getBackground(), 1), "           DASHBOARD");
        title.setTitleFont(Shentox);
        dashboard.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
        setContentPane(dashboard);

        

        /* 
        Sports Module (Maybe move this to a different file?)
        */
        JLabel sportsLabel = new JLabel("Sports:");
        sportsLabel.setFont(NovaBold);
        sportsLabel.setBounds(20, 50, 100, 50);
        dashboard.add(sportsLabel);

        // Sports Buttons
        JPanel sportsButtons = new RoundedPanel(30, Color.decode("#1493FF"), Color.decode("#1493FF"));
        // Create Box Layout for Sports Buttons
        sportsButtons.setLayout(new BoxLayout(sportsButtons, BoxLayout.PAGE_AXIS));
        // Set Position and Size of the Panel
        sportsButtons.setBounds(20, 100, 150, 170);
        // Create "padding"
        sportsButtons.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Add to the Dashboard
        dashboard.add(sportsButtons);

        // Football Button
        JButton footballBtn = new JButton("NFL");
        footballBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                // Event in here.

            }
        });
        // Set Custom Font
        footballBtn.setFont(NovaReg);
        // Set the Size (BoxLayout only listens to MaximumSize)
        footballBtn.setMaximumSize(new Dimension(100,30));
        // Center inside the Panel
        footballBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Add to the Panel
        sportsButtons.add(footballBtn);

        // Space between buttons
        sportsButtons.add(Box.createRigidArea(new Dimension(0, 10)));

        // Basketball Button
        JButton bballBtn = new JButton("NBA");
        bballBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                // Event in here.

            }
        });
        // Set Custom Font
        bballBtn.setFont(NovaReg);
        // Set the Size (BoxLayout only listens to MaximumSize)
        bballBtn.setMaximumSize(new Dimension(100,30));
        // Center inside the Panel
        bballBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Add to the Panel
        sportsButtons.add(bballBtn);

        // Space between buttons
        sportsButtons.add(Box.createRigidArea(new Dimension(0, 10)));

        // Hockey Button
        JButton hockeyBtn = new JButton("NHL");
        hockeyBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                // Event in here.

            }
        });
        // Set Custom Font
        hockeyBtn.setFont(NovaReg);
        // Set the Size (BoxLayout only listens to MaximumSize)
        hockeyBtn.setMaximumSize(new Dimension(100,30));
        // Center inside the Panel
        hockeyBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Add to the Panel
        sportsButtons.add(hockeyBtn);

        // Space between buttons
        sportsButtons.add(Box.createRigidArea(new Dimension(0, 10)));

        // Baseball Button
        JButton baseballBtn = new JButton("NHL");
        baseballBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                // Event in here.

            }
        });
        // Set Custom Font
        baseballBtn.setFont(NovaReg);
        // Set the Size (BoxLayout only listens to MaximumSize)
        baseballBtn.setMaximumSize(new Dimension(100,30));
        // Center inside the Panel
        baseballBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Add to the Panel
        sportsButtons.add(baseballBtn);


        // Current Bets Label
        JLabel currentBetsLabel = new JLabel("Current Bets:");
        currentBetsLabel.setFont(NovaBold);
        currentBetsLabel.setBounds(20, 280, 120, 50);
        dashboard.add(currentBetsLabel);

        /*
        Current Bets Module
        */
        JPanel currentBets = new RoundedPanel(30, Color.decode("#1493FF"), Color.decode("#1493FF"));
        currentBets.setLayout(new BoxLayout(currentBets, BoxLayout.PAGE_AXIS));
        currentBets.setBounds(20, 330, 150, 245);
        currentBets.setBorder(new EmptyBorder(10, 10, 10, 10));
        dashboard.add(currentBets);

        // Games Label
        JLabel gamesLabel = new JLabel("Games");
        gamesLabel.setFont(NovaBold);
        gamesLabel.setBounds(420, 50, 100, 50);
        dashboard.add(gamesLabel);
        
        // Games buttons
        JButton back = new JButton("<");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                // Event in here.

            }
        });
        back.setFont(new Font("Helvetica", Font.BOLD, 30));
        back.setBounds(180, 535, 275, 40);
        dashboard.add(back);


        JButton forward = new JButton(">");
        forward.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                // Event in here.

            }
        });
        forward.setFont(new Font("Helvetica", Font.BOLD, 30));
        forward.setBounds(455, 535, 275, 40);
        dashboard.add(forward);

        /*
        Games Module
        */
        JPanel games = new RoundedPanel(30, Color.decode("#AFBBC2"), Color.decode("#AFBBC2"));
        games.setMaximumSize(new Dimension(550, 600));
        games.setBounds(180, 100, 550, 430);
        games.setBorder(new EmptyBorder(0,0,0,0));
        dashboard.add(games);

    }

}