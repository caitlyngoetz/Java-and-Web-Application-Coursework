import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * GUI contains a grid of buttons and a text area.
 * As buttons are pressed, corresponding text is
 * displayed in the text area.
 * 
 * @author mvail
 */
public class MineWalker {

	/**
	 * Create the JFrame 
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Mine Walker Game");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setPreferredSize(new Dimension(600, 600));
		Container theContentPane = theFrame.getContentPane();
		theContentPane.setLayout(new BorderLayout());
		theFrame.setPreferredSize(new Dimension(600, 600));
		//Create a TextButtonsPanel to display the buttons and textArea
		MineWalkerPanel mainPanel = new MineWalkerPanel();
		
		theFrame.add(mainPanel, BorderLayout.CENTER);
		theFrame.setVisible(true);
		theFrame.pack();
		theFrame.setLocationRelativeTo(null);
		
}
}