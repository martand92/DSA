package DSA.Bucket2._01_arrays._03_hash;

import java.util.Arrays;
import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1
public class _08_FreqOfArrayElements_NonOptimised {

	public static void main(String[] args) {

		// int[] arr = { 3, 3, 3, 3 };
		int[] arr = { 2, 3, 2, 3, 5 };

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		for (int i = 1; i <= arr.length; i++) {
			
			if (hm.get(i) != null)
				arr[i - 1] = hm.get(i);
			else
				arr[i - 1] = 0;
		}

		System.out.println(Arrays.toString(arr));

	}
}
