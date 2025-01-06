package DSA._10_dynamicprogramming._22_LongestIncreasingSubSeq_Count;

public class _01_Recursion {

	static int currMaxLength = 0;

	public static int longestIncreasingSubSeq(int[] arr, int index, int prevIndex, int length, int count) {

		if (index == arr.length) {

			if (length > currMaxLength) {
				currMaxLength = length;
				return 1;
			}

			if (length == currMaxLength)
				return count + 1;

			return count;
		}

		if (prevIndex == -1 || arr[prevIndex] < arr[index])
			count = longestIncreasingSubSeq(arr, index + 1, index, length + 1, count);

		count = longestIncreasingSubSeq(arr, index + 1, prevIndex, length, count);

		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 7 };
		System.out.println(longestIncreasingSubSeq(arr, 0, -1, 0, 0));
	}

}

//TC : O(2^n)
//SC : O(n)