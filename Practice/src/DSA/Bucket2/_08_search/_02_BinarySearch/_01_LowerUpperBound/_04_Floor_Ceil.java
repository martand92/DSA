package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

public class _04_Floor_Ceil {

	public static void floorCeil(int[] arr, int target, int l, int r) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] == target) {
				System.out.println("Floor:" + arr[mid] + " Ceil:" + arr[mid]);
				return;
			}

			else if (arr[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		System.out.println("Floor:" + (r < 0 ? r : arr[r]) + " Ceil:" + (l < arr.length ? arr[l] : "index " + l));
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 12 };
		int target = 0;
		floorCeil(arr, target, 0, arr.length - 1);
	}

}
