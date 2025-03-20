package DSA.Bucket5._08_recursion.easy;

//https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1
//https://www.youtube.com/watch?v=hFWckDXE-K8
public class _09_PowerOfNumbers_Imp {

	static int mod = (int) 1e9 + 7;

	public static long power(int n, int r) {

		if (r == 0)
			return 1;

		if ((r & 1) == 0)// if even
			return (power(n, r >> 1) % mod * power(n, r >> 1) % mod) % mod; // r/2
		else
			return (n * power(n, r >> 1) % mod * power(n, r >> 1) % mod) % mod;
	}

	public static void main(String[] args) {

		int n = 12, r = 21;
		// int n = 2, r = 3;

		System.out.println(power(n, r));

	}

}
