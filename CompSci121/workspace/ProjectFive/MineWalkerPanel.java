import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class MineWalkerPanel extends JPanel implements ActionListener,
		ChangeListener {
	private int x = 10;
	private int y = 10;
	private int counter = 0;
	int lives = 5;
	int score = 500;
	ArrayList<Point> henry = new ArrayList<Point>();
	private JButton[][] buttons = new JButton[x][y];
	private JLabel livesLabel = new JLabel("Lives:  " + lives);
	private JLabel scoreLabel = new JLabel("Score:  " + score);
	private JButton newGame = new JButton("New Game");
	private JButton mineState = new JButton("Show Mines");
	private JButton pathState = new JButton();
	private JSlider gridSize = new JSlider(JSlider.HORIZONTAL, 10, 40, 10);
	private JLabel mineNumber1 = new JLabel(" 0 nearby mines");
	private JLabel mineNumber2 = new JLabel(" 1  nearby mine");
	private JLabel mineNumber3 = new JLabel(" 2 nearby mines");
	private JLabel mineNumber4 = new JLabel(" 3 nearby mines");
	private JLabel mineNumber5 = new JLabel("Exploded  mines");
	JPanel sidePanel, gameBoard, bottomPanel, colorPanel, topPanel;
	private String path, gameState, mine;
	RandomWalk walk = new RandomWalk(10);
	boolean mines[][];
	private int delay = 500; // milliseconds
	Point currentPosition = new Point(x-1, y-1);
	/**
	 * Constructor
	 */
	/**
	 * This is the constructor.  It constructs all the panels and buttons.
	 */
	public MineWalkerPanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 600));

		gameBoard = new JPanel();
		this.setPreferredSize(new Dimension(400, 400));
		//gameBoard.setLayout(new GridLayout(x, y));
		

		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(600, 100));
		bottomPanel.setLayout(new FlowLayout());

		gameState = "New Game";
		newGame.setText(gameState);
		newGame.setActionCommand("gameState");
		newGame.addActionListener(this);

		mine = "Show Mines";
		mineState.setText(mine);
		mineState.setActionCommand("mineState");
		mineState.addActionListener(this);

		path = "Show Path";
		pathState.setText(path);
		pathState.setActionCommand("pathState");
		pathState.addActionListener(this);

		bottomPanel.add(newGame);
		bottomPanel.add(gridSize);
		bottomPanel.add(mineState);
		bottomPanel.add(pathState);
		bottomPanel.add(gridSize);

		gridSize.setBorder(BorderFactory.createTitledBorder("Grid Size"));
		gridSize.addChangeListener(this);
		gridSize.setMajorTickSpacing(10);
		gridSize.setMinorTickSpacing(5);
		gridSize.setPaintTicks(true);
		gridSize.setPaintLabels(true);

		sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(150, 600));
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

		livesLabel.setForeground(Color.blue);
		scoreLabel.setForeground(Color.blue);

		sidePanel.add(colorPanel);
		sidePanel.add(livesLabel);
		sidePanel.add(scoreLabel);

		newGame.doClick();
		
		this.add(gameBoard, BorderLayout.CENTER);
		this.add(sidePanel, BorderLayout.EAST);
		this.add(bottomPanel, BorderLayout.SOUTH);
		startAnimation();
	}

	/**
	 * This method cancels the game when the JButton is clicked
	 */
	public void cancelGame() {

		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				if (buttons[row][col].getText() != "") {
					buttons[row][col].setText("");
				}
			}
		}
	}

	/**
	 * This element brings up a new game and clears the game board for the user
	 */
	public void newGame() {
		x = gridSize.getValue();
		y = gridSize.getValue();
		buttons = new JButton[x][y];
		this.remove(gameBoard);
		System.out.println("X: " + x + "y " +y);
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(x, y));
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				buttons[row][col] = new JButton("");
				buttons[row][col].addActionListener(this);
				gameBoard.add(buttons[row][col]);
			}
		}
		this.add(gameBoard, BorderLayout.CENTER);
		walk = new RandomWalk(x);
		walk.createWalk();
		getMines();
		currentPosition = new Point(x-1, y-1);
		lives = 5;
		score = 500;
		scoreLabel.setText("Score:  " + score);
		livesLabel.setText("Lives  " + lives);
	}
	/**
	 * This method makes sure that there is a safe path through the game board
	 */
	public void getPath(){
		ArrayList<Point> getPath= walk.getPath();
		for(int row = 0; row < buttons.length; row++){
			for(int col = 0; col < buttons.length; col++){
				Point point = new Point(row, col);
			if(getPath.contains(point)){
				buttons[row][col].setText("o");
			}
			}
		}
		score = score - 250;
		scoreLabel.setText("Score  " + score);
	}
	/**
	 * This method lays the mines without putting them on the safe path
	 */
	public void getMines(){
		ArrayList<Point> getPath= walk.getPath();
		Random rand = new Random();
		mines = new boolean[x][y];
		int numberMines = (int)((x * y) * .25);
		while(numberMines != 0){
			int a = rand.nextInt(x);
			int b = rand.nextInt(y);
			Point point = new Point(a, b);
			if(!getPath.contains(point) && mines[a][b] == false){
				mines[a][b] = true;
				numberMines--;
				
			}
		}
	}
	/**
	 *This method turns the buttons with mines on them black when the show mines button is pushed 
	 */
	public void showMines(){
		for(int row = 0; row<mines.length; row++){
			for(int col = 0; col<mines[row].length; col++){
				if(mines[row][col] == true){
				buttons[row][col].setBackground(Color.black);
				}
		}
		}
		score = score - 50;
		scoreLabel.setText("Score  " + score);
	}
	/**
	 * This method turns the buttons with mines on them back to the original color when the button is clicked
	 */
	public void hideMines(){
		for(int row = 0; row<mines.length; row++){
			for(int col = 0; col<mines[row].length; col++){
				if(mines[row][col] == true  && !henry.contains(new Point(row, col))){
				buttons[row][col].setBackground(null);
			}
			}
		}
	}
	/**
	 * This method finds the mines
	 * @param next
	 * @return
	 */
	public int findMines(Point next){
		int mineCount = 0;
		if(next.y+1<y && mines[next.x][next.y+1]){
			mineCount++;
		}
		if(next.y-1>=0 && mines[next.x][next.y-1]){
			mineCount++;
		}
		if(next.x+1<x && mines[next.x+1][next.y]){
			mineCount++;
		}
		if(next.x-1>=0 && mines[next.x-1][next.y]){
			mineCount++;
		}
		return mineCount;
	}
	/**
	 * This one makes sure that the user makes a valid move and it sets the color indicating the mines around the button
	 * @param next
	 */
	private void validClick(Point next){
		henry.add(next);
		if (mines[next.x][next.y]){
			buttons[next.x][next.y].setBackground(Color.black);
			lives--;
			score = score - 100;
			scoreLabel.setText("Score:  " + score);
			livesLabel.setText("Lives:  " + lives);
			return;
	}
		int mineCount = findMines(next);
		if(mineCount == 0){
			buttons[next.x][next.y].setBackground(Color.green);
			buttons[currentPosition.x][currentPosition.y].setText("");
		}
		if(mineCount == 1){
			buttons[next.x][next.y].setBackground(Color.yellow);
			buttons[currentPosition.x][currentPosition.y].setText("");
		}
		if(mineCount == 2){
			buttons[next.x][next.y].setBackground(Color.orange);
			buttons[currentPosition.x][currentPosition.y].setText("");
		}
		if(mineCount == 3){
			buttons[next.x][next.y].setBackground(Color.red);
			buttons[currentPosition.x][currentPosition.y].setText("");
		}
		currentPosition = next;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		String action = e.getActionCommand();
		if (action.equals("gameState")) {
			if (clicked.getText().equals("Cancel Game")) {
				gameState = "New Game";
				clicked.setText(gameState);
				cancelGame();
			}else{
				newGame();
				mineState.setText("Show Mines");
				pathState.setText("Show Path");
			//if (clicked.getText().equals("")) {
				Point point1 = new Point(x-1, y-1);
				int mineCount = findMines(point1);
				if(mineCount == 1){
					buttons[x-1][y-1].setBackground(Color.yellow);	
				}else{buttons[x-1][y-1].setBackground(Color.green);}
			
			newGame.setText("Cancel Game");
		}
		}

		else if (action.equals("pathState")) {
			if (clicked.getText().equals("Show Path")) {
				path = "Hide Path";
				clicked.setText(path);
				getPath();
			} else if (clicked.getText().equals("Hide Path")) {
				path = "Show Path";
				clicked.setText(path);
				for (int row = 0; row < buttons.length; row++) {
					for (int col = 0; col < buttons[row].length; col++) {
						if (buttons[row][col].getText() != "") {
							buttons[row][col].setText("");
						}
					}
				}
			}
		}
		else if (action.equals("mineState")) {
			if (clicked.getText().equals("Show Mines")) {
				mine = "Hide Mines";
				clicked.setText(mine);
				showMines();
			} else if (clicked.getText().equals("Hide Mines")) {
				mine = "Show Mines";
				clicked.setText(mine);
				hideMines();
			}
		}
		else{
			Point next = null;
			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons[row].length; col++) {
					if (buttons[row][col] == clicked) {
						next = new Point(row, col);
						
						}
					}
				}
			
			//W
			if(next.getX() == currentPosition.getX() && next.getY() == currentPosition.getY()-1){
				validClick(next);
				score--;
				scoreLabel.setText("Score:  " + score);
			}
			if(next.getX() == currentPosition.getX() && next.getY() == currentPosition.getY()+1){
				validClick(next);
				score--;
				scoreLabel.setText("Score:  " + score);
			}
			if(next.getX() == currentPosition.getX()-1 && next.getY() == currentPosition.getY()){
				validClick(next);
				score--;
				scoreLabel.setText("Score:  " + score);
			}
			if(next.getX() == currentPosition.getX()+1 && next.getY() == currentPosition.getY()){
				validClick(next);
				score--;
				scoreLabel.setText("Score:  " + score);
					}
			}
		if((currentPosition.x == 0 && currentPosition.y == 0) || lives == 0){
			showMines();
			newGame.setText("New Game");
			if(currentPosition.x == 0 && currentPosition.y ==0){
				JOptionPane.showMessageDialog(null, "You made it!!!  YAY!!!");
				}
			}
		
			
		}
	

	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}
	
	//
	/**
	 * This method is on a timer that allows the button to flash that the user is currently on
	 */
	private void startAnimation()
	{
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(counter == 1){
					buttons[currentPosition.x][currentPosition.y].setText("X");
					counter = 0;
					System.out.println(counter);
				}else {
					buttons[currentPosition.x][currentPosition.y].setText("");
					counter = 1;
					System.out.println(counter);
				}
			}
		};
		
		new Timer(delay, taskPerformer).start();
	}
}