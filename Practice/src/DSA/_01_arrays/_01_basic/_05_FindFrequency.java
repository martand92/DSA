package DSA._01_arrays._01_basic;

public class _05_FindFrequency {

	public static void main(String[] arg) {
		int[] arr = { 1, 2, 1, 1, 4, 1 };
		int x = 1; // given number whose freq need to be identified
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				count++;
		}

		System.out.println(count);
	}

}
