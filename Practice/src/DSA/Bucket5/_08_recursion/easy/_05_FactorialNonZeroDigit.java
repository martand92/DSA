package DSA.Bucket5._08_recursion.easy;

//https://practice.geeksforgeeks.org/problems/last-non-zero-digit-in-factorial5846/1
public class _05_FactorialNonZeroDigit {
	static long res = 0;

	public static long factorial(long n) {
		if (n == 1)
			return 1;

		return n * factorial(n - 1);

	}

	public static double lastZeroDigit(long n) {

		// first find factorial of given num
		long res = factorial(n);

		// then find the last non zero num from result
		while (res % 10 == 0)
			res /= 10;

		return n % 10;
	}

	public static void main(String[] args) {
		System.out.print(lastZeroDigit(4));
	}
}
