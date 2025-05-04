package DSA.Bucket2._03_hash.Medium;

/* Algo : a + b + c = k -> c = k - (a + b)
 * 
 * As you loop through arr[j], you try to find c in hashset else store current arr[j] as 'c' into hashset  
 */

import java.util.*;

//https://practice.geeksforgeeks.org/problems/three-sum-closest/1
public class _04_01_3Sum_FindTripletsWithGivenSum {

	public static void main(String[] args) {

		int[] arr = { 1, -1, -2, -3, 1 };
		int givenSum = 1;

		for (int i = 0; i < arr.length - 1; i++) {

			HashSet<Integer> hs = new HashSet<Integer>();

			for (int j = i + 1; j < arr.length; j++) {

				if (hs.contains(givenSum - (arr[i] + arr[j]))) {
					System.out.println(arr[i] + "," + arr[j] + "," + (givenSum - (arr[i] + arr[j])));
					return;
				} else
					hs.add(arr[j]);
			}
		}

	}

}
