package Lab4;

import java.util.*;

public class Algorithms {
	/* Variables  */
	Scanner scan = new Scanner(System.in);
	int max;
	int sum;
	long time;

	//Time
	public void reportTime(long time) { 
		double mSec = (double)((System.nanoTime() - time) / 1000000);
		double sec =  mSec / 1000;
	
		if(mSec > 1000) {
			System.out.println("Runtime: " + sec + " seconds.");
		} else {
			System.out.println("Runtime: " + mSec + " milliseconds");
		}
	}
	
	public void menu(int a[]) {
		System.out.println("Which Algorithms would you like to run? ");
		//scan.nextLine();
		String order = scan.nextLine();
		
		for(int i = 0; i < order.length(); i++) {
			time = System.nanoTime();
			if(order.charAt(i) == '1') {
				System.out.println("Running Freshman...");
				System.out.println("Sum: " + Freshman(a));
				reportTime(time);
			}
			else if(order.charAt(i) == '2') {
				System.out.println("Running Sophmore...");
				System.out.println("Sum: " + Sophmore(a));
				reportTime(time);
			}
			else if(order.charAt(i) == '3') {
				System.out.println("Running Junior...");
				System.out.println("Sum: " + Junior(a, 0, a.length - 1));
				reportTime(time);
			}
			else if(order.charAt(i) == '4') {
				System.out.println("Running Senior...");
				System.out.println("Sum: " + Senior(a));
				reportTime(time);
			}
		}
	}
	
		
	//Algorithms
	public int Freshman(int a[]) {	
		max = 0;

		//Inner most loop will constantly calculate a consistent sum from 0 to n - 1
		// of every single element and all their possible combinations
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j < a.length; j++) {
				sum = 0;
				for(int k = i; k <= j; k++) {
					sum += a[k];
				}
				if(sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
	
	public int Sophmore(int a[]) {
		max = 0; 
		
		//Like the Freshman, however computes entire list sum iterations
		// each run of the inner computes the sum of an ever decreasing 
		// list, keeps and returns largest
		for(int i = 0; i < a.length; i++) {
			sum = 0;
			for(int j = i; j < a.length; j++) {
				sum += a[j];
				if(sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	public int Junior(int a[], int left, int right) {
		//Base Case, for arrays of size 2, none, or negative
		if(left == right) {
			if(a[left] > 0) {
				return a[left];
			} else {
				return 0;
			}
		}
		//Determine center of list 
		int mid = (left + right) / 2;
		
		//Loops recursively back into itself to find maximum left/right value
		// a[] - list, never changes
		// left/right - is the farthest bound, never changes, left = 0, right = length - 1
		// mid - the bound for the list from the middle, constantly being recalculated
		//Both yield a maximum value stored in their respective variables
		int lMax = Junior(a, left, mid);
		int rMax = Junior(a, mid + 1, right);
		
		//Following portion determines the largest sum of the left and right portions
		int cur = 0, lSum = 0, rSum = 0;
		
		for(int i = mid;i >= left; i--) {
			cur += a[i];
			if(cur > lSum) {
				lSum = cur;
			}
		}
		cur = 0;
		for(int i = mid + 1; i <= right; i++) {
			cur += a[i];
			if(cur > rSum) {
				rSum = cur;
			}
		}
		
		//The final portion will take the largest sums of the left, right, and
		// center divisions and determine the largest of the 3 returning that value
		return Junior(lMax, rMax, lSum + rSum);
	}
	
	//private recursive method to find max of 3 sums
	private int Junior(int lMax, int rMax, int leftRightSum)
	{
		if(lMax > rMax) {
			if(lMax > leftRightSum) {
				return lMax;
			} else {
				return leftRightSum;
			}
		} else if(rMax > leftRightSum) {
			return rMax;
		} else {
			return leftRightSum;
		}
    }
	
	public int Senior(int a[]) {
		max = 0;
		sum = 0;
		
		//Iterates through computing a sum, stores the largest, 
		// if negative returns 0. Doesn't need as many loops b/c
		// determines a running sum and only saves it if it is larger
		for(int i = 0;i < a.length; i++) {
			sum += a[i];
			
			if(sum > max) {
				max = sum;
			}
			else if(sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
}
