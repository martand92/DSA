package DSA._00_bitmanipulation._01_neg_n;

public class _11_MinBitFlips {

	public static int countSetBits(int n) {
		int count = 0;

		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	public static int minBitFlips(int start, int goal) {
		int n = start ^ goal;
		return countSetBits(n);
	}

	public static void main(String[] args) {
		int start = 10, goal = 7;
		System.out.println(minBitFlips(start, goal));
	}

}
