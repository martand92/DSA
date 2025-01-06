package DSA._08_recursion;

//https://practice.geeksforgeeks.org/problems/last-non-zero-digit-in-factorial5846/1
public class _05_FactorialNonZeroDigit {
	static long res = 0;

	public static long factorial(int n) {
		if (n == 1)
			return 1;
		else
			res = n * factorial(n - 1);

		return (res);
	}

	public static double lastZeroDigit(long n) {

		if (n % 10 != 0)
			return (Math.abs(n % 10));
		else
			return lastZeroDigit(n / 10);
	}

	public static void main(String[] args) {

		System.out.print(lastZeroDigit(factorial(4)));
	}
}
