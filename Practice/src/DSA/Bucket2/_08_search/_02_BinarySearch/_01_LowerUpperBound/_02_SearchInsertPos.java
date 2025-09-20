package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

//https://leetcode.com/problems/search-insert-position/description/
public class _02_SearchInsertPos {

	public static int insertPos(int[] arr, int target, int l, int r) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] == target)
				return mid;

			else if (arr[mid] < target)
				l = mid + 1;

			else
				r = mid - 1;
		}

		return l;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7 };
		int target = 6;
		// int target = 7;
		// int target = 2;
		System.out.println(insertPos(arr, target, 0, arr.length - 1));
	}

}
