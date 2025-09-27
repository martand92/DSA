package DSA.Bucket2._01_arrays;

import java.util.HashMap;
import java.util.Map;

public class _05_NonRepeatingElement {

	public static int nonRepeatingEle(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {

			if (e.getValue() == 1)
				return e.getKey();
		}

		return Integer.MIN_VALUE;

	}// TC : O(2n)

	public static int nonRepeatingEle_Opt(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++)
			num ^= arr[i];

		return num;
	}// TC : O(n)

	public static void main(String[] args) {

		int[] arr = { -1, 2, -1, 3, 2 };

		System.out.println(nonRepeatingEle(arr));
		System.out.println(nonRepeatingEle_Opt(arr));

	}
}