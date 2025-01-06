package DSA._01_arrays._04_slidingWindow;

import java.util.*;

//https://www.youtube.com/watch?v=e3bs0uA1NhQ
//https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
public class _10_01_FruitsIntoBasket {

	public static int maxFruits(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int l = 0, maxFruits = 0;

		for (int r = 0; r < arr.length; r++) { // O(N)

			// O(1) because as at max only 3 elements will be present in hashmap, so
			// operations on hm will all be O(1) as there won't be any collisions
			hm.put(arr[r], hm.getOrDefault(arr[r], 0) + 1);// add types of fruits to 2 baskets indicated by hm

			// O(N), l will move all way to right
			while (hm.size() == 3) { // if third type of fruit is found then need to remove first type of fruit till
										// we have only 2 types

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
//TC: O(N + N)
//SC : O(3) as hm stores at max 3 fruits and then start removing fruits from map till map size becomes 2