package DSA._00_bitmanipulation;

public class _08_Toggle_ith_Bit {

	public static int toggle_ith_bit(int n, int i) {
		return (n ^ (1 << i));
	}

	public static void main(String[] args) {
		int n = 13, i = 2;
		System.out.println(toggle_ith_bit(n, i));
	}

}
