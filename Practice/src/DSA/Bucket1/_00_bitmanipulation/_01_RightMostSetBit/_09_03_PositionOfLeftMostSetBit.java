package DSA.Bucket1._00_bitmanipulation._01_RightMostSetBit;

public class _09_03_PositionOfLeftMostSetBit {

	// Left most set bit is most significant bit
	public static int posOfLeftMostSetBit(int n) {
		int pos = (int) Math.log(n) + 1;
		return pos;
	}

	public static void main(String[] args) {
		int n = 12;
		System.out.println(posOfLeftMostSetBit(n));
	}
}