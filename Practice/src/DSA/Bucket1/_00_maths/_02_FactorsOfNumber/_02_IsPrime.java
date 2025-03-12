package DSA.Bucket1._00_maths._02_FactorsOfNumber;

public class _02_IsPrime {

	public static void main(String[] args) {
		int n = 11;
		int count = 0;
		// TC : O(sqrt(N))
		for (int i = 1; i <= Math.sqrt(n); i++) {

			if (n % i == 0) { // when 11 % 1 = 0
				count++;

				if (n / i != i) // when 11 / 1 != 1, i.e, finding another factor of divisor
					count++;
			}
		}

		if (count == 2)
			System.out.print("is Prime");
		else
			System.out.print("is not a Prime");
	}
}