package DSA.Bucket1._00_maths;

//Why cant we use inbuilt Math.pow? -> this provides output in double data type which is prone to precision error
public class _06_FindPower {

	static int m = (int) 1e9;

	// Method 1 : to recursively find power of larger exponent
	public static int findPower_recursive(int a, int b) {

		if (b == 1)
			return a;

		if ((b & 1) != 0) // if odd
			return ((a * findPower_recursive(a, b / 2) % m) * (findPower_recursive(a, b / 2) % m)) % m;

		else
			return ((findPower_recursive(a, b / 2) % m) * (findPower_recursive(a, b / 2) % m)) % m;

	}// Issue : if a power b increase beyond 1e9 then overflow

	// Method 2 : Treating exponent as binary.
	/*
	 * Algo : Look at power(b) in its binary form. If last bit is set, then consider
	 * a into the result. Then for every iteration increase a by itself i.e, a * a
	 * as we move left of binary representation of power Continue to check last bit
	 * of binary num
	 */

	public static int findPower_iterative(int a, int b) {

		int res = 1;

		while (b > 0) {

			if ((b & 1) != 0) // if last bit is set
				res = (res * a) % m;

			a = (a * a) % m;

			b >>= 1; // right shift b by 1 to check if last bit is set and continue loop till b=0
		}

		return res;
	}
	
	

	public static void main(String[] args) {
		
		//both recursive and iterative will only work till 1e9 and overflows
		System.out.println(findPower_recursive(2, 31)); //overflows at 2^31
		System.out.println(findPower_iterative(2, 31)); //overflows at 2^31
		
		
	}

}
