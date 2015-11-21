package MainWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame{

	private int remainingGuesses;
	private String wrongGuesses;
	private String word;
	private String visible;
	
	public static void main(String[] args) {
        new MainWindow("cat");
    }	
	
	public MainWindow(String toGuess) {
		remainingGuesses = 10;
		wrongGuesses = "";
		word = toGuess;
		
		visible = "";
		
		for(int i = 0; i < word.length(); i++) {
			visible += "_ ";
		}
		
		JPanel corePanel = new JPanel();
		corePanel.setLayout(new BorderLayout());
		
		JLabel status = new JLabel("You have " + remainingGuesses+ "remaining", SwingConstants.CENTER);
		JLabel wrong = new JLabel("Wrong guesses so far: "+wrongGuesses);
		JLabel visibleLabel = new JLabel(visible, SwingConstants.CENTER);
		JTextField input = new JTextField();
		
		JPanel southPanel = new JPanel(new GridLayout(4, 1));
		southPanel.add(status);
		southPanel.add(visibleLabel);
		southPanel.add(input);
		southPanel.add(wrong);
		
		corePanel.add(southPanel, BorderLayout.SOUTH);
		
		this.add(corePanel, BorderLayout.CENTER);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
