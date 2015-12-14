package Lab6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CountingTables c = new CountingTables();
		
		boolean menu = true;
		
		while(menu) {
			System.out.println("-----MENU-----");
			System.out.println("1. Enter a List of integers");
			System.out.println("2. Create a random array");
			System.out.println("3. Add");
			System.out.println("4. Subtract");
			System.out.println("5. Count");
			System.out.println("6. Display");
			System.out.println("7. Quit");
			
			int choice = scan.nextInt();
			
			switch(choice) {
			// Comma-Delimited
			case 1:
				System.out.println("Enter numbers in a comma separated list");
				String list = scan.next();
		
				List<String> b = Arrays.asList(list.split("\\s*,\\s*"));
				
				int p = b.size();
			
				c.create(b, p);
				c.executeAlgorithms();
				break;
			// Random Array
			case 2:
				System.out.println("What size table would you like to create?");
				//int p = scan.nextInt();
				
				c.create(scan.nextInt());
				c.executeAlgorithms();
				break;
			// Add
			case 3:
				System.out.println("Enter the value to be added: ");
				System.out.println();
				int num = scan.nextInt();
				c.baseList.add(num);
				c.add(num);
				System.out.println(num + " has been hashed");
				break;
			// Subtract
			case 4:
				System.out.println("Enter the value to be removed: ");
				System.out.println();
				num = scan.nextInt();
				c.baseList.remove(c.baseList.indexOf(num));
				c.remove(num);
				System.out.println(num + " has been removed");
				break;
			// Count
			case 5:
				System.out.println("Return count for? ");
				System.out.println("Instances: " + c.count(scan.nextInt()));
				break;
			// Display
			case 6:
				c.display();
				break;
			// Quit
			case 7:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			// Error-Handling
			default:
				System.out.println("Invalid.");
					break;
			}
		}
	}
}
