package Lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Counting Tables Lab:
 * Part 1: Create counting table
 * 		1. Create a Hashtable to store int objects
 * 		2. Tables of size p, where p is PRIME
 * 		3. Data stored cannot exceed floor(p/2) <====== IMPORTANT
 * 		4. Create table array that stores counts of counting table
 * 
 * Part 2: Create Add, Subtract, and Count
 * 		1. Given sample code for add
 * 
 * Part 3: Write two algorithms for finding mode
 * 		1. First algorithm given n^2
 * 		2. Second should be n
 * 
 * Part 4: Menu
 * 		1. Create a counting table of size p, show it
 * 		2. Add/Subtract/Count operations
 * 			a. Updated table for user
 * 		3. Comma-delimited array of a ints
 * 			a. Return modes for list using both algorithms
 * 		4. Random array of length n from [1000, -1000]
 * 			a. Executes both algorithms report times
 * 		5. Quit
 * 
 * @author Yoseph
 *
 */

public class CountingTables {
	/* Variables */
	int index, lamda, pval;
	int[] hTable, cTable;
	
	long time;
	
	ArrayList<Integer> baseList;
	
	// Creates comma-delimited list
	public void create(List<String> b, int p) {
		pval = p;
		lamda = (int) (Math.floor(p / 2));
		
		baseList = new ArrayList<Integer>();
		hTable = new int[p];
		cTable = new int[p];
		
		int num;
		for(int i = 0; i < p; i ++) {
			num = Integer.valueOf(b.get(i));
			baseList.add(num);
			this.add(num);
		}
		
	}
	
	// Create a table of size p, MUST BE PRIME
	public void create(int p) {
		pval = p;
		lamda = (int) (Math.floor(p / 2));
		
		hTable = new int[p];
		cTable = new int[p];
		baseList = new ArrayList<Integer>();
		
		int num;
		for(int i = 0; i < p; i ++) {
			num = (int) ((Math.random() * 500) % 500 + 1) - 250;
			baseList.add(num);
			this.add(num);
		}
	}
	
	public void display() {
		System.out.print("\nOriginal List\n" + baseList.toString());
		
		System.out.print("\nHash Table\n");
		for(int i = 0; i < pval; i++) {
			System.out.format(" [%d] ", hTable[i]);
		}
		
		System.out.print("\nCounting Table\n");
		for(int j = 0; j < pval; j++)
		{
			System.out.format(" [%d] ", cTable[j]);
		}
		
		System.out.print("\nIndex\n");
		for(int k = 0; k < pval; k++)
		{
			System.out.format(" [%d] ",k);
		}
		System.out.println("");
	}
	
	// Hash function 
	public int hash(int x) {
		int n = 0, hashVal = 0;
		String temp = "" + x;
		
		for(; n < temp.length(); n++) {
			hashVal += temp.charAt(n) * Math.pow(37, temp.length() - n);
		}
		return hashVal;
	}
	
	// ----------------------------Basic Functions----------------------------
	// Increments the count of x. Returns the current count for x
	public int add(int x) {
		index = hash(x) % pval; //p is size of table
		int i = 0; //Probe index
		
		int next_Index, new_Count;
		
		while (true) {
			// Quadratic Probing
			next_Index = Math.abs(((int) (index + i * i)) % pval);
			
			//System.out.println(next_Index);
			
			if(cTable[next_Index] == 0) {
				hTable[next_Index] = x;
				cTable[next_Index] = 1;
				return 1;
			} else if(x == hTable[next_Index]) {
				new_Count = cTable[next_Index] + 1;
				cTable[next_Index] = new_Count;
				return new_Count;
			}
			i++;
		}
	}
	
	// Decrements the count of x. Returns the current count for x
	public void remove(int x) {
		index = hash(x) % lamda; // p is size of table
		int i = 0; // Probe index
			
		int next_Index, new_Count;
			
		while (true) {
			next_Index = (int) (index + (i * i) % lamda);
				
			if(x == hTable[next_Index]) {
				new_Count = cTable[next_Index] - 1;
				cTable[next_Index] = new_Count;
				break;
			}
			i++;
		}
	}
		
	// Reports the number of times an object has been added to the table
	public int count(int x) {
		index = hash(x) % lamda; //p is size of table
		int i = 0; //Probe index
		
		int next_Index;
		
		while(true) {
			next_Index = (int) (index + (i * i) % lamda);
			if(x == hTable[next_Index]) {
				return cTable[next_Index];
			}
			i++;
		}
	}
	
	// ----------------------------Mode Algorithms----------------------------
	// Executes Algorithms
	public void executeAlgorithms() {
		time = System.nanoTime();
		System.out.println("Running Sophmore...");
		System.out.println("Modes ----------> " + sophmore(baseList, baseList.size()));
		reportTime(time);
		time = System.nanoTime();
		System.out.println("Running Junior...");
		System.out.println("Modes ----------> " + junior(lamda));
		reportTime(time);
	}
	
	// Reports running times
	public void reportTime(long time) { 
		double mSec = (double)((System.nanoTime() - time) / 1000000);
		double sec =  mSec / 1000;
	
		if(mSec > 1000) {
			System.out.println("Runtime: " + sec + " seconds.");
		} else {
			System.out.println("Runtime: " + mSec + " milliseconds");
		}
	}
	
	// Runs @ Theta(n^2) 
	public int sophmore(ArrayList<Integer> baseList, int n) {
		int mode = 0;
		int max_count = 0;
		int i, candidate, count, j;
		
		for(i = 0; i < n; i++) {
			candidate = baseList.get(i);
			count = 1;
			for(j = 0; j < n; j++) {
				if(baseList.get(j) == candidate)
					count++;
			}
			if(count > max_count) {
				max_count = count;
				mode = candidate;
				//sophModes.add(mode);
			}
		}
		return mode;
	}
	
	// Runs @ Theta(n)
	public int junior(int lamda) {
		int mode = 0;
		int index = 0;
		int i;
		
		for(i = 0; i < lamda; i++) {
			if(cTable[i] > mode) {
				index = i;
				mode = cTable[i];
			}
		}
		return hTable[index];
	}
}
