package DSA._00_maths._02_NumberOfFactors;

public class _01_01_PrintAllDivisors {

	public static void main(String[] args) {
		int n = 36;

		for (int i = 1; i <= Math.sqrt(n); i++) {
			// instead of sqrt() which involves calling another lib function, better to use
			// i*i <= n

			if (i == Math.sqrt(n))
				System.out.print(" " + i + " ");

			else if (n % i == 0)
				System.out.print(" " + i + " " + n / i);

		}
	}
}
