package DSA.Bucket5._08_recursion.easy;

public class _15_DecimalToBinary {

	public static String reverseString(String str) {

		if (str.length() == 1)
			return str;

		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static String decimalToBinary(int decimalNumber, String result) {

		if (decimalNumber == 0)
			return result;

		result += decimalNumber % 2;

		return decimalToBinary(decimalNumber / 2, result);
	}

	public static String decimalToBinary_Opt(int n) {

		if (n == 0)
			return "0";

		if (n == 1)
			return "1";

		int rem = n % 2;

		return decimalToBinary_Opt(n / 2) + rem;
	} // TC & SC : O(log n) as it reduces by 2 at every hop

	public static void main(String[] args) {
		int decimalNumber = 16;
		System.out.println(reverseString(decimalToBinary(decimalNumber, "")));
		System.out.println(decimalToBinary_Opt(decimalNumber));
	}
}