package DSA._02_strings;

public class _11_RotatingString {

	public static void main(String[] arg) {

		String str1 = "amazon";
		String str2 = "azonam";

		if (str1.substring(2).concat(str1.substring(0, 2)).equals(str2))
			System.out.println("First : " + true);
		
		else if (String.valueOf(str1.charAt(str1.length() - 2)).concat(String.valueOf(str1.charAt(str1.length() - 1))).concat(str1.substring(0, str1.length() - 2)).equals(str2)) {
			System.out.println("Second : " + true);
			
		} else
			System.out.println("None : " + false);
		
		
		//System.out.println(str1.substring(0, str1.length() - 2));

	}

}
