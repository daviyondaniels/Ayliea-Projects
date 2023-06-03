
//Configures GUI and game functionality
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {

	// Player values
	String playerChar;
	String enemyChar;

	// Creates main frame for board game
	JFrame mainFrame = new JFrame("TicTacToe");
	JPanel bp = new JPanel(new GridLayout(3, 3));
	JPanel textP = new JPanel(new GridLayout());
	JButton[] buttonArray = new JButton[9];
	JLabel text = new JLabel();

	boolean playerTurn;

	// Creates character selection menu
	JFrame initFrame = new JFrame("Character Selection");
	JLabel initLabel = new JLabel("Choose a character...");
	JButton x = new JButton("X");
	JButton o = new JButton("O");

	// Creates end game menu
	JFrame endFrame = new JFrame("Game Over");
	JPanel endTextP = new JPanel(new GridLayout());
	JPanel endButtonP = new JPanel(new FlowLayout());
	JLabel endText = new JLabel();
	JButton playAgain = new JButton("Play Again");
	JButton exitB = new JButton("Exit");

	GUI() {

		// Sets default close operations
		initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Configures character selection menu
		initFrame.setLayout(new FlowLayout());
		initFrame.setLocation(450, 150);
		initFrame.setVisible(true);
		initFrame.add(initLabel);

		// Adds actionListener to x
		initFrame.getContentPane().add(x);
		x.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playerChar = "X";
				enemyChar = "O";
				initFrame.setVisible(false);
				mainFrame.setVisible(true);
			}
		});

		// Adds actionListener to o
		initFrame.getContentPane().add(o);
		o.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playerChar = "O";
				enemyChar = "X";
				initFrame.setVisible(false);
				mainFrame.setVisible(true);
			}
		});
		initFrame.pack();
		mainFrame.pack();

		// Board header
		text.setBackground(new Color(25, 25, 25));
		text.setFont(new Font("Arial", Font.BOLD, 50));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Tic-Tac-Toe");

		// Creates Button array for game board
		for (int i = 0; i < 9; ++i) {
			buttonArray[i] = new JButton("");
			bp.add(buttonArray[i]);
			buttonArray[i].setFont(new Font("Irish Grover", Font.BOLD, 120));
			buttonArray[i].addActionListener(this);
			buttonArray[i].setFocusable(false);
		}

		// Configures mainFrame
		mainFrame.setSize(600, 600);
		mainFrame.setLocation(450, 150);
		mainFrame.setLayout(new BorderLayout());
		textP.add(text);
		mainFrame.add(textP, BorderLayout.NORTH);
		mainFrame.add(bp);

		// Configures endFrame
		endFrame.setSize(400, 200);
		endFrame.setLocation(450, 150);
		endFrame.setLayout(new BorderLayout());
		endText.setFont(new Font("Arial", Font.BOLD, 30));
		endText.setHorizontalAlignment(JLabel.CENTER);

		endTextP.add(endText, BorderLayout.CENTER);
		;
		endFrame.getContentPane().add(endTextP, BorderLayout.NORTH);
		endFrame.getContentPane().add(endButtonP);

		endButtonP.add(playAgain);
		playAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				endFrame.dispose();
				TicTacToe.main(new String[1]);
			}
		});

		endButtonP.add(exitB);
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				System.exit(0);
			}
		});

	}

	// Populates selected button with playerChar value
	@Override
	public void actionPerformed(ActionEvent button) {
		boolean boardFull = true;
		// for(int e = 0; e < 5; ++e) {
		for (int i = 0; i < 9; ++i) {
			if (button.getSource() == buttonArray[i] && buttonArray[i].getText().equals("")) {
				buttonArray[i].setText(playerChar);
				winCondition();
				opponentTurn();
			} else if (button.getSource() == buttonArray[i] && buttonArray[i].getText().equals(enemyChar)
					|| button.getSource() == buttonArray[i] && buttonArray[i].getText().equals(playerChar)) {
				endText.setFont(new Font("Arial", Font.BOLD, 30));
				text.setText("Pick another location");

			}
		}
	}
	// Populates random button with enemyChar value

	public void opponentTurn() {
		Random rand = new Random();

		int opponentGuess = rand.nextInt(9);
		if (buttonArray[opponentGuess].getText().equals("")) {
			buttonArray[opponentGuess].setText(enemyChar);
			winCondition();
			text.setFont(new Font("Arial", Font.BOLD, 30));
			text.setText("Opponent moved. Your turn.");
		} else if (buttonArray[opponentGuess].getText().equals(enemyChar)
				|| buttonArray[opponentGuess].getText().equals(playerChar)) {
			opponentTurn();
		}
	}

	// Determines if player or computer has met standard conditions for winning
	// TicTacToe
	public void winCondition() {
		boolean boardFull = true;

		// Checks player win conditions
		if ((buttonArray[0].getText().equals(playerChar)) && (buttonArray[1].getText().equals(playerChar))
				&& (buttonArray[2].getText().equals(playerChar))) {
			endGame(playerChar, 0, 1, 2);
		} else if ((buttonArray[3].getText().equals(playerChar)) && (buttonArray[4].getText().equals(playerChar))
				&& (buttonArray[5].getText().equals(playerChar))) {
			endGame(playerChar, 3, 4, 5);
		} else if ((buttonArray[6].getText().equals(playerChar)) && (buttonArray[7].getText().equals(playerChar))
				&& (buttonArray[8].getText().equals(playerChar))) {
			endGame(playerChar, 6, 7, 8);
		} else if ((buttonArray[0].getText().equals(playerChar)) && (buttonArray[3].getText().equals(playerChar))
				&& (buttonArray[6].getText().equals(playerChar))) {
			endGame(playerChar, 0, 3, 6);
		} else if ((buttonArray[1].getText().equals(playerChar)) && (buttonArray[4].getText().equals(playerChar))
				&& (buttonArray[7].getText().equals(playerChar))) {
			endGame(playerChar, 1, 4, 7);
		} else if ((buttonArray[2].getText().equals(playerChar)) && (buttonArray[5].getText().equals(playerChar))
				&& (buttonArray[8].getText().equals(playerChar))) {
			endGame(playerChar, 2, 5, 8);
		} else if ((buttonArray[0].getText().equals(playerChar)) && (buttonArray[4].getText().equals(playerChar))
				&& (buttonArray[8].getText().equals(playerChar))) {
			endGame(playerChar, 0, 4, 8);
		} else if ((buttonArray[2].getText().equals(playerChar)) && (buttonArray[4].getText().equals(playerChar))
				&& (buttonArray[6].getText().equals(playerChar))) {
			endGame(playerChar, 2, 4, 6);
		}
		// check computer win conditions
		else if ((buttonArray[0].getText().equals(enemyChar)) && (buttonArray[1].getText().equals(enemyChar))
				&& (buttonArray[2].getText().equals(enemyChar))) {
			endGame(enemyChar, 0, 1, 2);
		} else if ((buttonArray[3].getText().equals(enemyChar)) && (buttonArray[4].getText().equals(enemyChar))
				&& (buttonArray[5].getText().equals(enemyChar))) {
			endGame(enemyChar, 3, 4, 5);
		} else if ((buttonArray[6].getText().equals(enemyChar)) && (buttonArray[7].getText().equals(enemyChar))
				&& (buttonArray[8].getText().equals(enemyChar))) {
			endGame(enemyChar, 6, 7, 8);
		} else if ((buttonArray[0].getText().equals(enemyChar)) && (buttonArray[3].getText().equals(enemyChar))
				&& (buttonArray[6].getText().equals(enemyChar))) {
			endGame(enemyChar, 0, 3, 6);
		} else if ((buttonArray[1].getText().equals(enemyChar)) && (buttonArray[4].getText().equals(enemyChar))
				&& (buttonArray[7].getText().equals(enemyChar))) {
			endGame(enemyChar, 1, 4, 7);
		} else if ((buttonArray[2].getText().equals(enemyChar)) && (buttonArray[5].getText().equals(enemyChar))
				&& (buttonArray[8].getText().equals(enemyChar))) {
			endGame(enemyChar, 2, 5, 8);
		} else if ((buttonArray[0].getText().equals(enemyChar)) && (buttonArray[4].getText().equals(enemyChar))
				&& (buttonArray[8].getText().equals(enemyChar))) {
			endGame(enemyChar, 0, 4, 8);
		} else if ((buttonArray[2].getText().equals(enemyChar)) && (buttonArray[4].getText().equals(enemyChar))
				&& (buttonArray[6].getText().equals(enemyChar))) {
			endGame(enemyChar, 2, 4, 6);
		} else {
			for (int i = 0; i < 9; ++i) {
				if (buttonArray[i].getText().equals("")) {
					boardFull = false;
					break;
				} else {
					boardFull = true;
					if (i == 8) {
						endGame("No Winner", 0, 0, 0);
					}
				}
			}
			return;
		}
	}

	// Open end game menu depending on winner
	public void endGame(String winner, int a, int b, int c) {

		if (winner.equals(playerChar)) {
			buttonArray[a].setBackground(Color.GREEN);
			buttonArray[b].setBackground(Color.GREEN);
			buttonArray[c].setBackground(Color.GREEN);

			endText.setText("You Win!\n");
			endFrame.setVisible(true);

		}

		else if (winner.equals(enemyChar)) {
			buttonArray[a].setBackground(Color.RED);
			buttonArray[b].setBackground(Color.RED);
			buttonArray[c].setBackground(Color.RED);

			endText.setText("You Lose!\n");
			endFrame.setVisible(true);
		} else {
			endText.setText("No Winner!");
			endFrame.setVisible(true);
		}

	}
}
