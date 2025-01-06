package DSA._00_bitmanipulation;

public class _04_Operators {

	public static int and(int n1, int n2) {
		return n1 & n2;
	}

	public static int or(int n1, int n2) {
		return n1 | n2;
	}

	public static int xor(int n1, int n2) {
		return n1 ^ n2;
	}

	public static int leftShift(int n1, int i) {
		return n1 << i;
	}

	public static int rightShift(int n1, int i) {
		return n1 >> i;
	}

	public static int not(int n1) {
		return ~n1;
	}

	public static void main(String[] args) {

		int n1 = 0, n2 = 0, i = 1;

		System.out.println("AND of n1 & n2 = " + and(n1, n2));
		System.out.println("OR  of n1 & n2 = " + or(n1, n2));
		System.out.println("XOR of n1 & n2 = " + xor(n1, n2));
		System.out.println("<<  of n1 by i = " + leftShift(n1, i));
		System.out.println(">>  of n1 by i = " + rightShift(n1, i));
		System.out.println("NOT of n1      = " + not(-6));
	}

}
