package DSA.Bucket1._00_bitmanipulation;

public class _06_IsBitSet {

	public static boolean isBitSet_leftShift(int n, int i) {
		if ((n & (1 << i)) != 0)
			return true;
		else
			return false;
	}

	public static boolean isBitSet_rightShift(int n, int i) {
		if (((n >> i) & 1) == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int n = 13, i = 4;
		System.out.println(isBitSet_leftShift(n, i));
		System.out.println(isBitSet_rightShift(n, i));
	}

}
