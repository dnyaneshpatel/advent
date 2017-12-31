package com.advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CorruptionChecksum {
	
	public static void main(String[] args) {
		File file = new File("./resources/input.txt");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				file))) {

			String newLine = null;
			int checkSum = 0;
			CorruptionChecksum corruptionChecksum = new CorruptionChecksum();
			while ((newLine = bufferedReader.readLine()) != null) {
				int diffOfLargestAndSmallest = corruptionChecksum
						.getDiffofLargestAndSmallest(newLine);
				checkSum = checkSum + diffOfLargestAndSmallest;
			}
			System.out.println(checkSum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private int getDiffofLargestAndSmallest(String rowContet){
		int largestNumber = 0;
		int smallestNumber = 0;
		StringTokenizer tokenizer = new StringTokenizer(rowContet);
		
		while(tokenizer.hasMoreTokens()){
			int currentNumber = Integer.parseInt(tokenizer.nextToken());
			smallestNumber = (smallestNumber == 0) ? currentNumber : currentNumber < smallestNumber ? currentNumber : smallestNumber;
			largestNumber = (largestNumber == 0) ? currentNumber : currentNumber > largestNumber ? currentNumber : largestNumber;
		}
		return largestNumber - smallestNumber;
	}

}
