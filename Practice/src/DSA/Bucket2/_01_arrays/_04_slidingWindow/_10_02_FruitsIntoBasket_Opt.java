package DSA.Bucket2._01_arrays._04_slidingWindow;

import java.util.*;

//https://www.youtube.com/watch?v=e3bs0uA1NhQ
//https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
public class _10_02_FruitsIntoBasket_Opt {

	public static int maxFruits(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int l = 0, maxFruits = 0;

		for (int r = 0; r < arr.length; r++) { // O(N)

			hm.put(arr[r], hm.getOrDefault(arr[r], 0) + 1);

			// O(1)
			if (hm.size() == 3) { // if hm size is 3, then do reduce window size to curr max by l++ and move both
									// l++ & r++ together till larger window size is seen

				hm.put(arr[l], hm.get(arr[l]) - 1);

				if (hm.get(arr[l]) == 0)// when specific type of fruit goes out of window then remove this fruits from
										// basket/hm
					hm.remove(arr[l]);

				l++;
			}

			maxFruits = Math.max(maxFruits, r - l + 1); // consecutive max fruits considered
		}

		return maxFruits;

	}

	public static void main(String[] args) {
		int[] arr = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		System.out.println(maxFruits(arr));
	}

}
//TC: O(N) // by replacing inner while loop with if and maintaining window size when window condition is not met
//SC : O(3) as hm stores at max 3 fruits and then start removing fruits from map till map size becomes 2