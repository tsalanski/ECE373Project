package software;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import people.*;
import hardware.*;

public class JavaJamsGUI extends JFrame {
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu print;
	
	// File submenus
    
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem exit;
	private JMenuItem register;
	
	
	// Print submenus
	
	private JMenuItem venue;
	
	private int ticketNum = 0; //Use for debugging
	
	public JLabel welcome = new JLabel("<HTML><center>Welcome to JavaJams!" +
			"<BR><BR>Register an account or log in from an existing one.</center></HTML>"); //welcome text
	
	public JavaJamsGUI(String windowTitle) {
		super(windowTitle);

		setSize(735, 600); //Size of GUI window
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		/*add(new JLabel("<HTML><center>Welcome to JavaJams!" +
				"<BR>Register an account or log in from an existing one.</center></HTML>"));*/
		
		add(welcome);
		welcome.setFont(new Font("Serif", Font.PLAIN, 36)); //make welcome text bigger
		
		//fitToWindow(); //Whenever window is resized, fits text to window size
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits GUI when 'X' is clicked
		buildGUI();	
		setVisible(true);
	}
	
	public void buildGUI() {
		menuBar = new JMenuBar();
     	
		file = new JMenu("File");
		print = new JMenu("Print");
		
		register = new JMenuItem("Register");
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		exit = new JMenuItem("Exit");
		
		venue = new JMenuItem("Venue");
		
		register.addActionListener(new MenuListener());
		save.addActionListener(new MenuListener());
		load.addActionListener(new MenuListener());
		exit.addActionListener(new MenuListener());
		
		venue.addActionListener(new MenuListener());
		
		file.add(register);
		file.add(save);
		file.add(load);
		file.add(exit);
		
		print.add(venue);
		
		menuBar.add(file);
	    menuBar.add(print);
	    
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			int m = 0;// used for error loops
			
			if(source.equals(save)) {
				System.out.println("Data Saved!");
			}
			else if(source.equals(load)) {
				System.out.println("Load button pressed");
			}
			else if(source.equals(exit)) {
				System.exit(0);
			}
			else if(source.equals(register)) {
				handleRegister();
			}
			else if(source.equals(venue)) {
				handlePrintTicket();
			}
			//else if(source.equals())
		}
		
		private void handleRegister() {
			String regName;
			
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
					//m++; //Exit out of error loop
					//Welcome to JavaJams
					JOptionPane.showMessageDialog(null, "Username Accepted\nWelcome to JavaJams!");
				}
			}
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
