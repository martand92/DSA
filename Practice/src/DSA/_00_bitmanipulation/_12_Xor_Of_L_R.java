package DSA._00_bitmanipulation;

public class _12_Xor_Of_L_R {

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
		int l = 4, r = 8; // find xor of l -> r
		System.out.println(xor(l - 1) ^ xor(r));// xor(l -> r) = xor(1 -> l-1) ^ xor(1 -> r)
	}

}
