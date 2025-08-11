package DSA.Bucket2._01_arrays;

//https://www.naukri.com/code360/problems/missing-number_6680467
public class _09_01_FindMissingNum {

	public static int missingNum_BS(int[] arr) {// Only if array was sorted

		int l = 0, r = arr.length - 1, mid = 0;

		while (l <= r) {

			mid = (l + r) / 2;

			if (arr[mid] == mid + 1)
				l = mid + 1;

			else if (arr[mid] == mid + 2)
				r = mid - 1;
		}

		return r + 2;

		// TC : O(log n)
		// SC : O(1)
	}

	public static int missingNum_Brute(int[] arr) {

		for (int i = 1; i <= arr.length; i++) {
			boolean found = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == i) {
					found = true;
					break;
				}
			}

			if (!found)
				return i;
		}
		return -1;
		// TC : O(n * n)
		// SC : O(1)
	}

	public static int missingNum_Better(int[] arr) {

		int[] hash = new int[arr.length + 2];// as array elements start from 1 and also one element is missing

		for (int i = 0; i < arr.length; i++)
			hash[arr[i]] = arr[i];

		for (int i = 1; i < hash.length; i++) {
			if (hash[i] == 0)
				return i;
		}

		return -1;

		// TC : O(n + n)
		// SC : O(n)
	}

	public static int missingNum_Opt(int[] arr) {

		// using XOR -> (XOR of 1 -> n) ^ (XOR of input i.e, 1 -> n with missing num) ->
		// missing num
		int inXOR = 0;
		int entireXOR = 0;

		for (int i = 0; i < arr.length; i++)
			inXOR ^= arr[i];

		for (int i = 1; i <= arr.length + 1; i++) // run it for n elements
			entireXOR ^= i;

		return inXOR ^ entireXOR; // this will return missing num

		// TC : O(n + n). Above 2 for loops can be reduced to 1 for()
		// SC : O(1)
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5 }; // need not be sorted
		System.out.println(missingNum_BS(arr)); // only if given array is sorted
		System.out.println(missingNum_Brute(arr));
		System.out.println(missingNum_Better(arr));
		System.out.println(missingNum_Opt(arr));
	}

}
