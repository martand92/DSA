package DSA.Bucket1._00_bitmanipulation;

public class _01_DecimalToBinary {

	public static String reverseString(String res) {

		if (res.length() == 1)
			return res;

		return reverseString(res.substring(1)) + res.charAt(0);
	}

	public static String getBinary(int n) {
		String res = "";

		while (n != 1) {

			res += n % 2;
			n = n / 2;
		}

		return reverseString(res + '1');
	}

	public static void main(String[] args) {

		int n = 13;

		System.out.println(getBinary(n));
	}

}
