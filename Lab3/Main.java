package Lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/* Variables */
		
		Scanner scan = new Scanner(System.in);
		
		boolean menu = true;
		boolean p = false;
		
		while(menu) {
			//Menu
			System.out.println("1. Run Simmulation");
			System.out.println("2. Enable Print, Current Status: " + p);
			System.out.println("3. Exit");
			int menuChoice = scan.nextInt();
			
			switch(menuChoice) {
			case 1:
				
				System.out.println("Register Length (n)");
				int n = scan.nextInt();
				
				int[] a = new int[n];
				
				System.out.println("Register Cap(k)");
				int k = scan.nextInt();
				
				long t = System.nanoTime();
				
				/* index variable */
				int i = 0;
				/* conditional bool var */
				boolean loop = false;
				/* index out of bounds */
				while(i < n) {
					// First run the 'counter' portion of the program
					// runs until a[i] == k - 1
					
					// stays here until hits k - 1 in the reg
					if(a[i] < k - 1) {
						a[i]++;
						if(p == true) {
							System.out.println(Arrays.toString(a));
						}
						//reset the index variable  every time
						i = 0;
					} else {
						//upon reaching k - 1, reset the register
						a[i] = 0;
						//and move up the index
						i++;
					}
				}
				double mSec = (double)((System.nanoTime() - t) / 1000000);
				double sec =  mSec / 1000;
				
				if(mSec > 1000) {
					System.out.println("Runtime: " + sec + " seconds.");
				} else {
					System.out.println("Runtime: " + mSec + " milliseconds");
				}
				break;
				
			case 2: 
				if(!p) {
					p = true;
					System.out.println("Status: " + p);
				} else {
					p = false;
					System.out.println("Status: " + p);
				}
				break;
				
			case 3: 
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Not Valid");
					break;
			}
		}
	}
}


