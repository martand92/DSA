package DSA._08_recursion;

//https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1
//https://www.youtube.com/watch?v=hFWckDXE-K8
public class _02_PowerOfNumbers_Imp {

	static long mod = 1000000007;

	public static long power(int N, int R) {

		if (R == 1)
			return N;

		if (R == 0)
			return 1;

		long val = power(N, R / 2) % mod; // val contains ans for only power(n, r/2). Other r/2 should also be
											// considered.
		val = (val * val) % mod; // hence multiplying final val with itself making power(n, r/2) * power(n, r/2)

		if (R % 2 != 0) // if at every iteration if r is odd, then multiply n with ans and so that r =
						// r-1 & now even
			val = (N * val) % mod;

		return val;
	}

	public static void main(String[] args) {

		int n = 12, r = 21;

		System.out.println(power(n, r));

	}

}
