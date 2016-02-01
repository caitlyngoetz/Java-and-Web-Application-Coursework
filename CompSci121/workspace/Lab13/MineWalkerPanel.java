import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;



@SuppressWarnings("serial")
public class MineWalkerPanel extends JPanel implements ActionListener {
	private int x = 10;
	private int y = 10;
	private JButton[][] buttons = new JButton[x][y];
	private JLabel lives = new JLabel("Lives:  ");
	private JLabel score = new JLabel("Score:  ");
	private JButton newGame = new JButton("New Game");
	private JButton showMines = new JButton("Show Mines");
	private JButton showPath= new JButton("Show Path");
	private JSlider difficulty = new JSlider();
	private JTextArea gridSize = new JTextArea("");
	private JLabel mineNumber1 = new JLabel(" 0 nearby mines");
	private JLabel mineNumber2 = new JLabel(" 1  nearby mine");
	private JLabel mineNumber3 = new JLabel(" 2 nearby mines");
	private JLabel mineNumber4 = new JLabel(" 3 nearby mines");
	private JLabel mineNumber5 = new JLabel("Exploded  mines");
	JPanel sidePanel, gameBoard, bottomPanel, colorPanel, topPanel;
	

	/**
	 * Constructor
	 */
	public MineWalkerPanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600,600));
		
		gameBoard = new JPanel();
		this.setPreferredSize(new Dimension(400,400));
		gameBoard.setLayout(new GridLayout(x, y));
		//newGame.addActionListener(this);
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(600,100));
		bottomPanel.setLayout(new FlowLayout());
		
		bottomPanel.add(newGame);
		bottomPanel.add(difficulty);
		bottomPanel.add(showMines);
		bottomPanel.add(showPath);
		bottomPanel.add(gridSize);
	
		difficulty.setBorder(BorderFactory.createTitledBorder("Difficulty"));
		sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(150,600));
		sidePanel.setLayout(new FlowLayout());
		
		colorPanel = new JPanel();
		colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
		colorPanel.setBorder(BorderFactory.createTitledBorder("Color Key"));
		
		mineNumber1.setBorder(BorderFactory.createLineBorder(Color.green));
		mineNumber1.setForeground(Color.green);
		colorPanel.add(mineNumber1);
		
		mineNumber2.setBorder(BorderFactory.createLineBorder(Color.yellow));
		mineNumber2.setForeground(Color.yellow);
		colorPanel.add(mineNumber2);
		
		mineNumber3.setBorder(BorderFactory.createLineBorder(Color.orange));
		mineNumber3.setForeground(Color.orange);
		colorPanel.add(mineNumber3);
		
		mineNumber4.setBorder(BorderFactory.createLineBorder(Color.red));
		mineNumber4.setForeground(Color.red);
		colorPanel.add(mineNumber4);
		
		mineNumber5.setBorder(BorderFactory.createLineBorder(Color.black));
		colorPanel.add(mineNumber5);
		
		lives.setForeground(Color.blue);
		score.setForeground(Color.blue);
		
		sidePanel.add(colorPanel);
		sidePanel.add(lives);
		sidePanel.add(score);
		

		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				buttons[row][col] = new JButton("");
				buttons[row][col].addActionListener(this);
				buttons[row][col].setFont(new Font("Arial", 0, 50));
				gameBoard.add(buttons[row][col]);
			}
		}
this.add(gameBoard, BorderLayout.CENTER);
this.add(sidePanel, BorderLayout.EAST);
this.add(bottomPanel, BorderLayout.SOUTH);
		
	}
	
	public void newGame() {
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				if(buttons[row][col].getText() != ""){
				buttons[row][col].setText("");
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == newGame) {
			newGame();
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