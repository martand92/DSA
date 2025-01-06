package DSA._01_arrays._06_search._02_LowerUpperBound;

//https://leetcode.com/problems/search-insert-position/description/
public class _03_SearchInsertPos {

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

		// System.out.println(r + " " + l);

		if (arr[mid] < target)
			return l;
		else
			return r + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7 };
		int target = 6;
		// int target = 7;
		// int target = 2;
		System.out.println(insertPos(arr, target, 0, arr.length - 1));
	}

}
