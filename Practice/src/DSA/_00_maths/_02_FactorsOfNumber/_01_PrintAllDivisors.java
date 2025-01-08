package DSA._00_maths._02_FactorsOfNumber;

public class _01_PrintAllDivisors {

	public static void main(String[] args) {
		int n = 36;

		for (int i = 1; i <= Math.sqrt(n); i++) {

			if (n % i == 0) {
				System.out.print(i + " ");
				if (n / i != i) // to avoid duplicate divisors ex: n=36, i=6
					System.out.print(n / i + " ");
			}

		}
	}
}
