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
	
	private int ticketNum = 0; //Use for debugging
	
	public JavaJamsGUI(String windowTitle) {
		super(windowTitle);

		setSize(800, 600); //Size of GUI window
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>Welcome to the JavaJams!" +
				"<BR>Register an account or log in from an existing one.</center></HTML>"));
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
		
		register.addActionListener(new MenuListener());
		save.addActionListener(new MenuListener());
		load.addActionListener(new MenuListener());
		exit.addActionListener(new MenuListener());
		
		file.add(register);
		file.add(save);
		file.add(load);
		file.add(exit);
		
		menuBar.add(file);
	    menuBar.add(print);
	    
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
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
			else if(source.equals(print)) {
				handlePrintTicket();
			}
			//else if(source.equals())
		}
		
		private void handleRegister() {
			String regName;
			
			regName = JOptionPane.showInputDialog(null, "Enter a username pls: ", "Input Dept", JOptionPane.QUESTION_MESSAGE);
			
			if(regName != null) {
				if(regName.trim().equals("")) {
					JOptionPane.showMessageDialog(null, 
												"Username not valid.", 
												"Please enter a valid username.", 
												JOptionPane.PLAIN_MESSAGE);
				}
				else {
					System.out.println("Entered in a username");
					//Do something
				}
			}
		}
		
		private void handlePrintTicket() {
			if(ticketNum < 10) {
				System.out.println("Printing ticket...");
				System.out.println(ticketNum);
				ticketNum++;
			}
			else {
				JOptionPane.showMessageDialog(null, 
						"Not logged in", 
						"Error; too many tickets", 
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
