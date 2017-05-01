import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HiLowGUI extends JFrame {
	private JTextField textGuess;
	private JLabel lblOutput;
	private int rndNumber;
	private int triesLeft;
	
	public HiLowGUI() {
		getContentPane().setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblHilowGuessingGame = new JLabel("Hi-Low Guessing Game");
		lblHilowGuessingGame.setBounds(-3, 29, 434, 19);
		lblHilowGuessingGame.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHilowGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHilowGuessingGame);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(66, 77, 319, 33);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel.setBounds(4, 5, 241, 19);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		textGuess = new JTextField();
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		textGuess.setHorizontalAlignment(SwingConstants.CENTER);
		textGuess.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textGuess.setBounds(255, 6, 48, 20);
		panel.add(textGuess);
		textGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnGuess.setBounds(170, 139, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above. You have 7 tries left!");
		lblOutput.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(-3, 191, 434, 39);
		getContentPane().add(lblOutput);
	}
	
	public void checkGuess(){
		String guessText = textGuess.getText();
		String message = "";
		try{
			int guess = Integer.parseInt(guessText);
			triesLeft--;
			if(guess < rndNumber){
				message = guess + " was too low. " + triesLeft + " tries left";
			}
			else if(guess > rndNumber){
				message = guess + " was too high. " + triesLeft + " tries left";
			}
			else{
				message = guess + " was right! You win! Let's play again!";
				newGame();
			}
		}
		catch(Exception e){
			message = "Enter a whole number between 1 and 100!";
		}
		finally{
			if (triesLeft == 0){
				int answer = JOptionPane.showConfirmDialog(null, "You ran out of tries. The number was " + rndNumber + ". Play again!");
				if(answer == JOptionPane.YES_OPTION){
					newGame();
				}
				else{
					System.exit(0);
				}
				
			}
			lblOutput.setText(message);
			textGuess.requestFocus();
			textGuess.selectAll();
		}
	}
	

	private void newGame() {
		Random rnd = new Random();
		rndNumber = rnd.nextInt(101);
		triesLeft = 7;
	}

	public static void main(String[] args) {
		HiLowGUI theGame = new HiLowGUI();
		theGame.newGame();
		theGame.setSize(new Dimension(430,330));
		theGame.setLocationRelativeTo(null);
		theGame.setVisible(true);
		theGame.setResizable(false);

	}
}
