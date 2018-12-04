package software;

import java.util.ArrayList;
import java.util.Objects;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
	
	public JavaJamsGUI(String windowTitle) {
		super(windowTitle);
		
		// Initialize for testing purposes:
		account1.setUsername("admin");
		account1.setPassword("12345");
		account1.setEmail("admin@emai.com");
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
		
		login = new JButton("Login");
		register = new JButton("Register");
		
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
		
		
		file.add(register);
		file.add(save);
		file.add(load);
		file.add(exit);
		
		print.add(venue);
		
		menuBar.add(file);
	    menuBar.add(print);
	    
	    panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    panel.add(login);
	    panel.add(register);
	    
	    //Change sizes of buttons
	    login.setPreferredSize(new Dimension(200, 100));
	    register.setPreferredSize(new Dimension(200, 100));
	    
	    //Change size of font for text in buttons
	    login.setFont(new Font("Arial", Font.PLAIN, 40));
	    register.setFont(new Font("Arial", Font.PLAIN, 40));
	    
	    //Center buttons
	    
	    
	    setJMenuBar(menuBar);
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
	
	private class loginButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         JOptionPane.showMessageDialog(null, "Login!");
      }
	}
	
	private class registerButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "Register!");
		
		String regName;
		String password1 = "a";
		String password2 = "b";
		
		regName = JOptionPane.showInputDialog(null, "Enter a username pls: ", "Enter Name", JOptionPane.QUESTION_MESSAGE);
		
		
		
		if(regName != null) {	
			if(regName.trim().equals("")) {
				JOptionPane.showMessageDialog(null, 
											"Username not valid.", 
											"Please enter a valid username.", 
											JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("Entered in a username");
				//m++; //Exit out of error loop --- yo this doesn't work exactly
				//Welcome to JavaJams
				JOptionPane.showMessageDialog(null, "Username Accepted\nWelcome to JavaJams!");
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
				JOptionPane.showMessageDialog(null, "Password Accepted\nWelcome to JavaJams!");
			}
		}
      }
	}
	
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
