package DSA.Bucket1._00_bitmanipulation;

public class _12_Xor_Of_1_N {

	public static int xor(int n) {
		
		if (n % 4 == 1)
			return 1;
		else if (n % 4 == 2)
			return n + 1;
		else if (n % 4 == 3)
			return 0;
		else
			return n;

	}

	public static void main(String[] args) {
		int n = 11;
		System.out.println(xor(n));
	}

}
