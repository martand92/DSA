package DSA.Bucket1._00_maths._02_FactorsOfNumber;

import java.util.ArrayList;

public class _03_02_FindPrimeFactorization {

	public static void main(String[] args) {
		int n = 780;
		// int n = 37;
		// int n = 11;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 2; i < Math.sqrt(n); i++) {

			if (n % i == 0) {

				while (n % i == 0) {
					list.add(i);
					n = n / i;
				}
			}
		}

		if (n != 1)
			list.add(n);

		System.out.println(list);
	}
}