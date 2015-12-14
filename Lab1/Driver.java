package Lab1;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		/* Variables & Objects */
		boolean loopVar = true;
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		Functions f = new Functions();
		
		while(loopVar) {
			System.out.println("1. Most Frequent");
			System.out.println("2. Average & Std Deviation");
			System.out.println("3. Set Dec");
			System.out.println("4. End");
			choice = scan.nextInt();
			switch(choice) {
			case 1: //Most frequent
				System.out.println("Enter numbers in a comma separated list");
				scan.nextLine();
				String nums = scan.nextLine();
				f.Func1(nums);
				break;
				
			case 2: //Avg & Std Dev
				System.out.println("Please Enter numbers in a comma separated list.");
				scan.nextLine();
				nums = scan.nextLine();
				f.Func2(nums);
				break;
			
			case 3: //Set Dec
				System.out.println("How many Places?");
				int dec = scan.nextInt();
				f.Func3(dec);
				break;
			
			case 4: //Quit
				System.out.println("Exiting...");
				System.exit(0);
			
			default: //Catch all
				System.out.println("Not Valid");
				break;
			}
		}
	}
}










