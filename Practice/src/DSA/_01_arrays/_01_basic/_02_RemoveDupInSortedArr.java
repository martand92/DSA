package DSA._01_arrays._01_basic;

import java.util.HashSet;

public class _02_RemoveDupInSortedArr {

	public static void removeDup_Brute(int[] a) {

		HashSet<Integer> hs = new HashSet<Integer>(); // SC : O(N)
		for (int i : a)// O(n)
			hs.add(i); // O(logn)

		int i = 0;
		for (int e : hs) { // O(NlogN)
			a[i] = e;
			i++;
		}

		// System.out.println(hs.size());
		for (i = 0; i < hs.size(); i++) // O(n)
			System.out.print(a[i] + " ");

		System.out.println();
		// TC : O(nlogn + nlogn + n)
		// SC : O(n)
	}

	public static void removeDup_Opt(int[] a) {

		int index = 0;

		for (int i = 1; i < a.length; i++) { // O(n)

			if (a[i] != a[i - 1]) {
				index++;
				a[index] = a[i];
			}
		}

		for (int i = 0; i <= index; i++)// O(n)
			System.out.print(a[i] + " ");

		// TC : O(n+n)
		// SC : O(1)
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6 };
		removeDup_Brute(a);
		a = new int[] { 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6 };
		removeDup_Opt(a);

	}
}
