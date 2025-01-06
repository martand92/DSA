package DSA._02_strings;

//https://practice.geeksforgeeks.org/problems/find-equal-point-in-string-of-brackets2542/1
public class _12_NumberOfOpeningAndClosingBraces {

	public static void main(String[] args) {
		String str = "(()";
		char[] strArr = str.toCharArray();
		long index = 0;
		
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] == ')')
				index++;
		}
		System.out.println(index);
	}

}
