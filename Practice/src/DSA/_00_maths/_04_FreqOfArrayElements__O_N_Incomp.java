package DSA._00_maths;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1
public class _04_FreqOfArrayElements__O_N_Incomp {

	public static void main(String[] args) {

		int[] arr = { 3, 3, 3, 3 };

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		for (int i = 0; i < arr.length; i++) {

			if (hm.containsKey(i + 1))
				arr[i] = hm.get(i + 1);
			else
				arr[i] = 0;
		}

		System.out.println(Arrays.toString(arr));
	}
}
