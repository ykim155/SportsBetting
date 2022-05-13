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
import java.net.UnknownHostException;
import src.serverside.*;

public class fanduel extends JFrame{

    // Main Function
    public static void main(String[] args){
        fanduel frame = new fanduel();
        frame.setVisible(true);
    }

    public Font Shentox;
    public Font NovaBold;
    public Font NovaReg;

    private int numGames;
    private int numPages;
    private int gameNum;

    private decode basketball;
    private decode football;
    private decode hockey;
    private decode baseball;

    private Vector<String> homeTeams;
    private Vector<String> awayTeams;

    private Map<String, Float> h2h;
    private Map<String, Float[]> spread;
    private Map<String, Float[]> totals;

    private JPanel games;
    private JPanel gameLabels;
    private JPanel game1;
    private JPanel game2;

    // Game 1, Team 1
    private JLabel g1t1 = new customJLabel(NovaReg);
    private JLabel g1t2 = new customJLabel(NovaReg);

    // Game 1, Team 1, Moneyline
    private JButton g1t1m = new customJButton(NovaReg);
    private JButton g1t2m = new customJButton(NovaReg);

    // Game 1, Team 1, Spread
    private JButton g1t1s = new customJButton(NovaReg);
    private JButton g1t2s = new customJButton(NovaReg);

    // Game 1 under
    private JButton g1under = new customJButton(NovaReg);
    private JButton g1over = new customJButton(NovaReg);

    // Game 2, Team 1
    private JLabel g2t1 = new customJLabel(NovaReg);
    private JLabel g2t2 = new customJLabel(NovaReg);

    // Game 2, Team 1, Moneyline
    private JButton g2t1m = new customJButton(NovaReg);
    private JButton g2t2m = new customJButton(NovaReg);

    // Game 2, Team 1, Spread
    private JButton g2t1s = new customJButton(NovaReg);
    private JButton g2t2s = new customJButton(NovaReg);

    // Game 2 Under
    private JButton g2under = new customJButton(NovaReg);
    private JButton g2over = new customJButton(NovaReg);

    // Current Bet Variables
    float odd;
    String oddStr;
    float point = 0;
    String pointStr;

    // Server variables
    boolean connected;
    socketUtils test;

    // Place Bet Panel
    JPanel placeBets;
    JPanel currentBets;

    // wallet variables
    JPanel wallet;
    JTextField currency;
    private float funds = 35;

    public void popLists(decode sport){
        // Use get methods to set variables
        homeTeams = sport.getHomeTeams();
        awayTeams = sport.getAwayTeams();
        h2h = sport.getMoneylines();
        spread = sport.getSpreads();
        totals = sport.getTotals();
        numGames = homeTeams.size();
        numPages = (int) Math.ceil(numGames / 2);
    }

    public void displayGames(int curGame, JPanel game, JLabel t1, JLabel t2, JButton t1m, JButton t2m, JButton t1s, JButton t2s, JButton under, JButton over, socketUtils test){
        game = new RoundedPanel(30, Color.decode("#C2CBD1"), Color.decode("#C2CBD1"));

        t1 = new customJLabel(NovaReg);
        t2 = new customJLabel(NovaReg);

        // Moneyline
        t1m = new customJButton(NovaReg);
        t1m.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                oddStr = h2h.get(homeTeams.get(curGame)).toString();
                odd = Float.parseFloat(oddStr);

                addBet(oddStr, "", homeTeams.get(curGame), placeBets, test, currency);

            }
        });
        t2m = new customJButton(NovaReg);
        t2m.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                oddStr = h2h.get(awayTeams.get(curGame)).toString();
                odd = Float.parseFloat(oddStr);

                addBet(oddStr, "", awayTeams.get(curGame), placeBets, test, currency);

            }
        });

        // Spread
        t1s = new customJButton(NovaReg);
        t1s.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                oddStr = spread.get(homeTeams.get(curGame))[0].toString();
                odd = Float.parseFloat(oddStr);

                pointStr = spread.get(homeTeams.get(curGame))[1].toString();
                point = Float.parseFloat(pointStr);

                addBet(oddStr, pointStr, homeTeams.get(curGame), placeBets, test, currency);

            }
        });
        t2s = new customJButton(NovaReg);
        t2s.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                oddStr = spread.get(awayTeams.get(curGame))[0].toString();
                odd = Float.parseFloat(oddStr);

                pointStr = spread.get(awayTeams.get(curGame))[1].toString();
                point = Float.parseFloat(pointStr);

                addBet(oddStr, pointStr, awayTeams.get(curGame), placeBets, test, currency);
            }
        });

        // Under/Over
        over = new customJButton(NovaReg);
        over.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                oddStr = totals.get("Over" + homeTeams.get(curGame))[0].toString();
                odd = Float.parseFloat(oddStr);

                pointStr = totals.get("Over" + homeTeams.get(curGame))[1].toString();
                point = Float.parseFloat(pointStr);

                addBet(oddStr, "Over " + pointStr, homeTeams.get(curGame), placeBets, test, currency);

            }
        });
        under = new customJButton(NovaReg);
        under.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                oddStr = totals.get("Under" + homeTeams.get(curGame))[0].toString();
                odd = Float.parseFloat(oddStr);

                pointStr = totals.get("Under" + homeTeams.get(curGame))[1].toString();
                point = Float.parseFloat(pointStr);

                addBet(oddStr, "Under " + pointStr, homeTeams.get(curGame), placeBets, test, currency);

            }
        });

        game.setBackground(Color.decode("#AFBBC2"));
        game.setLayout(new GridLayout(0, 4));
        game.setMaximumSize(new Dimension(530, 200));
        game.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add the game panels
        games.add(game);
        games.add(Box.createRigidArea(new Dimension(0, 10)));

        // Write team names
        t1.setText("<html>" + "<center>" + homeTeams.get(curGame) + "</center>" + "</html>");
        t1.setHorizontalAlignment(JLabel.CENTER);

        t2.setText("<html>" + "<center>" + awayTeams.get(curGame) + "</center>" + "</html>");
        t2.setHorizontalAlignment(JLabel.CENTER);

        // Check if bets are locked.
        if(h2h.get(homeTeams.get(curGame)) == null){
            t1m.setText("Locked");
            t2m.setText("Locked");

            t1m.setEnabled(false);
            t2m.setEnabled(false);
        }
        else{
            t1m.setText(h2h.get(homeTeams.get(curGame)).toString());
            t2m.setText(h2h.get(awayTeams.get(curGame)).toString());

            t1m.setEnabled(true);
            t2m.setEnabled(true);
        }

        // Check if bets are locked.
        if(spread.get(homeTeams.get(curGame)) == null){
            t1s.setText("Locked");
            t1s.setEnabled(false);

            t2s.setText("Locked");
            t2s.setEnabled(false);
        }
        else{
            t1s.setText(spread.get(homeTeams.get(curGame))[1].toString() + " " + spread.get(homeTeams.get(curGame))[0].toString());
            t2s.setText(spread.get(awayTeams.get(curGame))[1].toString() + " " + spread.get(awayTeams.get(curGame))[0].toString());

            t1s.setEnabled(true);
            t2s.setEnabled(true);
        }

        // Check if bets are locked.
        if(totals.get("Over" + homeTeams.get(curGame)) == null){
            over.setText("Locked");
            over.setEnabled(false);

            under.setText("Locked");
            under.setEnabled(false);
        }
        else{
            over.setText("O " + totals.get("Over" + homeTeams.get(curGame))[1].toString() + " " + totals.get("Over" + homeTeams.get(curGame))[0].toString());
            under.setText("U " + totals.get("Under" + homeTeams.get(curGame))[1].toString() + " " + totals.get("Under" + homeTeams.get(curGame))[0].toString());

            over.setEnabled(true);
            under.setEnabled(true);
        }

        game.add(t1);
        game.add(t1m);
        game.add(t1s);
        game.add(over);

        game.add(t2);
        game.add(t2m);
        game.add(t2s);
        game.add(under);

        game.revalidate();
        game.repaint();
    }

    // Add bets to placeBets panel
    public void addBet(String odds, String point, String team, JPanel panel, socketUtils sc, JTextField currency){
        String msg = team + "/" + odds + "/" + point;


        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel bet = new JLabel("<html>" + "<center>" + "  " + team + " " + odds + " " + point + "</center>" + "</html>", SwingConstants.CENTER);
        bet.setFont(NovaReg);
        bet.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bet);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JTextField amount = new JTextField();
        amount.setEditable(true);
        amount.setMaximumSize(new Dimension(100, 20));
        amount.setHorizontalAlignment(JTextField.CENTER);
        panel.add(amount);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton send = new JButton("Place Bet");
        send.setAlignmentX(Component.CENTER_ALIGNMENT);
        send.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                float subtract = Float.parseFloat(amount.getText());
                float temp1 = funds - subtract;
                if (temp1 < 0)
                {
                    JOptionPane.showMessageDialog(null, 
			                   "ERROR!  Insufficient Funds!",
			                   "Invalid Entry",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
                }

                currency.setText("$" + String.valueOf(temp1));

                String temp = amount.getText();
                addCurrentBets(msg, temp,  currentBets);
                sc.sendMessage(msg + "/$" +  temp);
                
            }
        });
        send.setFont(NovaReg);
        panel.add(send);

        panel.revalidate();
        panel.repaint();
    }

    public void addCurrentBets(String message, String money, JPanel panel)
    {
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel currBet = new JLabel("<html>" + "<center>" + "  " + message +  " " + "$" + money + "<html>" + "<center>");
        currBet.setFont(NovaReg);
        currBet.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(currBet);

        panel.revalidate();
        panel.repaint();
    }

    public fanduel(){
        // Frame title display current time
		//
        socketUtils su = new socketUtils();
        boolean connected = su.socketConnect();
        if(connected){
            su.sendMessage("User connected.");
        }

		Date  date = new Date();
		String str = String.format("%tc", date);
			   
       	   
		String titleString = "--- Fanduel --- " + str; 				    
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

        // Dashboard Panel and Border
        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);
        TitledBorder title = new TitledBorder(new LineBorder(dashboard.getBackground(), 1), "           DASHBOARD");
        title.setTitleFont(Shentox);
        dashboard.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
        setContentPane(dashboard);


        // Logo
        BufferedImage logojpg = null;
        try {
            logojpg = ImageIO.read(new File("src/resources/FanDuel-shield-logo.png"));
            Image conv = logojpg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            JLabel logo = new JLabel(new ImageIcon(conv));
            logo.setBounds(20,5,50,50);
            dashboard.add(logo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        /*
        Games Module
        */
        games = new RoundedPanel(30, Color.decode("#AFBBC2"), Color.decode("#AFBBC2"));
        games.setLayout(new BoxLayout(games, BoxLayout.PAGE_AXIS));
        games.setBounds(180, 100, 550, 430);
        games.setBorder(new EmptyBorder(0,0,0,0));
        dashboard.add(games);

        // Displaying the games
        gameLabels = new JPanel();
        gameLabels.setBackground(Color.decode("#AFBBC2"));
        gameLabels.setLayout(new GridLayout(0, 4));
        gameLabels.setMaximumSize(new Dimension(500, 30));
        JLabel teamLabel = new JLabel("Team");
        teamLabel.setHorizontalAlignment(JLabel.CENTER);
        teamLabel.setFont(NovaReg);
        gameLabels.add(teamLabel);
        JLabel h2hLabel = new JLabel("Head to Head");
        h2hLabel.setHorizontalAlignment(JLabel.CENTER);
        h2hLabel.setFont(NovaReg);
        gameLabels.add(h2hLabel);
        JLabel spreadLabel = new JLabel("Spreads");
        spreadLabel.setHorizontalAlignment(JLabel.CENTER);
        spreadLabel.setFont(NovaReg);
        gameLabels.add(spreadLabel);
        JLabel totalLabel = new JLabel("Totals");
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        totalLabel.setFont(NovaReg);
        gameLabels.add(totalLabel);

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
        refreshTitleBar();
        // Basketball Button
        JButton bballBtn = new JButton("NBA");
        bballBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                games.removeAll();
                gameNum = 0;

                // Parse JSON from API call
                try {
                    basketball = new decode("https://api.the-odds-api.com/v4/sports/basketball_nba/odds/?apiKey=5081c089e598260629a5e8f81e9eccca&regions=us&markets=h2h,spreads,totals&oddsFormat=american");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                games.add(gameLabels);
                popLists(basketball);
                displayGames(gameNum, game1, g1t1, g1t2, g1t1m, g1t2m, g1t1s, g1t2s, g1under, g1over, su);
                displayGames(gameNum+1, game2, g2t1, g2t2, g2t1m, g2t2m, g2t1s, g2t2s, g2under, g2over, su); 

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
                games.removeAll();
                gameNum = 0;

                // Parse JSON from API call
                try {
                    hockey = new decode("https://api.the-odds-api.com/v4/sports/icehockey_nhl/odds/?apiKey=8d59a6f9e5550fd863e2f492f17d5dab&regions=us&markets=h2h,spreads,totals&oddsFormat=american");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                games.add(gameLabels);
                popLists(hockey);
                displayGames(gameNum, game1, g1t1, g1t2, g1t1m, g1t2m, g1t1s, g1t2s, g1under, g1over, su);
                displayGames(gameNum+1, game2, g2t1, g2t2, g2t1m, g2t2m, g2t1s, g2t2s, g2under, g2over, su);

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
        JButton baseballBtn = new JButton("MLB");
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
        currentBets = new RoundedPanel(30, Color.decode("#1493FF"), Color.decode("#1493FF"));
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

                gameNum = gameNum - 1;

                games.removeAll();
                games.revalidate();
                games.repaint();

                displayGames(gameNum, game1, g1t1, g1t2, g1t1m, g1t2m, g1t1s, g1t2s, g1under, g1over, su);
                displayGames(gameNum + 1, game1, g1t1, g1t2, g1t1m, g1t2m, g1t1s, g1t2s, g1under, g1over, su);

            }
        });
        back.setFont(new Font("Helvetica", Font.BOLD, 30));
        back.setBounds(180, 535, 275, 40);
        dashboard.add(back);


        JButton forward = new JButton(">");
        forward.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                gameNum = gameNum + 1;

                games.removeAll();
                games.revalidate();
                games.repaint();

                displayGames(gameNum, game1, g1t1, g1t2, g1t1m, g1t2m, g1t1s, g1t2s, g1under, g1over, su);
                displayGames(gameNum + 1, game1, g1t1, g1t2, g1t1m, g1t2m, g1t1s, g1t2s, g1under, g1over, su);

            }
        });
        forward.setFont(new Font("Helvetica", Font.BOLD, 30));
        forward.setBounds(455, 535, 275, 40);
        dashboard.add(forward);

        // Place Bets Label
        JLabel placeBetsLabel = new JLabel("Place Bets: ");
        placeBetsLabel.setFont(NovaBold);
        placeBetsLabel.setBounds(740, 50, 100, 50);
        dashboard.add(placeBetsLabel);

        // Place Bets Panel
        placeBets = new RoundedPanel(30, Color.decode("#1493FF"), Color.decode("#1493FF"));
        placeBets.setLayout(new BoxLayout(placeBets, BoxLayout.PAGE_AXIS));
        placeBets.setBounds(740, 100, 185, 200);
        placeBets.setAlignmentX(Component.CENTER_ALIGNMENT);
        dashboard.add(placeBets);

        JLabel walletLabel = new JLabel("My Wallet:");
        walletLabel.setFont(NovaBold);
        walletLabel.setBounds(740, 300, 100, 50);
        dashboard.add(walletLabel);

        wallet = new RoundedPanel(30, Color.decode("#1493FF"), Color.decode("#1493FF"));
        wallet.setLayout(new BoxLayout(wallet, BoxLayout.PAGE_AXIS));
        wallet.setBounds(740, 350, 185, 150);
        wallet.setAlignmentX(Component.CENTER_ALIGNMENT);
        dashboard.add(wallet);

        currency = new JTextField("$" + funds);
        currency.setEditable(false);
        currency.setMaximumSize(new Dimension(100, 30));
        currency.setAlignmentX(Component.CENTER_ALIGNMENT);
        wallet.add(currency);

        JButton addCurrency5 = new JButton("Add $5");
        addCurrency5.setFont(new Font("Helvetica", Font.BOLD, 16));
        addCurrency5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                funds = funds + 5;
                currency.setText("$" + String.valueOf(funds));
            }
        }
        );
        addCurrency5.setMaximumSize(new Dimension(150,30));
        addCurrency5.setAlignmentX(Component.CENTER_ALIGNMENT);
        wallet.add(addCurrency5);

        JButton addCurrency25 = new JButton("Add $25");
        addCurrency25.setFont(new Font("Helvetica", Font.BOLD, 16));
        addCurrency25.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                funds = funds + 25;
                currency.setText("$" + String.valueOf(funds));
            }
        }
        );
        addCurrency25.setMaximumSize(new Dimension(150,30));
        addCurrency25.setAlignmentX(Component.CENTER_ALIGNMENT);
        wallet.add(addCurrency25);

        JButton addCurrency50 = new JButton("Add $50");
        addCurrency50.setFont(new Font("Helvetica", Font.BOLD, 16));
        addCurrency50.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                funds = funds + 50;
                currency.setText("$" + String.valueOf(funds));
            }
        }
        );
        addCurrency50.setMaximumSize(new Dimension(150,30));
        addCurrency50.setAlignmentX(Component.CENTER_ALIGNMENT);
        wallet.add(addCurrency50);

        JButton cashOut = new JButton("Cash Out");
        cashOut.setFont(new Font("Helvetica", Font.BOLD, 16));
        cashOut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                funds = 0;
                currency.setText("$" + String.valueOf(funds));
                JOptionPane.showMessageDialog(null, 
			                   "Money sent to your bank account!",
			                   "Please give 3-5 days for processing!",
			                   JOptionPane.WARNING_MESSAGE);
					
					return;
            }
        }
        );
        cashOut.setMaximumSize(new Dimension(150,30));
        cashOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        wallet.add(cashOut);

        //
		// EXIT Button
		//
		JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Helvetica", Font.BOLD, 16));
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{			
				    dispose();
			}
			
		});
		exit.setBounds(800, 535, 133, 34);
		dashboard.add(exit);
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