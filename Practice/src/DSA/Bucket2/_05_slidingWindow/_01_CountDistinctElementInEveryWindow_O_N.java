package DSA.Bucket2._05_slidingWindow;

//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
import java.util.*;

//Template
//public int fn(int[] arr) {
//    int left = 0, ans = 0, curr = 0;
//
//    for (int right = 0; right < arr.length; right++) {
//        // do logic here to add arr[right] to curr
//
//        while (WINDOW_CONDITION_BROKEN) { // or if
//            // remove arr[left] from curr
//            left++;
//        }
//
//        // update ans
//    }
//
//    return ans;
//}

public class _01_CountDistinctElementInEveryWindow_O_N {

	public static void main(String[] args) {

//		int[] arr = { 78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27 };
//		int k = 5;

		int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;

		int l = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int r = 0; r < arr.length; r++) {

			hm.put(arr[r], hm.getOrDefault(arr[r], 0) + 1);

			if ((r - l + 1) == k) {

				al.add(hm.size());

				if (hm.get(arr[l]) > 1)
					hm.put(arr[l], hm.get(arr[l]) - 1);
				else
					hm.remove(arr[l]);

				l++;
			}
		}

		System.out.println(al);
	}
}
