package DSA.Bucket2._02_2Pointers;

import java.util.Arrays;

//https://leetcode.com/problems/valid-triangle-number/description/
//https://www.hellointerview.com/learn/code/two-pointers/valid-triangle-number
//https://medium.com/deluxify/leetcode-611-valid-triangle-number-26fed406c6ef

//Problem : for 3 sides to be valid, sum of 2 sides must be greater than 3rd side 
//Brute force would be to calculate arr[l] + arr[r] and check if its greater than arr[i] with inner loop running O(n^2). Hence total TC : O(n^3) 

//Intuition : When array is sorted, if arr[l] + arr[r] > arr[i] where i is right most and l & r are within i 
//then no need count by doing l++ i.e, if {4,6,9,11,15,18} and 18 > 4+15 then its also greater than 6+15, 9+15, 11+15. All are valid combinations. Directly find count as r-l
//So only need to increase l if arr[l]+arr[r] < arr[i] else decrease r and repeat for all combinations of arr[i]
// then again repeat by decreasing i. Hence O(n^2)

public class _04_ValidTriangleNumber_imp {

	public static void main(String[] args) {

		int[] arr = { 11, 4, 9, 6, 15, 18 };
		int count = 0;

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 2; i--) {

			int l = 0, r = i - 1;

			while (l < r) {

				if ((arr[l] + arr[r]) > arr[i]) {
					count += r - l;
					r--;
				} else if ((arr[l] + arr[r]) <= arr[i])
					l++;

			}
		}

		System.out.println(count);
	}
}