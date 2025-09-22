package DSA.Bucket2._01_arrays;

//https://practice.geeksforgeeks.org/problems/number-and-the-digit-sum4021/1
public class _15_NumDigitSum {

	public static int sumOfDigit(int digit) {
		int sum = 0;
		String val = String.valueOf(digit);

		for (int i = 0; i < val.length(); i++)
			sum += Integer.parseInt(String.valueOf(val.charAt(i)));

		return sum;
	}

	public static void main(String[] args) {

		int N = 13, K = 2;
		long count = 0;

		for (int i = 10; i <= N; i++) {
			if (i - sumOfDigit(i) >= K)
				count++;
		}
		System.out.println(count);
	}
}