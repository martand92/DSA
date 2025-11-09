package DSA.Bucket3._04_recursion.medium;

public class _09_03_FindSumOfAllSubArrays {

	public static int findAllSubArrays(int[] arr, int i, int sum) {

		if (i == arr.length)
			return sum;

		int prefixSum = 0;
		for (int j = i; j < arr.length; j++) {
			prefixSum += arr[j];
			sum += prefixSum;
		}

		return findAllSubArrays(arr, i + 1, sum);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findAllSubArrays(arr, 0, 0));
	}
}