package stringmanupulation;


/**
 * String or phrases that spell same forward and backward
 * @author AJ
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(Demo.isPalindrome("abc cba"));
		System.out.println(CheatDemo.test("abc cba"));
		System.out.println(AnotherDemo.test("abdb a"));
	}
	
	
	private static class Demo {
		
		
		private static final boolean isPalindrome(String data) {
			return data.replaceAll(" ","").equals(prepareAndReverse(data));
		}
		
		private static final String prepareAndReverse(String data) {
			String temp = "";
			data = data.replaceAll(" ", "");
			for (int i = data.length()-1; i >=0; i--) {
				temp += String.valueOf(data.charAt(i));
			}
			return temp;
		}
	}
	
	
	
	private static class CheatDemo {
		private static final boolean test(String data) {
			return new StringBuilder(data.replaceAll(" ", "")).reverse().toString()
					.equals(data.replaceAll(" ", ""));
		}
	}
	
	
	/**
	 * least amount of complexity.
	 * @author AJ
	 *
	 */
	private static class AnotherDemo {
		private static final boolean test(String data) {
			data = data.replaceAll(" ", "");
			
			for (int i = 0, j = data.length()-1; i < data.length()/2; i++, j--) {
				if(data.charAt(i) != data.charAt(j))
					return false;
			}
			return true;
		}
	}
	
}
