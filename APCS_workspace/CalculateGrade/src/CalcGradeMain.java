import java.util.*;
// Nick Porter

public class CalcGradeMain {
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		printScores();
		
	}
	
	private static void printScores() {
		final double POINTS_POSSIBLE = 10.0;                          // points possible for one grade
		int addedScores = 0;
		
		System.out.print("How many scores will you enter? ");
		int numberOfGrades = userInput.nextInt();                  // gets number of grades to be entered 
		
		for (int scores = 1; scores <= numberOfGrades; scores++) {
			System.out.print("Enter Score #" + scores + " ");
			int enteredScore = userInput.nextInt();                        // asks for score
			if (enteredScore > 10) {
				System.out.println("Cheating detected score entered is greather than 10, score has been changed to a 0"); // extra credit - changes score to 0 if score is over 10
				enteredScore = 0;
			}
			addedScores = addedScores + enteredScore;                                  // sums up all scores 
			double percentage = Math.round(addedScores / (POINTS_POSSIBLE * scores) * 100);     // calculates percentage while increasing pointsPossible and rounds                 
			System.out.println("	The current percentage is: " + percentage + "%");	
			
			if (scores == numberOfGrades){                                          
				if (percentage >= 90 && percentage <= 100 ) {
					System.out.println("Your grade is an A: Nice bro!");
				} else if (percentage >= 80 && percentage <= 89) {
					System.out.println("Your grade is a B: Keep working you've almost got it!");
				} else if (percentage >= 70 && percentage <= 79) {
					System.out.println("Your grade is a C: Try harder!");
				} else if (percentage >= 60 && percentage <= 69) {
					System.out.println("Your grade is a D: Quit slacking!");
				} else if (percentage >= 50 && percentage <= 59 ) {
					System.out.println("Your grade is an F: Hit the books");
				}
			}			
		}
	}
}
/*
Required Output
How many scores will you enter? 3
Enter Score #1 9
The current percentage is: 90.0%
Enter Score #2 8
The current percentage is: 85.0%
Enter Score #3 8
The current percentage is: 83.0%
Your grade is a B: Keep working!
   
   Extra Credit
   How many scores will you enter? 3
Enter Score #1 10
The current percentage is: 100.0%
Enter Score #2 7
The current percentage is: 85.0%
Enter Score #3 11
Cheating detected, score has been changed to a 0
The current percentage is: 57.0%
Your grade is an F: Hit the books
 */
