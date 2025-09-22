package DSA.Bucket2._08_search._02_BinarySearch._05_BS;

//https://practice.geeksforgeeks.org/problems/find-the-highest-number2259/1
public class _03_FindHighestNumber_Imp {

	public static int findHighestNum(int[] arr, int l, int r) {

		if (arr[l] < arr[r])
			return arr[r];

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if ((arr[mid] >= arr[mid + 1]) && (arr[mid] >= arr[mid - 1]))
				return arr[mid];

			else if (arr[mid] < arr[mid + 1])
				l = mid + 1;

			else
				r = mid - 1;
		}

		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 };
		System.out.println(findHighestNum(arr, 0, arr.length - 1));
	}
}

//TC : O(logn)