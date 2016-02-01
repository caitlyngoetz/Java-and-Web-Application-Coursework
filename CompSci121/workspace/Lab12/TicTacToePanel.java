import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TicTacToePanel extends JPanel implements ActionListener {
	private JButton[][] buttons = new JButton[3][3];
	private JButton newGame = new JButton("New Game");
	private int computerWins = 0;
	private int playerWins = 0;

	/**
	 * Constructor
	 */
	public TicTacToePanel() {
		JFrame theFrame = new JFrame("TicTacToe");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setPreferredSize(new Dimension(225, 75));
		Container theContentPane = theFrame.getContentPane();
		theContentPane.setLayout(new BorderLayout());
		theFrame.setPreferredSize(new Dimension(400, 400));
		JPanel gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(3, 3));
		newGame.addActionListener(this);

		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				buttons[row][col] = new JButton("");
				buttons[row][col].addActionListener(this);
				setFont(new Font("Arial", 0, 50));
				gameBoard.add(buttons[row][col]);
			}
		}

		theFrame.add(gameBoard, BorderLayout.CENTER);
		theFrame.add(newGame, BorderLayout.WEST);
		theFrame.setVisible(true);
		theFrame.pack();
	}

	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == newGame) {
			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons[row].length; col++) {
					if(buttons[row][col].getText() != ""){
					buttons[row][col].setText("");
				}
				}
			}
		}
		if (clicked.getText().equals("")) {
			clicked.setText("X");

			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons[row].length; col++) {
					if (buttons[row][col].getText().equals("")) {
						buttons[row][col].setText("O");
						return;
					}
				}
			}
		}
	}
}

/*		if(buttons[0][0].equals("X") && buttons[0][1].equals("X") && buttons[0][2].equals("X")){
			playerWins++;
		}
		if(buttons[1][0].equals("X") && buttons[1][1].equals("X") && buttons[1][2].equals("X")){
			playerWins++;
		}
		if(buttons[2][0].equals("X") && buttons[2][1].equals("X") && buttons[2][2].equals("X")){
			playerWins++;
		}
		if(buttons[0][0].equals("O") && buttons[0][1].equals("O") && buttons[0][2].equals("O")){
			computerWins++;
		}
		if(buttons[1][0].equals("O") && buttons[1][1].equals("O") && buttons[1][2].equals("O")){
			computerWins++;
		}
		if(buttons[2][0].equals("O") && buttons[2][1].equals("O") && buttons[2][2].equals("O")){
			computerWins++;
		}
		if(buttons[0][0].equals("X") && buttons[1][0].equals("X") && buttons[1][2].equals("X")){
			playerWins++;
		}
		if(buttons[0][1].equals("X") && buttons[1][1].equals("X") && buttons[1][2].equals("X")){
			playerWins++;
		}
		if(buttons[0][0].equals("X") && buttons[1][0].equals("X") && buttons[1][2].equals("X")){
			playerWins++;
		}
	}
}*/
