package DSA._01_arrays._01_basic;

import java.util.Arrays;

public class _16_WaveArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int temp = 0;

		for (int i = 0; i < a.length - 1; i = i + 2) {
			temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
		}
		
		System.out.println(Arrays.toString(a));
	}

}
