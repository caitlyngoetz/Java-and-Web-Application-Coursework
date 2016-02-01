import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class UpDown implements ActionListener {
	private int theUpDownCounter=50;  		//The up/down counter
	private JLabel theLabel;  				//Label used for up/down counter
	private JButton upButton, downButton;   //The buttons
	private int zero=1;
	
	public static void main(String[] args) {
		UpDown e = new UpDown();  //Why?
	}
	
	UpDown() {
		//Builds and configures the JFrame
		JFrame theFrame = new JFrame("GUIButtonExample");  //The window frame
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Exit app when user closes
		theFrame.setPreferredSize(new Dimension(225,75));  //Size of window frame
		Container theContentPane = theFrame.getContentPane();  //Retrives content pane
		theContentPane.setLayout(new FlowLayout(FlowLayout.CENTER));  //why no JPanel?
		
		upButton = new JButton("UP");  //Build JButton object
		upButton.addActionListener(this);  //Have java call this object when user clicks button
		downButton = new JButton("DOWN");  //Build another button
		downButton.addActionListener(this);  //Have java call this object for this button too
		theLabel = new JLabel("50");  //Counter incremented by buttons
		
		theContentPane.add(upButton);  //Place all buttons in the content pane
		theContentPane.add(downButton);
		theContentPane.add(theLabel);
		
		//Display the window frame
		theFrame.pack();theFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == upButton) {   //Did user click the upButton?
			System.out.println("Up");
			theLabel.setText(Integer.toString(++theUpDownCounter));
		}
		if(e.getSource() == downButton) {  //Did user click the downButton?
			System.out.println("Down");
			theLabel.setText(Integer.toString(--theUpDownCounter));
		}
	}
}