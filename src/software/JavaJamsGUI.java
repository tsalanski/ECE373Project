package software;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


import people.*;
import hardware.*;

public class JavaJamsGUI extends JFrame {
	// Class objects:
	Listener user0 = new Listener();				// Create new Listener
	Musician user1 = new Musician();				// Create new Musician
	Account account1 = new Account();				// create new Account
	Verification verify = new Verification();
	CreditCard cc1 = new CreditCard();
	MusicVenue mvenue = new MusicVenue();			// create MusicVenue object
	ConcertTicket ticket = new ConcertTicket();		// create ConcertTicket object
	ConcertTicket newReserved = new ConcertTicket();		// create Concert object for reserved ticket
	ConcertTicket newPurchased = new ConcertTicket();	
	
	private JMenuBar menuBar;
	private JPanel panel;
	
	private JMenu file;
	private JMenu print;
	
	// File submenus
    
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem exit;
	//private JMenuItem register;
	
	// Print submenus
	
	private JMenuItem venue;
	
	//Login and Register
	private JButton login;
	private JButton register;
	
	//Music Venue
	private JButton musicVenue;
	
	//Seats
	
	private JButton seat;
	/*for (int i=0 ; i<16 ; i++){
	    JButton btn = new JButton(String.valueOf(i));
	    btn.setPreferredSize(new Dimension(40, 40));
	    panel.add(btn);
	}*/
	
	private int ticketNum = 0; //Use for debugging
	
	public JLabel welcome = new JLabel("<HTML><center>Welcome to JavaJams!" +
			"<BR><BR>Register an account or log in" +
			"<BR> from an existing one.</center></HTML>"); //welcome text
	
	//~~~~~~~~~~~~Main Window~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public JavaJamsGUI(String windowTitle) {
		super(windowTitle);
		
		// Initialize for testing purposes:
		account1.setUsername("admin");
		account1.setPassword("12345");
		account1.setEmail("admin@email.com");
		User userL = new Listener();
		userL.setAccount(account1);
		verify.setNewAccount(account1);
		
		ConcertTicket ticket1 = new ConcertTicket();
		ticket1.setPrice(175.00);
		ticket1.setSeat(52);
		ticket1.setConcertName("Concert No. 1");
		ticket1.setAvailableSeat(100);
		ticket1.setDate(8);
		ticket1.setLocation("Tucson");
		mvenue.setConcerts(ticket1);
		
		ConcertTicket ticket2 = new ConcertTicket();
		ticket2.setPrice(105.00);
		ticket2.setSeat(11);
		ticket2.setConcertName("Concert No. 2");
		ticket2.setAvailableSeat(50);
		ticket2.setDate(15);
		ticket2.setLocation("Phoenix");
		mvenue.setConcerts(ticket2);
		
		CreditCard cc0 = new CreditCard("admin", "123 New St.", "123456789", "987654321");
		userL.getAccount().addCreditCard(cc0);
		verify.setNewCreditCard(cc0);
		
		setSize(440, 400); //Size of GUI window
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		/*add(new JLabel("<HTML><center>Welcome to JavaJams!" +
				"<BR>Register an account or log in from an existing one.</center></HTML>"));*/
		
		add(welcome);
		welcome.setFont(new Font("Serif", Font.PLAIN, 36)); //make welcome text bigger
		
		//fitToWindow(); //Whenever window is resized, fits text to window size
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits GUI when 'X' is clicked
		
		buildGUI();
		add(panel);
		setVisible(true);
	}
	
	public void buildGUI() {
		menuBar = new JMenuBar();
     	panel = new JPanel();
		
		file = new JMenu("File");
		print = new JMenu("Print");
		seat = new JButton("Seat");
		
		// Login and Registration
		login = new JButton("Login");
		register = new JButton("Register");
		
		// Music Venue
		musicVenue = new JButton("Music Venue");
		
		//register = new JMenuItem("Register");
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		exit = new JMenuItem("Exit");
		
		venue = new JMenuItem("Venue");
		
		//register.addActionListener(new MenuListener());
		save.addActionListener(new MenuListener());
		load.addActionListener(new MenuListener());
		exit.addActionListener(new MenuListener());
		
		venue.addActionListener(new MenuListener());
		
		//seat.addActionListener(new MenuListener());
		login.addActionListener(new loginButtonListener());
		register.addActionListener(new registerButtonListener());
		musicVenue.addActionListener(new musicVenueButtonListener());
		
		
		file.add(register);
		file.add(save);
		file.add(load);
		file.add(exit);
		
		print.add(venue);
		
		menuBar.add(file);
	    menuBar.add(print);
	    
	    //panel.setLayout(new GridBagLayout());
	    //GridBagConstraints c = new GridBagConstraints();
	    
	    panel.add(login);
	    panel.add(register);
	    panel.add(musicVenue);
	    
	    //Change sizes of buttons
	    login.setPreferredSize(new Dimension(200, 50));
	    register.setPreferredSize(new Dimension(200, 50));
	    musicVenue.setPreferredSize(new Dimension(200, 50));
	    
	    //Change size of font for text in buttons
	    login.setFont(new Font("Arial", Font.PLAIN, 20));
	    register.setFont(new Font("Arial", Font.PLAIN, 20));
	    musicVenue.setFont(new Font("Arial", Font.PLAIN, 20));
	    
	    //Center buttons
	    
	    
	    setJMenuBar(menuBar);
	    musicVenue.setVisible(false);
	}
	
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			//int m = 0;// used for error loops --- actually don't do this, use a JButton; else infinite loop
			
			if(source.equals(save)) {
				System.out.println("Data Saved!");
			}
			else if(source.equals(load)) {
				System.out.println("Load button pressed");
			}
			else if(source.equals(exit)) {
				System.exit(0);
			}
			/*else if(source.equals(register)) {
				handleRegister();
			}*/
			else if(source.equals(venue)) {
				handlePrintTicket();
			}
			//else if(source.equals())
		}
		
		private void handlePrintTicket() {
			if(ticketNum < 3) {
				System.out.println("Printing ticket...");
				System.out.println(ticketNum);
				ticketNum++;
			}
			else {
				JOptionPane.showMessageDialog(null, 
						"Too many tickets", 
						"Error", 
						JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
	//~~~~~~~~~~~~Main Window~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~ Login  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private class loginButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
    	  
    	  //JOptionPane.showMessageDialog(null, "Login!");
         JTextField username = new JTextField();
         JTextField password = new JPasswordField();
         Object[] message = {
             "Username:", username,
             "Password:", password
         };

         int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
         if (option == JOptionPane.OK_OPTION) {
        	 String token1 = username.getText();
        	 String token2 = password.getText();
        	 if (verify.verifyUser(user1, token1, token2) == true) {
        		 JOptionPane.showMessageDialog(null, "Login successful.", null, JOptionPane.ERROR_MESSAGE);
            	 // user logged in...  goto music venue
        		 login.setVisible(false);
        		 register.setVisible(false);
        		 musicVenue.setVisible(true);
             } else {
            	 JOptionPane.showMessageDialog(null, "Login Failed.", "Invalid username or password.", JOptionPane.ERROR_MESSAGE);
             }
         } else {
        	 JOptionPane.showMessageDialog(null, "Login Canceled.", null, JOptionPane.ERROR_MESSAGE);
         }

      }
	}
	//~~~~~~~~~~~~~ Login  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	
	//~~~~~~~~~~~~~ Registration  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private class registerButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "Register!");
		
    	//For listener and musician buttons
    	/*
    	JRadioButton userType1 = new JRadioButton("Listener", true);
    	JRadioButton userType2 = new JRadioButton("Musician", true);
    	ButtonGroup group = new ButtonGroup();
    	group.add(userType1);
    	group.add(userType2);
    	
    	JButton ok = new JButton("ok");
    	
    	JFrame frameUserType = new JFrame();
		//JButton l = new JButton("Listener");
		//JButton m = new JButton("Musician");
		frameUserType.add(userType1);
		frameUserType.add(userType2);
		//frameUserType.add(ok);
		frameUserType.setVisible(false);
		*/
    	  
		String regName;
		String password1 = "a";
		String password2 = "b";
		int tempAccType = 1;
		
		regName = JOptionPane.showInputDialog(null, "Enter a username pls: ", "Enter Name", JOptionPane.QUESTION_MESSAGE);
				
		if(regName != null) {	
			if(regName.trim().equals("")) {
				JOptionPane.showMessageDialog(null, 
											"Username not valid.", 
											"Please enter a valid username.", 
											JOptionPane.ERROR_MESSAGE);
			}
			else {
				//m++; //Exit out of error loop --- yo this doesn't work exactly
				//Welcome to JavaJams
				account1.setUsername(regName);
				JOptionPane.showMessageDialog(null, "Username Accepted");
			}
		}
		
		//Checks if passwords match
		while (!Objects.equals(password1, password2)) {
			password1 = JOptionPane.showInputDialog(null, "Enter a password: ", "Enter Password", JOptionPane.QUESTION_MESSAGE);
			password2 = regName = JOptionPane.showInputDialog(null, "Re-enter your password: ", "Re-Enter Password", JOptionPane.QUESTION_MESSAGE);
			if (!Objects.equals(password1, password2)) {
				JOptionPane.showMessageDialog(null, 
						"Passwords don't match, try again", 
						"Error", 
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				account1.setPassword(password2);
				JOptionPane.showMessageDialog(null, "Password Accepted\nWelcome to JavaJams!");
				
				//Checks if Musician or Listener
				String [] values = {"Musician", "Listener"};
				Object userType = JOptionPane.showInputDialog(null, "Are you a musician or a listener?", "User Type", JOptionPane.DEFAULT_OPTION, null, values, "Listener");
				if (userType != null) {
					//System.out.println("Ay");
					//System.out.println(userType.toString());
					if (Objects.equals(userType, "Listener")) {
						tempAccType = 1;
						//System.out.println("Listener");
					}
					else {
						tempAccType = 2;
						//System.out.println("Musician");
					}
				}
				else {
					//System.out.println("no");
				}
				
				//frameUserType.setVisible(true);
				//frameUserType.setBounds(1,1,100,100);
				//String userType = JOptionPane.showInputDialog(frameUserType, "Are you a Musician or a Listener?", null);
			}
		}
		
		// save new user info
		int accountNo = 0001;	// Generate new Account No.
		if(tempAccType == 1) { // Registered as Listener
			account1.setAccountType(1);
			user0.setAccountNo(accountNo);
			user0.setAccount(account1);
			verify.setNewAccount(account1);

		}else if(tempAccType == 2) { // Registered as Musician
			account1.setAccountType(2);
			user1.setAccountNo(accountNo);
			user1.setAccount(account1);
			verify.setNewAccount(account1);
		}
      }
	}
	//~~~~~~~~~~~~~ Registration  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	
	//~~~~~~~~~~~~~ MUSIC VENUE WINDOW ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private class musicVenueButtonListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	         int option = JOptionPane.showConfirmDialog(null, "Welcome to Music Venue", "Music Venue", JOptionPane.OK_CANCEL_OPTION);
		     if (option == JOptionPane.OK_OPTION) {
		    	 //System.out.println("Clicked music venue button");
		    	 new MusicVenueWindow(); 
		     } else {
		    	 //System.exit(0);
		     }
	      }
	}

	public class MusicVenueWindow extends JFrame{

		//accountInfo.add(showAccountInfo);
		public MusicVenueWindow() {
			buildMusicVenueWindow();
		}
	}
	
	public void buildMusicVenueWindow() {
		JFrame f = new JFrame("Music Venue");
		
		//JMenuBar musicBar = new JMenuBar();
		JPanel musicPanel = new JPanel();
		
		// Buttons
		JButton accountInfo = new JButton("Account Info");
		JButton concertInfo = new JButton("Concert Info");
		//JButton exitButton = new JButton("Exit");
		
		accountInfo.addActionListener(new AccountButtonListener());
		concertInfo.addActionListener(new ConcertButtonListener());
		//exitButton.addActionListener(new ExitButtonListener());
		
		/*
		// Menu options
		JMenu accountInfo = new JMenu("Account Info");
		JMenu concertInfo = new JMenu("Concert Info");

		// Account submenu
		JMenuItem showAccountInfo = new JMenuItem("Show Account Info");
		
		// Concert submenu
		JMenuItem showConcertTicket = new JMenuItem("Show Concert Ticket");
		
		//showAccountInfo.addActionListener(new MusicVenueListener());
		//showConcertTicket.addActionListener(new MusicVenueListener());
		
		accountInfo.add(showAccountInfo);
		concertInfo.add(showConcertTicket);
		
		musicBar.add(accountInfo);
		musicBar.add(concertInfo);
		
		setJMenuBar(musicBar);
		musicPanel.add(musicBar);
		*/
		musicPanel.add(accountInfo);
		musicPanel.add(concertInfo);
		//musicPanel.add(exitButton);
		f.add(musicPanel);

		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window instead of entire application
		f.setSize(150, 150);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(440, 400);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//musicBar.setVisible(true);
		musicPanel.setVisible(true);
		f.setVisible(true);
		
		Concerts();
		/*
		String newList = "";
		for(Concert c : mvenue.getConcert()) {
			newList += "Concert Name:  " + c.getConcertName() + "\n";
			newList += "Location:  " + c.getLocation() + "\n";
			newList += "Date:  " + c.getDate() + "\n";
			newList += "Available seats:  " + c.getAvailableSeat() + "\n";
			newList +=  "\n\n";
		}
		Object[] options = {"Buy Concert 1 Tix",
                			"Buy Concert 2 Tix",
                			"No eggs, no ham!"};
		
		JOptionPane.showOptionDialog(null, newList, "C O N C E R T S", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		*/
	}
	
	//Concert list and ability to purchase tickets
	private void Concerts() {
		user1.getAccount().displayAccountInfo(user1);
		String newList = "";
		for(Concert c : mvenue.getConcert()) {
			newList += "Concert Name:  " + c.getConcertName() + "\n";
			newList += "Location:  " + c.getLocation() + "\n";
			newList += "Date:  " + c.getDate() + "\n";
			newList += "Available seats:  " + c.getAvailableSeat() + "\n";
			newList +=  "\n\n";
		}
		
		Object[] options = {"Buy Concert 1 Tix",
                			"Buy Concert 2 Tix",
                			"Exit"};
		
		int n = JOptionPane.showOptionDialog(null, newList, "C O N C E R T S",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		
		newPurchased = mvenue.getConcert().get(n);
		if(newPurchased.checkAvailableSeats() == false) {
			//System.out.println("No seats available, please try again at a later time.\n");
		}
		
		if (n != 2) {
			 JTextField ccName = new JTextField();
			 JTextField	ccAddress = new JTextField();
			 JTextField	ccPhone = new JTextField();
	         JTextField ccNo = new JPasswordField();
	         Object[] message = {
	             "Name:", ccName,
	             "Address:", ccAddress,
	             "Phone:", ccPhone,
	             "Credit Card No.:", ccNo
	         };

	         int option = JOptionPane.showConfirmDialog(null, message, "Enter Credit Card Info", JOptionPane.OK_CANCEL_OPTION);
	         if (option == JOptionPane.OK_OPTION) {
	        	 String token1 = ccName.getText();
	        	 String token2 = ccAddress.getText();
	        	 String token3 = ccPhone.getText();
	        	 String token4 = ccNo.getText();
	        	 
	        	cc1.setFullname(token1);
				cc1.setAddress(token2);
				cc1.setPhoneNo(token3);
				cc1.setCardNo(token4);
				if(verify.verifyCard(cc1) == true) {
					newPurchased = mvenue.getConcert().get(n);
					JOptionPane.showMessageDialog(null, "Purchased successful.", null, JOptionPane.ERROR_MESSAGE);
					user1.getAccount().addPurchasedTicket(newPurchased);
					newPurchased.removeAvailableSeats();
	             } else {
	            	 JOptionPane.showMessageDialog(null, "Purchased Failed.", "Invalid Credit Card Information.", JOptionPane.ERROR_MESSAGE);
	             }
	         } else {
	        	 JOptionPane.showMessageDialog(null, null, null, JOptionPane.ERROR_MESSAGE);
	         }
		}
			
		System.out.println(n);
		user1.getAccount().displayAccountInfo(user1);
		
		
	}
	
	private class ConcertButtonListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  //JOptionPane.showMessageDialog(null, "Clicked Concerts", "C O N C E R T S", JOptionPane.DEFAULT_OPTION);
	    	  Concerts();
	      }
	}
	
	
	//Print ticket
	private class AccountButtonListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  //String tickets = user1.getAccount().getPurchasedTicketList().toString();
	    	  //String info = user1.getAccount().
	    	  Object[] info = {user1.getAccount().getUsername(), user1.getAccount().getEmail(),
	    			  			user1.getAccount().getCreditCardList().toString(), user1.getAccount().getReservedTicketList().toString(),
	    			  			user1.getAccount().getPurchasedTicketList().toString()};
	    	  
	    	  JOptionPane.showMessageDialog(null, info, "Account Info", JOptionPane.DEFAULT_OPTION);
	      }
	}
	
	/*
	private class ExitButtonListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  
	      }
	}*/
	
	/*
	private class MusicVenueListener implements ActionListener {
		public void actionPerformed(ActionEvent e2) {
			JMenuItem source2 = (JMenuItem)(e2.getSource());
			
			if(source2.equals(accountInfo)) {
				System.out.println("Data Saved!");
			}
			else if(source2.equals(concertInfo)) {
=======
	/*private class MusicVenueListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(showAccountInfo)) {
				System.out.println("Data Saved!");
			}
			else if(source.equals(showConcertTicker)) {
>>>>>>> 51d05fbb22717160347d370edcda8f09eb65ff32
				System.out.println("Load button pressed");
			}
		}
	}
	*/
	//~~~~~~~~~~~~~ MUSIC VENUE WINDOW ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// do something
		
	//Fits words to window. Could be expanded for any situation
	private void fitToWindow() {
		//Font f = welcome.getFont();
		String s = welcome.getText();
		
		//System.out.println(f.getSize());
		System.out.println(s);
		
		System.out.println(welcome.getWidth());
		System.out.println(welcome.getFontMetrics(welcome.getFont()).stringWidth(s));
		
		//double width = (double)welcome.getWidth() / (double)welcome.getFontMetrics(f).stringWidth(s);
		double width = (double)welcome.getWidth() / (double)welcome.getFontMetrics(welcome.getFont()).stringWidth(s);
		int height = welcome.getHeight();
		System.out.println(width);
		System.out.println(height);
		
		int newFontSize = (int)(welcome.getFont().getSize() * width);
		newFontSize = Math.min(newFontSize, height);
		
		welcome.setFont(new Font(welcome.getFont().getName(), Font.PLAIN, newFontSize));
	}
}