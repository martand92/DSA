package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

/* floor : greatest number less than or equal to target
 * ceil : lowest number greater than or equal to target */

//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
public class _03_Floor_Ceil_Imp {

	public static String floorCeil(int[] arr, int target, int l, int r) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] == target) {
				System.out.println("Floor:" + arr[mid] + " Ceil:" + arr[mid]);
				return "Floor:" + mid + " Ceil:" + mid;
			}

			else if (arr[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return "Floor:" + r + " Ceil:" + l;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 12 };
		int target = 0;
		System.out.println(floorCeil(arr, target, 0, arr.length - 1));
	}

}
