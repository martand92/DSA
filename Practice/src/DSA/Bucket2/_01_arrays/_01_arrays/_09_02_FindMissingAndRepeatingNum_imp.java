package DSA.Bucket2._01_arrays._01_arrays;

//https://www.naukri.com/code360/problems/missing-and-repeating-numbers_6828164
//https://www.youtube.com/watch?v=2D0D8HE6uak
public class _09_02_FindMissingAndRepeatingNum_imp {

	public static void missingandRepeatingNum_Opt(int[] arr) {

		// Step 1 : ^ all arr elements results in canceling out unique elements. Then ^
		// of this result with all elements 1-> n results in missing and repeating num's
		// ^
		int xor = 0;

		for (int i = 0; i < arr.length; i++) // O(n)
			xor ^= arr[i];

		for (int i = 1; i <= arr.length; i++) // O(n)
			xor ^= i; // Now this resulted xor will be xor of repeated num and missing num

		// Step 2 : Now need to identify these 2 nums.
		// From resulted xor, identify bit's pos thats differing bit. Now create 2
		// buckets, 1 to house elements that are set at this bit pos and another to
		// house elements that are unset at this pos

		// same logic:
		// DSA._00_bitmanipulation._02_FindSingleNumber._15_FindSingleNum_2_DistinctElements

		// having this differing bit as the only set bit to find its pos to segrate all
		// elements to respective buckets
		int differingBit = xor & (xor - 1) ^ xor;

		int setBitBucket = 0;
		int unsetBitBucket = 0;

		for (int i = 0; i < arr.length; i++) { // O(n)

			if ((arr[i] & differingBit) != 0) // meaning arr[i]'s diff bit is set, hence goes to resp bucket
				setBitBucket ^= arr[i];

			else
				unsetBitBucket ^= arr[i];
		}

		for (int i = 1; i <= arr.length; i++) { // O(n)

			if ((i & differingBit) != 0)
				setBitBucket ^= i;
			else
				unsetBitBucket ^= i;
		}

		// With above, will end up with 1 bucket containing missing num and another
		// containing repeating num

		// Step 3 : Find missing / repeating num by traversing through array
		for (int i = 0; i < arr.length; i++) { // O(n)
			if (arr[i] == setBitBucket) {
				System.out.println("Repeating num:" + setBitBucket + ", Missing num:" + unsetBitBucket);
				return;
			}
		}

		// if setBitBucket is not found in the array then it becomes missing num and num
		// in unsetBitBucket becomes repeating num
		System.out.println("Repeating num:" + unsetBitBucket + ", Missing num:" + setBitBucket);

		// TC : O(5n)
		// SC : O(1)

	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 6, 2, 1, 1 };
		missingandRepeatingNum_Opt(arr);
	}
}