package stringmanupulation;

import java.util.Arrays;


/**
 * When two strings have same letters. 
 */
public class Anagrams {
	
	public static void main(String[] args) {
		System.out.println(FindIfTwoStringsAreAnagrams.isTrue("aaab", "bbba"));
		System.out.println(FindIfTwoStringsAreAnagrams.isTrue("listen", "silent"));
		
		System.out.println("----------");
		
		System.out.println(CheatDemo.test("listen", "silent"));
		System.out.println(CheatDemo.test("aab", "bba"));
	}
	
	
	
	private static class FindIfTwoStringsAreAnagrams {
		static boolean isTrue(String a, String b) {

			if(a.length() != b.length()) {
				return false;
			}
			
			
			a = a.toLowerCase();
			char[] bc = b.toLowerCase().toCharArray();
			Arrays.sort(bc);
			b = String.valueOf(bc);
			
			for (int i = 0; i < a.length(); i++) {
				int matchIndex = b.indexOf(a.charAt(i));
				if(matchIndex < 0) {
					return false;
				} else {
					b = new StringBuilder(b).replace(matchIndex, matchIndex+1, "!").toString();
				}
			}
			
			char[] temp = new char[b.length()];
			Arrays.fill(temp, '!');
			String check = String.valueOf(temp);
			
			return b.equals(check);
		}
		
	}
	
	
	
	private static class CheatDemo {
		private static boolean test(String a, String b) {
			char[] ac = a.toLowerCase().toCharArray();
			char[] bc = b.toLowerCase().toCharArray();
			Arrays.sort(ac);
			Arrays.sort(bc);
			return Arrays.equals(ac, bc);
		}
	}
	
	
}
