package DSA.Bucket2._06_search._02_BinarySearch._05_Imp_BS;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
//https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x2041/1
public class _08_01_FirstLastOccurencesOfX_N_Imp {

	public static void main(String[] args) {
//		int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
//		int x = 5;

//		int[] arr = { 2, 3, 4 };
//		int x = 4;

		int[] arr = { 1, 1, 3, 4, 4, 5, 5 };
		int x = 1;

//		int[] arr = { 8 };
//		int x = 0;

		int l = 0, r = arr.length - 1;
		ArrayList<Long> al = new ArrayList<Long>();

//
//
//
//
//		Not so optimized solution and not working for all TC
//		int mid = -1;				
//		int i = 0;
//
//		while (l <= r) {
//
//			mid = l + ((r - l) / 2);
//
//			if (x == arr[mid])
//				break;
//			else if (x < arr[mid])
//				r = mid - 1;
//			else
//				l = mid + 1;
//		}
//
//		if (mid == -1) {
//			al.add(Long.valueOf(-1));
//			al.add(Long.valueOf(-1));
//
//		} else {
//
//			i = mid;
//			while (i >= 0) {
//				if (arr[i] == x)
//					i--;
//				else
//					break;
//			}
//			al.add(Long.valueOf(i + 1));
//
//			i = mid;
//			while (i < arr.length) {
//				if (arr[i] == x)
//					i++;
//				else
//					break;
//			}
//
//			al.add(Long.valueOf(i - 1));
//		}

//
//
//		
//
//
// 2 pointer
//		while (l <= r) {
//
//			if (arr[l] == x && arr[r] == x) {
//				al.add(Long.valueOf(l));
//				al.add(Long.valueOf(r));
//				break;
//			} else {
//				if (arr[l] != x)
//					l++;
//				if (arr[r] != x)
//					r--;
//			}
//		}
//
//		if (l > r) {
//			al.add(Long.valueOf(-1));
//			al.add(Long.valueOf(-1));
//		}
//
//		System.out.println(al);

//
//		
//		
//		
//		
// Optimized : trying to find solution through Binary search
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;

			if (x == arr[mid])
				break;
			else if (x < arr[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}

		if (l > r) {

			al.add(Long.valueOf(-1));
			al.add(Long.valueOf(-1));

		} else if (l == r) {

			al.add(Long.valueOf(l));
			al.add(Long.valueOf(r));

		} else {// once element is searched using binary search, use 2 pointer to move left and
				// right simultaneously to find window where same elements are present

			l = mid;
			r = mid;

			while (arr[l] == arr[mid] || arr[r] == arr[mid]) {

				if (arr[l] == arr[mid])
					l--;

				if (arr[r] == arr[mid])
					r++;

				if (l < 0 || r > arr.length - 1)
					break;
			}

			al.add(Long.valueOf(l + 1));
			al.add(Long.valueOf(r - 1));

		}

		System.out.println(al);

	}

}
