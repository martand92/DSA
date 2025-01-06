package DSA._00_maths._02_NumberOfFactors;

public class _02_01_IsDivisorPrime {

	public static void main(String[] args) {
		int n = 12;
		int count = 0;
		// TC : O(sqrt(N))
		for (int i = 1; i <= Math.sqrt(n); i++) {

			if (i == Math.sqrt(n)) {
				if (n % i == 0)
					count++;
			}
			if (n % i == 0) // when 11 % 1 = 0
				count += 2;

		}

		if (count == 2)
			System.out.print("is Prime");
		else
			System.out.print("is not a Prime");
	}
}