package Lab1;

import java.text.DecimalFormat;
import java.util.*;

public class Functions {
	
	DecimalFormat df = new DecimalFormat();
	
	public Functions() {
		
	}
	
	public void Func1(String nums) {
		List<String> sList = Arrays.asList(nums.split("\\s*,\\s*"));
		
		System.out.println(sList + "String Array");
		List<Integer> iList = new ArrayList<Integer>();
		for(int i = 0; sList.size() > i; i++) {
			iList.add(Integer.parseInt(sList.get(i)));
		}
		System.out.println(iList + "Integer Array");
		
		//Computation Begins
		int fNum = 0, freq = 0, highestFreq = 0;
		for(int i = 0; iList.size() > i; i++) {
			freq = Collections.frequency(iList, iList.get(i));
			if(freq > highestFreq) {
				System.out.println("here");
				highestFreq = freq;
				fNum = iList.get(i);
			}
		}
		System.out.println(fNum + " has the most occurances.");
	}
	
	public void Func2(String nums) {
		List<String> sList = Arrays.asList(nums.split("\\s*,\\s*"));
		
		System.out.println(sList + "String Array");
		List<Float> fList = new ArrayList<Float>();
		for(int i = 0; sList.size() > i; i++) {
			fList.add(Float.parseFloat(sList.get(i)));
		}
		System.out.println(fList + "Float Array");
		
		float sum = 0;
		for(int i = 0; fList.size() > i; i++) {
			sum += fList.get(i);
		}
		sum = (float) sum / fList.size();
		
		float std = 0;
		for(int i = 0; fList.size() > i; i++) {
			std += (float) Math.pow((fList.get(i) - sum), 2);
		}
		std = (float) Math.sqrt(std / fList.size());
		
		System.out.println("The Average is: " + df.format(sum));
		System.out.println("Standard Deviation is: " + df.format(std));
	}
	
	public void Func3(int dec) {
		df.setMaximumFractionDigits(dec);
	}
}
