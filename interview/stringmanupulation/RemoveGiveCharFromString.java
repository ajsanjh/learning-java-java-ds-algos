package stringmanupulation;

public class RemoveGiveCharFromString {

	public static void main(String[] args) {
		System.out.println(
				Demo.run("ajay virdi is great", 'i')
				);
	}
	
	
	private static final class Demo {
		
		private static final String run(String data, char c) {
			String temp = "";
			for (int i = 0; i < data.length(); i++) {
				if(data.charAt(i) == c) {
					continue;
				} else {
					temp += String.valueOf(data.charAt(i));
				}
			}
			return temp;
		}
		
	}
}
