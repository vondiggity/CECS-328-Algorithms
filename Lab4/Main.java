package Lab4;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Algorithms alg = new Algorithms();
		
		int a[];
		long time;
		
		boolean menu = true;
		
		while(menu) {
			System.out.println("1. Calculate the Max Subsequence of a list.");
			System.out.println("2. Test Algorithms.");
			System.out.println("3. Exit.");
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("How large is the list? ");
				int s = scan.nextInt();
				System.out.println("Enter numbers in a comma separated list");
				scan.nextLine();
				String nums = scan.nextLine();
				List<String> b = Arrays.asList(nums.split("\\s*,\\s*"));
				
				a = new int[s];
				
				for(int i = 0; i < b.size(); i++) {
					a[i] = Integer.valueOf(b.get(i));
				}
				
				alg.menu(a);
				
				break;
			case 2:
				System.out.println("Enter the size: ");
				int size = scan.nextInt();
				a = new int[size]; 
				
				for(int i = 0; i < size; i ++) {
					a[i] = (int)((Math.random() * 100)) - 50;
				}
				
				alg.menu(a);
				
				break;
			case 3:
				System.out.println("Exiting...");
				menu = false;
				System.exit(0);
				break;
			default:
				System.out.println("Invalid.");
				break;
			}
		}
		
	}
}
