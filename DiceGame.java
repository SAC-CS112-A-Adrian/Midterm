import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int gamesPlayed = 0;
		int gamesWon = 0;
		int gamesLoss = 0;
		float winningPercentage;
		int evenOrOdd;
		int dice;
		String message;
		String guess;
		int userGuess;
		int numberOfEvenGuesses = 0;
		int numberOfOddRolls = 0;

		boolean again = true;

		while (again) {

			dice = 1 + (int) (Math.random() * 6);

			guess = JOptionPane.showInputDialog("Roll the dice! Guess even or odd?\nEnter 0 for even, 1 for odd");
			userGuess = Integer.parseInt(guess);

			gamesPlayed++;

			evenOrOdd = dice % 2;

			if (evenOrOdd == userGuess)
				gamesWon++;
			else
				gamesLoss++;

			if (userGuess == 0)
				numberOfEvenGuesses++;

			int evenPercentage = numberOfEvenGuesses / gamesPlayed;

			if (evenOrOdd == 1)
				numberOfOddRolls++;

			int oddRollsPercentage = numberOfOddRolls / gamesPlayed;

			winningPercentage = gamesWon / gamesPlayed;

			message = String.format(
					"You rolled a %d!\n\nYou've played %d game(s)\nYour winning percentage is %d / %d\n\nPercentage of Even guesses: %d / %d\nPercentage of Odd rolls: %d / %d",
					dice, gamesPlayed, gamesWon, gamesPlayed, numberOfEvenGuesses, gamesPlayed, numberOfOddRolls,
					gamesPlayed);
			JOptionPane.showMessageDialog(null, message);

			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to try again?");
			if (dialogResult == JOptionPane.NO_OPTION)
				again = false;

		}
	}
}
