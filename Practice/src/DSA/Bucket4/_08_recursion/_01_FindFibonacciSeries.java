package DSA.Bucket4._08_recursion;

//https://youtu.be/IJDJ0kBx2LM?t=2951
public class _01_FindFibonacciSeries {

	public static int fibonacci(int n) {

		if (n == 0)
			return 0;

		if (n == 1)
			return 1;

		return fibonacci(n - 1) + fibonacci(n - 2);

	}

	public static void main(String[] args) {

		// Calculate fibonacci of n
		int n = 5;
		System.out.print(fibonacci(n) + " ");
	}
}
