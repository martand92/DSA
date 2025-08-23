package DSA.Bucket2._08_search._01_SearchAlgorithms;

import java.util.Arrays;;

public class _05_JumpSearch {

	static int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
	static int jump = (int) Math.sqrt(arr.length); // optimum jump size is selected as square root of arr length
	static int KEY = 611;
	// static int low = 0, high = 0;
	static int init = 0, next = 0;

	static boolean found = false;

	public static void main(String[] args) {

		Arrays.sort(arr);

		while (next < arr.length && arr[next] <= KEY ) {

			if (arr[next] == KEY) {
				found = true;
				break;
			}

			init = next;
			next = init + jump;
		}

//		for (int i = 0; i < arr.length; i = i + jump) {
//
//			if (KEY == arr[i])
//				found = true;
//
//			else if (KEY < arr[i]) {
//				high = i;
//				break;
//			}
//
//			low = i;// store previous i value of jump window
//		}

		// then do linear or binary search to find key in this jump window
//		for (int i = low; i <= high; i++) {
//			if (KEY == arr[i]) {
//				found = true;
//				break;
//			}
//		}
		if (found == false && next < arr.length) {
			for (int i = init; i <= next; i++) {
				if (KEY == arr[i]) {
					found = true;
					break;
				}
			}
		}
		System.out.println(found);
	}
}
