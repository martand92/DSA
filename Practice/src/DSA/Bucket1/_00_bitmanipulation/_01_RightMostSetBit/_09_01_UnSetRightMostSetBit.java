package DSA.Bucket1._00_bitmanipulation._01_RightMostSetBit;

public class _09_01_UnSetRightMostSetBit {

	public static int unsetBit(int n) {
		return (n & (n - 1));
	}

	public static void main(String[] args) {
		int n = 13;
		System.out.println(unsetBit(n));
	}

}
