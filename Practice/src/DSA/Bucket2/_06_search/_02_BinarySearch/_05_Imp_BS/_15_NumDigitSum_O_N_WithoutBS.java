package DSA.Bucket2._06_search._02_BinarySearch._05_Imp_BS;

//https://practice.geeksforgeeks.org/problems/number-and-the-digit-sum4021/1
public class _15_NumDigitSum_O_N_WithoutBS {

	public static void main(String[] args) {

		int N = 13, K = 2;

		long count = 0;

		for (int i = 10; i <= N; i++) {
			if (i - sumOfDigit(i) >= K)
				count++;
		}
		System.out.println(count);

	}

	public static int sumOfDigit(int digit) {
		int sum = 0;
		String val = String.valueOf(digit);

		for (int i = 0; i < val.length(); i++)
			sum += Integer.parseInt(String.valueOf(val.charAt(i)));

		return sum;
	}

}
