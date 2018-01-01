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

public class PassphraseChecksum {

	public static void main(String[] args) {
		File file = new File("./resources/passphrase.txt");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				file))) {

			String newLine = null;
			int checkSum = 0;
			PassphraseChecksum corruptionChecksum = new PassphraseChecksum();
			while ((newLine = bufferedReader.readLine()) != null) {
				if(corruptionChecksum.isValidPassphrase(newLine)){
					checkSum++;
				}
				
			}
			System.out.println(checkSum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean isValidPassphrase(String rowContet) {
		Map<String, String> rowValueMap = new HashMap<String, String>();
		List<String> currentPassphraseValues = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(rowContet);
		while (tokenizer.hasMoreTokens()) {
			String currentPassphrase = tokenizer.nextToken();
			if (!rowValueMap.containsKey(currentPassphrase)) {
				rowValueMap.put(currentPassphrase, currentPassphrase);
				currentPassphraseValues.add(currentPassphrase);
			} else {
				return false;
			}
		}
		Set<String> keySet = rowValueMap.keySet();
		Iterator<String> keySetIterator = keySet.iterator();
		while (keySetIterator.hasNext()) {
			String currentKey = keySetIterator.next();
			currentPassphraseValues.remove(currentKey);
			int length = currentKey.toCharArray().length;
			int maxValue = 1;
			while(length > 0){
				maxValue = maxValue * (length);
				length = length - 1;
			}
			//System.out.println(maxValue);
			for (int i = 0; i < maxValue * 5; i++) {
				String shuffledString = shuffle(currentKey);
				//System.out.println(shuffledString);
				if (currentPassphraseValues.contains(shuffledString)) {
					return false;
				}
			}
			currentPassphraseValues.add(currentKey);
		}
		
		return true;
	}
	
	private String shuffle(String input){
		 List<Character> characters = new ArrayList<Character>();
		    for(char c : input.toCharArray()) {
		        characters.add(c);
		    }
		    Collections.shuffle(characters);
		    StringBuffer sb = new StringBuffer();
		    for(char c : characters) {
		        sb.append(c);
		    }
		    return sb.toString();
	}
	
	
}
