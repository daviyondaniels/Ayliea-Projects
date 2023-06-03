
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	
	public static void main(String[] args) {
		
           //Creates the frame
		   JFrame frame = new JFrame("Battleship");
		   frame.setSize(500, 500);
		   frame.setLocation(300,200);
		  
		   //Creates a menu bar 
		   JMenuBar menuBar = new JMenuBar();
		   JMenu file = new JMenu("File");
		   JMenu help = new JMenu("Help");
		   menuBar.add(file);
		   menuBar.add(help);
		   
		   //Creates restart button
		   JMenuItem restart = new JMenuItem("Restart");
		   file.add(restart);
		   
		   // Creates an exit button 
		   JMenuItem exit = new JMenuItem("Exit");
		   exit.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent event) {
				   System.exit(0);
			   }
		   });
		   file.add(exit);
		   
		   //Creates and populates the "Help' menu option
		   JMenuItem cantHelp = new JMenuItem("\"O\" indicates a miss. " + //FIXME: temporarily in place of the help menu.
		   		                              "\"X\" indicates a hit."); 
		   help.add(cantHelp);
		   
		   
		   //Adds a play button 
		   final JTextArea textArea = new JTextArea(100, 40);
		   frame.getContentPane().add(BorderLayout.CENTER, textArea);
		   final JButton button = new JButton("Play");
		   frame.getContentPane().add(BorderLayout.SOUTH, button);
		   button.addActionListener(new ActionListener() {

		       @Override
		       public void actionPerformed(ActionEvent e) {
		           textArea.append("\t \tWelcome to Battleship!");


		       }
		   });
		   
		   frame.getContentPane().add(BorderLayout.NORTH, menuBar);
		   frame.setVisible(true);
	}

}



