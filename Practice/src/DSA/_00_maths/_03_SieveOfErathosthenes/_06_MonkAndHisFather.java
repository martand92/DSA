package DSA._00_maths._03_SieveOfErathosthenes;

public class _06_MonkAndHisFather {

	public static int countSetBits(int n) {
		int count = 0;

		while (n > 0) {
			count++;
			n = n & n - 1;
		}

		return count;
	}

	public static void main(String[] args) {
		int n = 2;
		System.out.println(countSetBits(n));
	}

}
