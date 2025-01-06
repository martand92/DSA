package DSA._00_bitmanipulation;

public class _07_02_Clear_ith_Bit {

	public static int clear_ith_bit(int n, int i) {

		return (n & ~(1 << i));
	}

	public static void main(String[] args) {
		int n = 13, i = 2;
		System.out.println(clear_ith_bit(n, i));
	}

}
