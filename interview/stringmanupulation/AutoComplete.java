package stringmanupulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutoComplete {

	public static void main(String[] args) {
		Demo.run("ab").stream().forEach(System.out::println);
	}
	
	private static class Demo {
		private static String[] dict = {"abc", "acd", "bcd", "def", "a", "aba"};
		
		private static List<String> run(String str) {
			List<String> list  = new ArrayList<String>();
			
			for (int i = 0; i < dict.length; i++) {
				if(dict[i].length() >= str.length() 
						&& dict[i].substring(0, str.length()).equals(str)) {
					list.add(dict[i]);
				}
			}
			return list.stream().sorted().collect(Collectors.toList());
		}
	}
}
