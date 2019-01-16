package stringmanupulation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllPermutations {


	public static void main(String[] args) {
		Demo.get("ACCC").forEach(System.out::println);
	}
	 
	
	private static class Demo {
		private static Set<String> set = new HashSet<>();

		private static List<String> get(String data) {
			return get(data, 0);
		}
		
		
		private static List<String> get(String data, int n) {
			String fc = data.substring(n, n+1);
			
			for (int i = n; i < data.length(); i++) {
				String builder = 
						new StringBuilder(data).replace(n, n+1, data.substring(i, i+1))
					.replace(i, i+1, fc).toString();
				set.add(builder);
				if(n < data.length()-1) {
					get(builder, n+1);
				}
			}
			return set.stream().sorted().collect(Collectors.toList());
		}
	}
}
