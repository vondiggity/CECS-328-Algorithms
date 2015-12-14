package Lab5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Lab4.Algorithms;

public class Driver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MPSS_Algorithm alg = new MPSS_Algorithm();
		
		boolean menu = true;
		
		while(menu) {
			System.out.println("1. Run Junior and Sophmore Algorithms");
			System.out.println("2. Run Test Values");
			System.out.println("3. Exit");
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				alg.createArray();
				break;
			case 2:
				alg.randomArray();
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
