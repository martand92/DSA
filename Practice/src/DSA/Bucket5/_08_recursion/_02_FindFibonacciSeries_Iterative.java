package DSA.Bucket5._08_recursion;

//https://practice.geeksforgeeks.org/problems/the-nth-fibonnaci3150/1
public class _02_FindFibonacciSeries_Iterative {

	public static void main(String[] args) {

		int n = 7;
		long n1 = 1, n2 = 0, fibonacciNum = 0;

		if (n == 0)
			fibonacciNum = 0;

		if (n == 1)
			fibonacciNum = 1;

		for (int i = 2; i <= n; i++) {
			fibonacciNum = (n1 + n2);
			n2 = n1;
			n1 = fibonacciNum;
		}

		System.out.println(fibonacciNum);
	}
}