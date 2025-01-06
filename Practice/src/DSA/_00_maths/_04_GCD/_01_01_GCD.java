package DSA._00_maths._04_GCD;

public class _01_01_GCD {

	public static void main(String[] args) {
		int n1 = 11, n2 = 13;

		for (int i = Math.min(n1, n2); i > 0; i--) {

			if (n1 % i == 0 && n2 % i == 0) {
				System.out.print("gcd : " + i);
				return;
			}
		}

	}
}