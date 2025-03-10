package DSA.Bucket5._08_recursion;

//https://practice.geeksforgeeks.org/problems/recursive-sequence1611/1
public class _03_RecursiveSeq {

	static int mod = (int) 1e9 + 7, num = 1;

	public static int seq(int count, int mul) {

		if (count == 0)
			return mul;

		mul *= num % mod;
		num++;

		return seq(count - 1, mul);
	}

	public static void main(String[] args) {

		int n = 5, sum = 0;

		for (int i = 1; i <= n; i++)
			sum += seq(i, 1) % mod;

		System.out.println(sum);
	}
}
