package DSA._01_arrays._02_twoPointers;

//https://practice.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1
public class _01_FindClosestPairFromTwoSortedArr {

	public static void main(String[] args) {
//		int[] arr = { 1, 4, 5, 7 };
//		int[] brr = { 10, 20, 30, 40 };
//		// int x = 32;
//		int x = 50;

		int[] arr = { 1, 3, 3, 4, 4, 5, 6, 8, 10, 10 };
		int[] brr = { 4, 6, 8 };
		int x = 10;

		int i = 0, j = brr.length - 1;
		int res_l = 0, res_r = 0;
		int min = Integer.MAX_VALUE;
		int cal = 0;

		while (i < arr.length && j >= 0) {
			cal = Math.abs(arr[i] + brr[j] - x);

			if (cal < min) {
				min = cal;
				res_l = i;
				res_r = j;
			}

			if (arr[i] + brr[j] == x) {
				res_l = i;
				res_r = j;
				break;

			} else if (arr[i] + brr[j] < x)
				i++;

			else
				j--;

		}

		System.out.println(arr[res_l] + "," + brr[res_r]);

	}

}
