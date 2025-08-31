package DSA.Bucket2._05_slidingWindow;

public class _00_CheckIfSubArrayHasGivenSum {

	public static boolean genericSubArrayApproach(int[] arr, int target) {

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;

			for (int j = i; j < arr.length; j++) {// look from current towards right
				sum += arr[j];

				if (sum == target)
					return true;
			}
		}

		return false;
	}

	public static boolean slidingWindowApproach(int[] arr, int target) {

		int sum = 0, l = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			while (sum > target) {
				sum -= arr[l];
				l++;
			}

			if (sum == target)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		int target = 5;
		System.out.println(genericSubArrayApproach(arr, target));// O(N^2)
		System.out.println(slidingWindowApproach(arr, target));// O(2N), only works when elments in array are non neg
	}

}
