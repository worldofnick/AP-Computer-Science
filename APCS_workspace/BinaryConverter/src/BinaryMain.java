import java.util.Scanner;

// Nick Porter
public class BinaryMain {

	public static void main(String[] args) {

		System.out.print("Enter an integer: ");
		Scanner console = new Scanner(System.in);
		int base10 = 0;
		BinaryConverter converter = new BinaryConverter();
		while(true) {
			try {
				base10 = console.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter a valid base ten number");
				System.out.println("\nEnter an integer: ");
				base10 = console.nextInt();
				continue;
			}
			if (base10 < 0) {
				System.out.println("Please enter a non-negative base ten number");
				System.out.println("\nEnter an integer: ");
				base10 = console.nextInt();
				continue;
			}
			converter.base10ToBase2(base10);
			System.out.print("> " + converter);
			System.out.println("\nEnter an integer: ");
			
		}

	}

}

/*Enter an integer: 5
> 101
Enter an integer: 
321
> 101000001
Enter an integer: 
123456
> 11110001001000000
Enter an integer: 
-1
Please enter a non-negative base ten number
Enter an integer:*/