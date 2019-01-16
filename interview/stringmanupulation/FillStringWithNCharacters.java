package stringmanupulation;

import java.util.Arrays;

public class FillStringWithNCharacters {

	public static void main(String[] args) {
		DemoLong.run(10, '@');
		DemoReplaceNull.run(10, '!');
		DemoReplaceNullChar.run(10, '&');
		DemoUsingArrayFill.run(10, '*');
	}
	
	
	
	private static class DemoReplaceNull{
		static void run(int n, char c) {
			String s = 
					String.valueOf(new char[n]).replaceAll("\0", String.valueOf(c));
			// note "\u0000" will work too.
			System.out.println(s);
		}
	}
	
	private static class DemoReplaceNullChar {
		static void run(int n , char c) {
			String s = 
					String.valueOf(new char[n])
					.replaceAll(Character.toString('\u0000'), Character.toString(c));
			// note '\0' will work too.
			System.out.println(s);
		}
	}
	
	private static class DemoUsingArrayFill {
		static void run(int n, char c) {
			char[] arr = new char[n];
			Arrays.fill(arr, c);
			System.out.println(String.valueOf(arr));
		}
	}
	
	
	
	private static class DemoLong {
		static void run(int n, char c) {
			char[] arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = c;
			}
			System.out.println(String.valueOf(arr));
		}
	}
	
}
