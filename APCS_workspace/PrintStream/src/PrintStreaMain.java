import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class PrintStreaMain {

	public static void main(String[] args) throws FileNotFoundException {
		File newFile = new File("test.txt");
		
		PrintStream output = new PrintStream(newFile);
		output.println("a	new nation,      conceived in 	liberty");	
		Scanner input = new Scanner(newFile);
		
		while (input.hasNext()) {
			String string = (String) input.next();
			output.print(string + " ");
			
		}
	}

}
