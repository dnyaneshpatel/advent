package com.advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class CPUInterruption {

	public static void main(String[] args) {
		File file = new File("./resources/Interruption.txt");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				file))) {

			String newLine = null;
			int checkSum = 0;
			CPUInterruption corruptionChecksum = new CPUInterruption();
			List<Integer> arrayList = new ArrayList<Integer>();
			int[] inputArray;
			while ((newLine = bufferedReader.readLine()) != null) {
				arrayList.add(Integer.parseInt(newLine));
				
				
			}
			inputArray = new int[arrayList.size()];
			for(int i =0;i<arrayList.size();i++){
				inputArray[i] = arrayList.get(i);
			}
			int noOfSteps = 0;
			System.out.println(corruptionChecksum.countNoOfStep(inputArray,0,0,noOfSteps));
		} catch (FileNotFoundException e) {
			e.printStackTrace();    
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private int countNoOfStep(int[] inputArray, int currValue, int index,
			int noOfSteps) {
		try {
			int currentOffset = 0;
			while(true){
				currValue = inputArray[index];
				if(currValue == 0){
					currValue++;
					inputArray[index] = currValue;
					noOfSteps++;
				} else {
					if(currValue >= 3){
						inputArray[index] = inputArray[index] - 1;
					} else {
						inputArray[index] = inputArray[index] + 1;
					}
					
					index = index + currValue;
					noOfSteps++;
					
				}
			}
		} catch (Exception e) {
			System.out.println("hahah");
			return noOfSteps;
		}
		//return noOfSteps;

	}
	

	
}
