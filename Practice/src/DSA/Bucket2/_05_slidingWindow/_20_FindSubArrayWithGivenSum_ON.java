package DSA.Bucket2._05_slidingWindow;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class _20_FindSubArrayWithGivenSum_ON {
	public static void main(String[] args) {
//		 int[] arr = { 1, 2, -3, 4 }; // another tricky test data {8}
//		 int s = 3;

//		int[] arr = { 1, 2, 3, 7, 5 };
//		int s = 12;

//		int[] arr = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
//				154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
//		int s = 468;

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int s = 15;

		int l = 0, r = 0, windowSum = 0;

		for (r = 0; r < arr.length; r++) {

			windowSum += arr[r];

			while (windowSum > s) {
				windowSum -= arr[l];
				l++;
			}

			if (windowSum == s) {
				System.out.println((l + 1) + "," + (r + 1));
				return;
			}

		}

		System.out.println(-1);

	}
}
