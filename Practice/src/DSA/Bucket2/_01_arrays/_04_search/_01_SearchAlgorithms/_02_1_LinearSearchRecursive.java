package DSA.Bucket2._01_arrays._04_search._01_SearchAlgorithms;

public class _02_1_LinearSearchRecursive {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 4, 7, 3, 9, 2, 6, 8 };
		int key =11;
		int i = 0;
		boolean found = false;
		found = search(arr, i, key, found);
		System.out.println(found);
	}

	public static boolean search(int[] arr, int i, int key, boolean found) {

		if (i == arr.length)
			return false;

		if (arr[i] == key)
			return true;

		return search(arr, i + 1, key, found);
	}

}
