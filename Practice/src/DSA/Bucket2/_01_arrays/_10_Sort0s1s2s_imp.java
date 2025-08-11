package DSA.Bucket2._01_arrays;

//https://www.youtube.com/watch?v=tp8JIuCXBaU
import java.util.Arrays;

public class _10_Sort0s1s2s_imp {

	public static void sort_brute(int[] a) {
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// TC : O(nlogn)
	}

	public static void sort_better(int[] a) {

		int count0 = 0, count1 = 0, count2 = 0;

		for (int i = 0; i < a.length; i++) { // O(n)

			if (a[i] == 0)
				count0++;

			else if (a[i] == 1)
				count1++;

			else if (a[i] == 2)
				count2++;
		}

		int i = 0;
		while (count0 > 0) {
			a[i++] = 0;
			count0--;
		}

		while (count1 > 0) {
			a[i++] = 1;
			count1--;
		}

		while (count2 > 0) {
			a[i++] = 2;
			count2--;
		}

		System.out.println(Arrays.toString(a));

		// TC : O(2n)
		// SC : O(3)
	}

	// Dutch national flag
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void sort_opt(int[] arr) {

		int low = 0, mid = 0, high = arr.length - 1;

		while (mid <= high) {

			if (arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, high);
				high--;
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] a = { 0, 2, 1, 2, 0 };
		sort_brute(a.clone());
		sort_better(a.clone());
		sort_opt(a.clone());
	}

}
