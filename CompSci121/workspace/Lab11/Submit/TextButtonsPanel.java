
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Displays a grid of JButtons and a JTextArea. Together,
 * they act as a very small keyboard and text display.
 * This class manages layout of controls and also handles events.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class TextButtonsPanel extends JPanel implements ActionListener {
	private JButton[] buttons;	//Do not change
	private JTextArea textArea;	//Do not change
	//Assign values for these constants in the constructor
	private final int ENTER = 9;	//Index of Enter button in buttons
	private final int SPACE = 10;	//Index of Space button in buttons
	private final int CLEAR = 11;	//Index of Clear button in buttons

	/**
	 * Constructor
	 */
	public TextButtonsPanel() {
		//TODO: Create and populate the buttons array
		String[] names = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "Enter", "Space", "Clear"};
		buttons = new JButton[12];
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);
		}
		//TODO: Register this as the listener for all buttons
		//TODO: Create the text area - set its editable property to false
		textArea = new JTextArea();
		textArea.setEditable(false);

		//TODO: Create a sub-panel with a 4 row, 3 column GridLayout
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,3));
		for(int i=0; i < buttons.length; i++){
			panel.add(buttons[i]);
		}
		//TODO: Populate the grid with buttons
		//TODO: Add the grid panel to this panel
		this.add(panel);

		//TODO: Create a JScrollPane containing textArea
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(80, 120));
		this.add(scrollPane);
		
		//TODO: Set the preferred size of the scroll pane to at least 80x120
		//TODO: Add the scroll pane to this panel
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO update the contents of textArea according to which
		//  button generated the ActionEvent.
		JButton clicked = (JButton)e.getSource();
		if(clicked == buttons[9]){
			textArea.append("\n");
		}
		else if(clicked == buttons[10]){
			textArea.append(" ");
		}
		else if(clicked == buttons[11]){
			textArea.setText("");
		}
		else{textArea.append(clicked.getText());
		}
	}
}