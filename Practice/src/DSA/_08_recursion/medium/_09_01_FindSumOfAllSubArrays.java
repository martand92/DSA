package DSA._08_recursion.medium;

//https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1
public class _09_01_FindSumOfAllSubArrays {

	public int findSum(int[] arr, int windowSize, int l, int r, int windowSum, int sum) {

		if ((r - l) > windowSize) {
			windowSum -= arr[l];
			l++;
		}

		if ((r - l) == windowSize) // whenever window size is met, add to final sum
			sum += windowSum;

		if (r == arr.length)
			return sum;

		windowSum += arr[r];

		sum = findSum(arr, windowSize, l, r + 1, windowSum, sum);
		return sum;

	}

	public static void main(String[] args) {

		_09_01_FindSumOfAllSubArrays obj = new _09_01_FindSumOfAllSubArrays();

		int[] arr = { 1, 2, 3 };
		int sum = 0;

		for (int i = 1; i <= arr.length; i++)
			sum += obj.findSum(arr, i, 0, 0, 0, 0);

		System.out.println(sum);
	}

}
