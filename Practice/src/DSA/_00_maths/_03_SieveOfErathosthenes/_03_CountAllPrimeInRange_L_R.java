package DSA._00_maths._03_SieveOfErathosthenes;

import java.util.Arrays;

//https://www.youtube.com/watch?v=os82DjD2-MA
public class _03_CountAllPrimeInRange_L_R {

	public static int[] sieveOfEratosthenes(int n) {
		int[] prime = new int[n + 1];
		Arrays.fill(prime, 2, prime.length, 1);
		for (int i = 2; i < Math.sqrt(n); i++) {

			if (prime[i] == 1) {

				for (int j = i * i; j <= n; j = j + i)
					prime[j] = 0;
			}
		}
		return prime;
	}

	public static void main(String[] args) {

		int l = 3, r = 11; // count all prime numbers from 3 -> 11

		int[] prime = sieveOfEratosthenes(r); // O( Nlog(logN) )

		// Now instead of counting number of primes from L to R through looping,
		// maintain prefix sum by looping only once.
		// below prefix sum reduces count of prime from O(N) to O(1) if there are
		// multiple queries for L & R
		for (int i = 3; i < prime.length; i++)
			prime[i] = prime[i] + prime[i - 1];

		System.out.println("Prime numbers between L & R : " + (prime[r] - prime[l - 1])); // O(1)

		// total tc : O( Nlog(logN) ) + O(N)
		// sc : O(N) for prime array

	}
}