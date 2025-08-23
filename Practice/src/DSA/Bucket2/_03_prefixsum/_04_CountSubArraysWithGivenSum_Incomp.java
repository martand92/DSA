package DSA.Bucket2._03_prefixsum;

public class _04_CountSubArraysWithGivenSum_Incomp {

	public static void main(String[] args) {

		int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
		int k = 7;

		// Why Sliding window won't work?
		// Sliding window relies on monotonic property where sum should increase or
		// decrease. This happens if array contains only non-neg elements

		// But here as it contains neg elements, this behavior of increasing or
		// decreasing monotonically breaks
		// ex : when arr[2] + arr[3] = 9 but 9 + arr[4] = 6

		
		
	}

}
