package Lab5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MPSS_Algorithm {
	/* Variables  */
	Scanner scan = new Scanner(System.in);
	//int min = 500;
	long time;
	
	int mid = 0;
	int count = 0;
	int[] leftSum;
	int[] rightSum;
	int[] a;
	int n;
	
	boolean f = true;
	
	public void randomArray() {
		System.out.println("Enter the size: ");
		n = scan.nextInt();
		a = new int[n]; 
		
		for(int i = 0; i < n; i ++) {
			a[i] = (int) ((Math.random() * 500) % 500 + 1) - 250;
		}
		
		System.out.println("Running Sophmore...");
		time = System.nanoTime();
		System.out.println("MPSS Sophmore is " + mpss_sophmore(a, 0, a.length - 1));
		reportTime(time);
		System.out.println("Running Junior...");
		time = System.nanoTime();
		System.out.println("MPSS Junior is " + mpss_junior(a, 0, a.length - 1));
		reportTime(time);
	}
	
	public void createArray() {
		System.out.println("How large is the list? ");
		n = scan.nextInt();
		System.out.println("Enter numbers in a comma separated list");
		scan.nextLine();
		String nums = scan.nextLine();
		List<String> b = Arrays.asList(nums.split("\\s*,\\s*"));
		
		a = new int[n];
		
		for(int i = 0; i < b.size(); i++) {
			a[i] = Integer.valueOf(b.get(i));
		}
		
		System.out.println("Running Sophmore...");
		time = System.nanoTime();
		System.out.println("MPSS Sophmore is " + mpss_sophmore(a, 0, a.length - 1));
		reportTime(time);
		System.out.println("Running Junior...");
		time = System.nanoTime();
		System.out.println("MPSS Junior is " + mpss_junior(a, 0, a.length - 1));
		reportTime(time);
	}
	
	public int mpss_sophmore(int[] a, int left, int right) {
		int sum = 500; 
		int cur;

		for(int i = 0; i < a.length; i++) {
			cur = 0;
			for(int j = i; j < a.length; j++) {
				cur += a[j];
				if(cur < sum && cur > 0) {
					sum = cur;
				}	
			}
		}
		return sum;
	}
	
	public int mpss_junior(int a[], int left, int right) {
		if(right - left < 2) {
			return min(a[right], a[left]);
		} 
			
		int mid = (left + right) / 2;
		
		//int l = mpss_junior(a, left, mid);
		//int r = mpss_junior(a, mid + 1, right);
		//int m = mpss_mid(a, mid, left, right);
		
		//System.out.println("left " + l);
		//System.out.println("right " + r);
		//System.out.println("mid " + m);

		return min(min(mpss_junior(a, left, mid), mpss_junior(a, mid + 1, right)), mpss_mid(a, mid, left, right));
	}
	
	public int mpss_mid(int[] a, int mid, int left, int right)
	{	
		leftSum = new int[mid - left + 1];
		rightSum = new int[right - mid];
		
		int cur = 0;
		count = 0;
	
		//Left
		for(int i = mid;i >= left; i--) {
			cur += a[i];
			leftSum[count] = cur;
			count++;
		}
		cur = 0;
		count = 0;
		
		//Right
		for(int i = mid + 1; i <= right; i++) {
			cur += a[i];
			rightSum[count] = cur;
			count++;
		}
		
		Arrays.sort(leftSum);
		Arrays.sort(rightSum);
		
		//System.out.println(Arrays.toString(leftSum));
		//System.out.println(Arrays.toString(rightSum));
		
		int val = 0;
		int min = 500;
		int i = 0, j = rightSum.length - 1;
		while(i < leftSum.length && j >= 0) {
			val = leftSum[i] + rightSum[j];
			if(val <= 0) {
				i++;
			} else {
				j--;
			} if(val < min && val > 0) {
				min = val;
			}
		}
		//System.out.println("Mid is " + min);
		return min;
	}
	
	//Min of three values
	public int min(int a, int b, int c) {
		return min(min(a, b), c);
	}
	
	//Min of two values
	public int min(int a, int b) {
		//Both negative
		if(a <= 0 && b <= 0) {
			return 500;
		//Both positive
		}
		if(a > 0 && b > 0) {
			if(a < b) { 
				return a; 
			} else {
				return b;
			}
		//One + another -
		} else if(a > 0 && b <= 0) {
			if(a + b > 0 && a + b < a) {
				return a + b;
			} else { 
				return a;
			}
		} else if(a <= 0 && b > 0) {
			if(a + b > 0 && a + b < b) {
				return a + b; 
			} else {
				return b;
			}
		} else {
			return 500;
		}
	}
	
	public void reportTime(long time) { 
		double mSec = (double)((System.nanoTime() - time) / 1000000);
		double sec =  mSec / 1000;
	
		if(mSec > 1000) {
			System.out.println("Runtime: " + sec + " seconds.");
		} else {
			System.out.println("Runtime: " + mSec + " milliseconds");
		}
	}
}