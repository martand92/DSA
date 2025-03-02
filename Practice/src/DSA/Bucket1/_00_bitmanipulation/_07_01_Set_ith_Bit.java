package DSA.Bucket1._00_bitmanipulation;

public class _07_01_Set_ith_Bit {

	public static int set_ith_bit(int n, int i) {
		return (n | (1 << i));
	}

	public static void main(String[] args) {
		int n = 9, i = 2;
		System.out.println(set_ith_bit(n, i));
	}

}
