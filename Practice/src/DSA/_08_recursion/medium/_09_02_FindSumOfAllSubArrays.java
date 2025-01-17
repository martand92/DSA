package DSA._08_recursion.medium;

//https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1
public class _09_02_FindSumOfAllSubArrays {

	public static int findSumOfAllSubArrays(int[] arr, int indx, int prefixSum, int sum) {

		if (indx == arr.length)
			return sum;

		prefixSum += arr[indx];
		sum += prefixSum;

		return findSumOfAllSubArrays(arr, indx + 1, prefixSum, sum);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += findSumOfAllSubArrays(arr, i, 0, 0);

		System.out.println(sum);
	}
}