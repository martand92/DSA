package DSA._01_arrays._01_basic;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
public class _06_ArraySubSetOfAnotherArray_Imp_MultipleApproach {
	public static void main(String[] args) {

//		long[] a1 = { 11, 1, 13, 21, 3, 7 };
//		long[] a2 = { 11, 3, 7, 1 };

		long[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		long[] a2 = { 1, 2, 3, 1 };

		boolean isSubArray = true;

		// Straight forward //O(n)
//		for (int i = 0; i < a1.length; i++)
//			al1.add(a1[i]);
//
//		for (int i = 0; i < a2.length; i++) {
//			if (al1.contains(a2[i]))
//				al1.remove(a2[i]);
//			else {
//				isSubArray = false;
//				break;
//			}
//		}

// 		Using Binary search
//		Arrays.sort(a1);
//
//		for (int i = 0; i < a1.length; i++)
//			al1.add(a1[i]);
//
//		boolean isSubArray = true;
//
//		for (int i = 0; i < a2.length; i++) {
//
//			int l = 0;
//			int r = al1.size() - 1;
//
//			while (l <= r) {
//
//				int mid = l + (r - l) / 2;
//
//				if (a2[i] == al1.get(mid)) {
//					al1.remove(mid);
//					break;
//
//				} else if (a2[i] < al1.get(mid))
//					r = mid - 1;
//				else
//					l = mid + 1;
//			}
//			
//			if(l > r){
//				isSubArray = false;
//				break;
//			}
//
//		}

		// Using HashMap
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();

		for (int i = 0; i < a1.length; i++)
			hm.put(a1[i], hm.getOrDefault(a1[i], 0) + 1);

		for (int i = 0; i < a2.length; i++) {

			if (hm.get(a2[i]) > 0)
				hm.put(a2[i], hm.get(a2[i]) - 1);

			else {
				isSubArray = false;
				break;
			}
		}

		System.out.println(isSubArray);

	}

}
