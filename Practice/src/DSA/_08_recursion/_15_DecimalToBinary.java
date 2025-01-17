package DSA._08_recursion;

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

	public static void main(String[] args) {
		int decimalNumber = 16;
		System.out.println(reverseString(decimalToBinary(decimalNumber, "")));
	}

}
