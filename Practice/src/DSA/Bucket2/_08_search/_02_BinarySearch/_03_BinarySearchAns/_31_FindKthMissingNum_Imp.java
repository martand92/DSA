package DSA.Bucket2._08_search._02_BinarySearch._03_BinarySearchAns;

//https://www.naukri.com/code360/problems/kth-missing-element_893215
//https://www.youtube.com/watch?v=uZ0N_hZpyps

//in leetcode : https://leetcode.com/problems/kth-missing-positive-number/description/ this problem is tagged as Easy cz arr.length<1000,
//so brute force with O(n) will work
public class _31_FindKthMissingNum_Imp {

	public static int findKthMissingNum_BruteForce(int[] arr, int k) {
		int l = 0, count = 0;

		// if num in range 1 -> n is missing then increase counter and once counter
		// reaches k then respond current missing num
		for (int i = 1; i < arr[arr.length - 1]; i++) {

			if (i < arr[l])
				count++;
			else
				l++;

			if (count == k)
				return i;
		}

		return -1;
	} // O(N)

	// Algo : for every given num, find number of missing numbers.
	// i.e, for arr[0] = 2, no of missing num = 1, which is 1
	// for arr[1] = 3, no of missing nums = 1, which is 1
	// for arr[2] = 4, no of missing nums = 1, which is 1
	// for arr[3] = 7, no of missing nums = 3, which is 1,5,6
	// for arr[4] = 11, no of missing nums = 6, which is 1,5,6,8,9,10
	// Hence formula to find missing num at ith position = (arr[i] - (i+1))

	// Now need to find between which 2 nums kth missing num is present. so of all
	// missing nums from 1 -> 6, 5th missing num is present between 3rd and 6th or
	// between arr[3]=7 and arr[4]=11.

	// Then till arr[3]=7, we see 3 missing nums but we need 5th missing num. Hence
	// missing num will be arr[3] + (required missing num which is k - missing num
	// till arr[3] which is 3)

	// Hence arr[3] + (5 - 3) = 7 + 2 = 9
	public static int findKthMissingNum_BS(int[] arr, int k) {

		// need to BS on indices to find 2 nums in arr between which missing num is
		// present
		int l = 0, r = arr.length - 1, mid = 0;

		while (l <= r) {

			mid = (l + r) / 2;

			// missing number at mid index will be its arr value - (its index + 1)
			int missingNumTillMidIndex = arr[mid] - (mid + 1);

			// if requested missing element is greater than currently found missing element
			// then move right else left
			if (k > missingNumTillMidIndex)
				l = mid + 1;
			else
				r = mid - 1;
		}

		// eventually r and l will cross over on missing element and r will be on the
		// lower val through which missing element can be derived
		// missing element -> arr[r] + (required missing element's pos - nums missing
		// till rth index
		// int finalMissingElement = arr[r] + (k - (arr[r] - (r + 1)));

		// But above arr[r] might not always work because r might be < 0. Ex: find 3rd
		// missing element where arr= {4,5,6}
		// Here r will cross over 0th index to -1 as 3rd missing element = 3 which is
		// less than 4

		// so above derived formula arr[r] + (k - (arr[r] - (r + 1)) can be re-written
		// as arr[r] + k - arr[r] + r + 1 -> k + r + 1

		// hence finalMissing element can also be found using k + r + 1

		int finalMissingElement = k + r + 1;
		return finalMissingElement;

	} // O(log n)

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 7, 11 };
		int k = 5;
		// System.out.println(findKthMissingNum_BruteForce(arr, k));
		System.out.println(findKthMissingNum_BS(arr, k));

	}

}
