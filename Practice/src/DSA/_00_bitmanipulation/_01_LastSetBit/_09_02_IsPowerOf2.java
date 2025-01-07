package DSA._00_bitmanipulation._01_LastSetBit;

public class _09_02_IsPowerOf2 {

	public static boolean isPowerOf2(int n) {
		if ((n & (n - 1)) == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int n = 15;
		System.out.println(isPowerOf2(n));
	}

}
