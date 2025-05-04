package DSA.Bucket2._01_arrays._02_twoPointers;

//https://practice.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1
public class _01_PairSumClosestToX {

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
		int diff = 0, mindiff = Integer.MAX_VALUE;

		while (i < arr.length && j >= 0) {

			diff = Math.abs(x - (arr[i] + arr[j]));

			if (diff < mindiff) {
				mindiff = diff;
				res_l = i;
				res_r = j;
			}

			if (arr[i] + brr[j] == x) {// if diff of elements = x then those elements are the closest
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
