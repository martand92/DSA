package DSA._01_arrays._06_search;

//https://www.naukri.com/code360/problems/find-peak-element_1081482
//https://www.youtube.com/watch?v=cXxmbemS6XM
public class _18_FindPeak {

	public static int findPeak(int[] arr) {

		int mid = 0, l = 0, r = arr.length - 1;

		while (l <= r) {

			mid = (l + r) / 2;

			// when curr ele is greater than prev and lesser then next then do l=mid+1
			if ((mid < arr.length - 1) && (mid > 0) && arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
				l = mid + 1;

			// when curr ele is lesser than prev and greater then next then do r=mid-1
			else if ((mid < arr.length - 1) && (mid > 0) && arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
				r = mid - 1;

			// when curr ele is lesser than next but greater than prev then this is the peak
			else if ((mid < arr.length - 1) && (mid > 0) && arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid])
				return mid;

			// When curr element is lesser than both next and prev then this is the bottom
			// element, hence peak exists on both sides. So either move to left/right
			else {
				l = mid + 1; // or r = mid - 1 would also be valid as peak exists on both sides as current
								// element is bottom
			}
		}

		// if none of the above cases are valid then the peak should be either arr[0] or
		// arr[n]
		if (arr[0] > arr[1])
			return 0;
		else
			return arr.length - 1;
	}

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 }; // ans : 8
		int[] arr = { 1, 2, 1, 3, 5, 6, 4 }; // ans : 2 or 6, return any
		// int[] arr = { 1, 2, 3, 4, 5 }; // ans : 1 or 5, as arr[-1]=-infinite &
		// arr[n]=-infinite, return any
		// int[] arr = { 5, 4, 2, 3, 1 }; // ans : 5, as arr[-1] = -infinite

		System.out.println(findPeak(arr));
	}

}
