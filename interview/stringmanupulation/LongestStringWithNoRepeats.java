package stringmanupulation;

import java.util.Arrays;


/**
 * find the longest substring from a string which has no repeated chars
 * @author AJ
 *
 */
public class LongestStringWithNoRepeats {

	public static void main(String[] args) {
		String s = "animal";
		String s2 = "abcdefghigdlkh";
		System.out.println(
				LongestString.getTheString(s2)
				);
		
		
	}
	
	public static void main2(String[] args) {
		System.out.println(
				LongestString.containsRepeatedChars("animal")
				);
	}
	
	
	
	
	
	private static class LongestString {
		private static final boolean DO_LOG = false;
		private static final void log(String log) {
			if(DO_LOG) {
				System.out.println(log);
			}
		}
		
		private static String finalSubStr = "";
		
		
		private static final String getTheString(String data) {
			String currentSubString = data;
			for (int i = 0; 
						(i < data.length() 
						&& currentSubString.length() > finalSubStr.length()); 
						i++) {
				log("i is : " + i);
				for (int j = i+1; j < data.length(); j++) {
					currentSubString = data.substring(i, j+1);
					log(currentSubString);
					
					boolean check = containsRepeatedChars(currentSubString);
					
					if(check) {
						checkAndStoreString(currentSubString.substring(0, currentSubString.length()-1));
						break;
					}
					
					if(j == data.length()-1) {
						checkAndStoreString(currentSubString);
						break;
					}
					
				}
			}
			
			return finalSubStr == "" ? null : finalSubStr;
		}
		
		
		private static final boolean containsRepeatedChars(String data) {
			char[] c = data.toCharArray();
			Arrays.sort(c);
			for (int i = 0; i < c.length-1; i++) {
				if(c[i] == c[i+1]) {
					log("repeat found");
					return true;
				}
			}
			return false;
		}
		
		
		private static final void checkAndStoreString(String data) {
			if(data.length() > finalSubStr.length()) {
				log("passed value: "+ data +" is longer than current: "+ finalSubStr);
				finalSubStr = data;
			} else {
				log("passed value: "+ data +" is shorter than current: "+ finalSubStr);
			}
			log("new final value: " + finalSubStr);
		}
		
		
	}
	
}
