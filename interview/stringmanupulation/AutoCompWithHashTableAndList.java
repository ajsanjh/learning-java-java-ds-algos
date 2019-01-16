package stringmanupulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * this has lower read complexity since there is no need to loop over list in
 * hash bucket to return a list, we can just return the list saved in that hash
 * bucket.
 * @author AJ
 *
 */
public class AutoCompWithHashTableAndList {

	public static void main(String[] args) {
		String[] arr = {"ab", "abc", "abcd", "acd", "bcd", "def", "a", "aba"};

		Dictionary.save(arr);	

		System.out.println(Dictionary.get('a'));
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
			return dict[(int)c - (int)'a'].get().stream().sorted().collect(Collectors.toList());
		}


	}

	private static class WordList {
		private List<String> localList = new ArrayList<>();
		public boolean add(String value) {
			this.localList.add(value);
			return true;
		}
		public List<String> get() {
			return this.localList;
		}
	}

}