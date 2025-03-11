package DSA.Bucket1._00_bitmanipulation;

public class _02_BinaryToDecimal {

	public static int getDecimal(String binary) {
		int sum = 0;
		int pow = 1;

		for (int i = binary.length() - 1; i >= 0; i--) {

			if (binary.charAt(i) == '1')
				sum += pow;

			pow *= 2;
		}

		return sum;
	}

	public static void main(String[] args) {

		String binary = "1101";

		System.out.println(getDecimal(binary));
	}
}