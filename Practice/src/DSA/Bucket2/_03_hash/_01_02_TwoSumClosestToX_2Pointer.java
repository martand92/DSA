package DSA.Bucket2._03_hash;

//https://practice.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/1
public class _01_02_TwoSumClosestToX_2Pointer {

	public static void main(String[] args) {
//		int[] arr = { 10, 22, 28, 29, 30, 40 };
//		int x = 54;

		int[] arr = { 1, 3, 4, 7, 10 };
		int x = 15;

		int i = 0, j = arr.length - 1;
		int diff = 0, mindiff = Integer.MAX_VALUE;
		int res_l = 0, res_r = 0;

		while (i < arr.length && j >= 0 && i < j) {

			diff = Math.abs(x - (arr[i] + arr[j]));

			if (diff < mindiff) {
				res_l = i;
				res_r = j;
				mindiff = diff;
			}

			if (arr[i] + arr[j] < x)
				i++;
			else if (arr[i] + arr[j] > x)
				j--;
			else // if diff of elements = x then those elements are the closest
				break;

		}

		System.out.println(arr[res_l] + "," + arr[res_r]);
	}

}
