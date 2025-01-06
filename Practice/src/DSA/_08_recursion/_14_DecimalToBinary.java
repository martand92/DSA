package DSA._08_recursion;

public class _14_DecimalToBinary {

	public static void main(String[] args) {
		int decimalNumber = 16;

		System.out.println(decimalToBinary(decimalNumber, ""));
	}

	public static String decimalToBinary(int decimalNumber, String result) {

		if (decimalNumber == 0)
			return result;

		result += decimalNumber % 2;

		return decimalToBinary(decimalNumber / 2, result);
	}

}
