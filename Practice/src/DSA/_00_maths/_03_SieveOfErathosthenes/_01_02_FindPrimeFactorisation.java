package DSA._00_maths._03_SieveOfErathosthenes;

import java.util.Arrays;

//spf : smallest prime factor
public class _01_02_FindPrimeFactorisation {

	public static int[] findSPF(int[] spf, int n) {

		for (int i = 2; i * i <= n; i++) { // 2 -> sqrt(N)

			if (spf[i] == i) { // indicates prime[i] is prime

				for (int j = i; i * j <= n; j++) { // i * i -> N
					if (spf[i * j] > i)
						spf[i * j] = i;
				}
			}
		}

		return spf;
	}

	public static void main(String[] args) {
		int n = 780;

		int[] spf = new int[n + 1];

		for (int i = 2; i < spf.length; i++)
			spf[i] = i;// update values of all spf[] with its indices

		spf = findSPF(spf, n);

		System.out.println(Arrays.toString(spf) + "\n");

		System.out.println("Prime factors are : ");
		while (n != 1) {
			System.out.print(spf[n] + ",");
			n = n / spf[n];
		}

	}
}