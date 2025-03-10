package DSA.Bucket5._08_recursion.medium;

//https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1
public class _09_03_FindSumOfAllSubArrays {

	public static int findSumOfAllSubArrays(int[] arr, int i, int prefixSum, int sum) {

		if (i == arr.length)
			return sum;

		prefixSum += arr[i];

		return findSumOfAllSubArrays(arr, i + 1, prefixSum, sum + prefixSum);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += findSumOfAllSubArrays(arr, i, 0, 0);

		System.out.println(sum);
	}
}