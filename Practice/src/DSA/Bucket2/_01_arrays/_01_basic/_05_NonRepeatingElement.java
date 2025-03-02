package DSA.Bucket2._01_arrays._01_basic;

import java.util.HashMap;
import java.util.Map;

public class _05_NonRepeatingElement {

	public static void main(String[] args) {

		int[] arr = { -1, 2, -1, 3, 2 };
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {

			if (e.getValue() == 1) {
				System.out.println(e.getKey());
				return;
			}
		}

		System.out.println(Integer.MIN_VALUE);
		//TC : O(2n)
	}

}
