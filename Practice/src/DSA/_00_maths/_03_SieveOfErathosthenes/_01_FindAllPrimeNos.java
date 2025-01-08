package DSA._00_maths._03_SieveOfErathosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=g5Fuxn_AvSk

/*Brute force :  TC = O(N * sqrt(N))
 *for(i = 2 -> N) 
 *if(prime(i)) // check if each i is a prime number(sqrt(N)) and for all i -> N. O(N*sqrt(N))
 *sysout(i); */

//
//
//

/*Using SieveOfErathostenes algorithm reduce above TC to O(N * 1) = O(N)
 * i.e, find prime of each number with O(1) and not O(sqrt(N)) */
public class _01_FindAllPrimeNos {

	public static int[] sieveOfEratosthenes(int[] prime, int n) {

		Arrays.fill(prime, 1); // O(N)

		for (int i = 2; i < Math.sqrt(n); i++) {// optimization : no need to go till n. only sqrt(n) suffice as inner
												// loop starts from i*i

			if (prime[i] == 1) { // if i is prime

				// for num 2 below loop runs for n/2 times, for num 3 it runs for n/3 times
				// etc..

				// Hence it runs for (n/2 + n/3 + n/5 + n/7 + ... + n/n). Observe it only runs
				// for prime nums cz if(prime[i] == i)
				// Above computation comes to log(log(n)).

				// It would have been log(n) if this loop would have run for all numbers
				// including non prime. Since it doesn't run for prime, hence it reduces to
				// log(log(n))
				for (int j = i * i; j <= n; j = j + i) // optimization : start from i * i
					prime[j] = 0; // making all multiples of i(prime) as non-prime
			}
		} // N log(log N)
		return prime;
	}

	public static void main(String[] args) {

		int n = 11; // find all prime numbers from 2 -> N
		List<Integer> list = new ArrayList<Integer>();

		// Sieve of Eratosthenes
		// first create prime[] with size n + 1 & initialize with 1
		int[] prime = new int[n + 1];
		prime = sieveOfEratosthenes(prime, n);

		for (int i = 2; i <= n; i++) { // O(N)
			if (prime[i] == 1)
				list.add(i);
		}

		System.out.println(list);
		// total tc : O(N) + O( Nlog(logN) ) + O(N)
		// sc : O(N) for prime array

	}
}