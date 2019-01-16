package stringmanupulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * finding a word match from dictionary with least amount of 
 * character deletion from our input word.
 * 
 * my logic: 
 * > get all words from dictionary starting with each char of input word
 * > filter words with length equal to or less than input word since after deletion
 * 		of chars from input word length will shrink
 * > arrange filtered words from dict in descending order of length
 * > loop dict word and remove or replace each char of dict word that our input word has so
 * 		we are left with empty or repeating string if all char from input 
 * 		word were same as dict word 
 * 
 * @author AJ
 *
 */
public class ValidWordWithDeletion {

	public static void main(String[] args) {
		
		String[] arr = {"adef", "ab", "abc", "abcd", "acd", "bcd", "def", "a", "aba", "fdec", "fde"};
		Dictionary.save(arr);
		
		String testS = "aaba";
		
		/* ** get all words starting with letters in given string */
		List<String> flatList = new ArrayList<>();
		for (int i = 0; i < testS.length(); i++) {
			List<String> temp = Dictionary.get(testS.charAt(i));
			if(temp != null) {
				flatList.addAll(temp);
			}
		}
		flatList = 
				flatList.stream().filter(
						i -> i.length() <= testS.length())
				.collect(Collectors.toList());
		
		Collections.sort(flatList, (s1, s2) -> s2.length() - s1.length());
		
		System.out.println(flatList);
		
		for (String word : flatList) {
			String test = new String(word);
			for (int i = 0; i < testS.length(); i++) {
				test = test.replace(testS.charAt(i), '!');
				System.out.println(test);
			}
			if(test.equals(new String(new char[word.length()]).replace("\0", "!"))) {
				System.out.println("Matching word is: " + word);
				return;
			}
		}
	}




	private static class Dictionary {
		private static WordList[] dict = new WordList[26];

		public static boolean save(String[] arr) {
			for (int i = 0; i < arr.length; i++) {
				int hash = getHash(arr[i].charAt(0));
				if(dict[hash] == null) {
					dict[hash] = new WordList();
				}
				dict[hash].add(arr[i]);
			}
			return false;
		}


		private static int getHash(char c) {
			return (int)c - (int) 'a';
		}

		public static List<String> get(char c) {
			WordList words = dict[(int)c - (int)'a'];
			if(words != null) {
				return dict[(int)c - (int)'a'].get().stream().sorted().collect(Collectors.toList());
			} else {
				return null;
			}
		}


	}

	private static class WordList {
		private List<String> localList = new ArrayList<>();
		public boolean add(String value) {
			return this.localList.add(value);
		}
		public List<String> get() {
			return this.localList;
		}
		public String get(int index) {
			return this.localList.get(index);
		}
	}

}