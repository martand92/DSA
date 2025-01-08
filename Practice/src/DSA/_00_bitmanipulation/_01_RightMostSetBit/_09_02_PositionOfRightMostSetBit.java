package DSA._00_bitmanipulation._01_RightMostSetBit;

public class _09_02_PositionOfRightMostSetBit {

	public static int posOfRightMostSetBit(int n) {
		//first narrow down to a number thats set 
		int num = (n & (n - 1)) ^ n; 
		return Integer.numberOfTrailingZeros(num);// This returns the position of the rightmost set bit by counting the
													// number of trailing zeros in the binary representation
	}

	public static void main(String[] args) {
		int n = 12;
		System.out.println(posOfRightMostSetBit(n));
	}

}
