package DSA._00_maths._02_NumberOfFactors;

public class _01_02_PrintAllDivisors {

	public static void main(String[] args) {
		int n = 36;

		for (int i = 1; i <= Math.sqrt(n); i++) {

			if (n % i == 0) {
				System.out.print(i + " ");
				if (n / i != i)
					System.out.print(n / i + " ");
			}

		}
	}
}
