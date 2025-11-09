package DSA.Bucket3._04_recursion.easy;

//https://practice.geeksforgeeks.org/problems/recursive-sequence1611/1
public class _03_RecursiveSeq {

	static int mod = (int) 1e9 + 7;

	public static int seq(int n, int counter, int num, int sum) {

		if (n < 0)
			return sum;

		int mul = 1;
		for (int i = 0; i < counter; i++) {
			mul = (mul * num) % mod;
			num++;
		}

		sum = (sum + mul) % mod;
		return seq(n - 1, counter + 1, num, sum % mod) % mod;
	}

	public static void main(String[] args) {
		int n = 7;
		System.out.println(seq(n - 1, 1, 1, 0));
	}
}
