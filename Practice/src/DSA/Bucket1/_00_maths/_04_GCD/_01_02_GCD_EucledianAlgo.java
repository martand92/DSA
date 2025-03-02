package DSA.Bucket1._00_maths._04_GCD;

public class _01_02_GCD_EucledianAlgo {

	public static void main(String[] args) {

		int n1 = 15, n2 = 5;

		while (n1 > 0 && n2 > 0) {

			if (n1 > n2)
				n1 = n1 % n2;
			else
				n2 = n2 % n1;
		}

		if (n1 == 0)
			System.out.print("gcd : " + n2);
		else
			System.out.print("gcd : " + n1);

	}
}