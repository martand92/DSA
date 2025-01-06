package DSA._00_maths._03_SieveOfErathosthenes;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.youtube.com/watch?v=Dg5D-k1rUgY
//https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/hacker-with-prime-bebe28ac/
public class _05_DecryptMessages_Untested {

	public static boolean isPrime(int n) {
		int count = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				count++;
				if (n / i != i)
					count++;
			}
		}

		if (count == 2)
			return true;

		return false;
	}

	public static int[] precomputeSPF(int[] messages) {

		int largestMessage = -1;
		for (int i = 0; i < messages.length; i++)
			largestMessage = Math.max(largestMessage, messages[i]);

		int[] spf = new int[largestMessage + 1];
		for (int i = 2; i <= largestMessage; i++)
			spf[i] = i;

		for (int i = 2; i * i <= largestMessage; i++) {
			if (spf[i] == i) {
				for (int j = i * i; j <= largestMessage; j += i) {
					spf[j] = i;
				}
			}
		}

		return spf;
	}

	public static ArrayList<Integer> findSPF(int message, int[] spf) {

		ArrayList<Integer> al = new ArrayList<Integer>();

		while (message > 1) {
			al.add(spf[message]);
			message = message / spf[message];
		}

		return al;
	}

	public static boolean[] isMessageMulOfPrimes(int[] arr, int[] messages) {

		boolean[] ans = new boolean[messages.length];

		// As the largest num in int has max prime factors from 2 -> 19 i.e, 2*3*5*..*19
		// below array holds primes that are seen in original arr[]
		int[] hash = new int[19];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 20 && isPrime(arr[i])) {
				hash[arr[i]] = 1;
			}
		}

		// Precompute spf of largest message in a query
		int[] spf = precomputeSPF(messages);

		// Now find spf of a give message in messages[]
		ArrayList<Integer>[] spfArr = new ArrayList[messages.length];
		for (int i = 0; i < messages.length; i++)
			spfArr[i] = findSPF(messages[i], spf);

		// check if each prime from spfArr list is in original arr(hash)
		// if present then remove it from spfArr list and if length = 2,
		// then this message or its towned down can be created using 2 primes
		for (int i = 0; i < spfArr.length; i++) {
			for (int j = 0; j < spfArr[i].size(); j++) {
				if (hash[spfArr[i].get(j)] == 1) {
					spfArr[i].remove(j);
				}

				if (spfArr[i].size() == 2) {
					ans[i] = true;
					break;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 22, 7, 10 };
		int[] messages = { 16, 429, 42 };

		System.out.println(Arrays.toString(isMessageMulOfPrimes(arr, messages)));

	}

}
