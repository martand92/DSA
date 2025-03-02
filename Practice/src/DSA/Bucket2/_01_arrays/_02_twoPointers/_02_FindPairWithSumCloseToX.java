package DSA.Bucket2._01_arrays._02_twoPointers;

//https://practice.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/1
public class _02_FindPairWithSumCloseToX {

	public static void main(String[] args) {
//		int[] arr = { 10, 22, 28, 29, 30, 40 };
//		int x = 54;

		int[] arr = { 1, 3, 4, 7, 10 };
		int x = 15;

		int i = 0;
		int j = arr.length - 1;
		int min = Integer.MAX_VALUE;
		int res_l = 0, res_r = 0, sum = 0;

		while (i < arr.length && j >= 0 && i < j) {

			sum = arr[i] + arr[j];

			if (Math.abs(sum - x) < min) {
				res_l = i;
				res_r = j;
				min = Math.abs(sum - x);
			}

			if (sum < x)
				i++;
			else if (sum > x)
				j--;
			
			else // if diff of elements = x then those elements are the closest
				break;

		}

		System.out.println(arr[res_l] + "," + arr[res_r]);
	}

}
