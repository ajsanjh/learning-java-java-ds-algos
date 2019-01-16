package stringmanupulation;

import java.util.*;

public class PullNumbersFromString {

	public static void main(String[] args) {
		System.out.println(Demo.run("AB10CD20EF30"));
		
	}



	/**
	 * 
	 * @author AJ
	 *
	 */
	private static class Demo {
		private static final boolean DO_LOG = true;
		private static final void log(String log) {
			if(DO_LOG)
				System.out.println(log);
		}

		private static final List<Integer> run(String data) {
			List<Integer> theList  = new ArrayList<>();
			
			String cNum = "";
			for (int i = 0; i < data.length(); i++) {
				if(!isADigit(data, i)) {
					if(!cNum.isEmpty()) {
						theList.add(Integer.valueOf(cNum));
						cNum = "";
					}
				} else {
					cNum += String.valueOf(data.charAt(i));
				}
			}
			if(!cNum.isEmpty())
				theList.add(Integer.valueOf(cNum));
			
			return theList;
		}

		private static final boolean isADigit(String data, int i) {
			boolean isNum = (48 <= data.charAt(i) && data.charAt(i) <= 57);
			log("Checking '" + data +"' at index: " + i +" is num? " + isNum);
			return isNum;
		}
	}
}
