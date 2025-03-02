package DSA.Bucket4._10_dynamicprogramming._01_Fibonacci;

public class _01_03_Fibonacci_SpaceOpt {

	public static int findFibonacci(int n) {

		int prev1 = 1;// n-1
		int prev2 = 0;// n-2
		int sum = 0;

		for (int i = 2; i <= n; i++) {
			sum = prev1 + prev2;// f(n-1) + f(n-2)
			prev2 = prev1;
			prev1 = sum;
		}
		return sum;

	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(findFibonacci(n));
	}

}
