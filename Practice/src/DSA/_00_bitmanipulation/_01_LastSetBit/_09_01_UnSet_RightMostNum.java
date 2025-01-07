package DSA._00_bitmanipulation._01_LastSetBit;

public class _09_01_UnSet_RightMostNum {

	public static int unsetBit(int n) {
		return (n & (n - 1));
	}

	public static void main(String[] args) {
		int n = 13;
		System.out.println(unsetBit(n));
	}

}
