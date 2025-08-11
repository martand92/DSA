package DSA.Bucket2._01_arrays;

import java.util.*;

public class _07_02_UnionOf2SortedArrays_Imp {

	public static void main(String[] args) {

//		int[] a = { 1, 2, 3, 4, 5 };
//		int[] b = { 1, 2, 3 };

		int[] a = { 1, 1, 2, 3, 4, 5 };
		int[] b = { 2, 3, 4, 4, 5, 6 };

		int i = 0, j = 0;
		List<Integer> list = new ArrayList<Integer>();// SC : O(n + m)

		while (i < a.length && j < b.length) {// TC : O(n + m)

			// if both elements are same then add any 1 of it to the ans
			if (a[i] == b[j]) {

				if (list.isEmpty() || list.get(list.size() - 1) != a[i])
					list.add(a[i]);

				i++;
				j++;

				// as arrays are sorted, utilizing this feature
			} else if (a[i] < b[j]) {

				// when both are not same, add smaller element to result only if its already not
				// present in result

				// so to check if its not present in result, need to only check previous element
				// of result as its sorted
				if (list.isEmpty() || (list.size() > 0 && list.get(list.size() - 1) != a[i]))
					list.add(a[i]);
				i++;

			} else {
				if (list.isEmpty() || (list.size() > 0 && list.get(list.size() - 1) != b[j]))
					list.add(b[j]);
				j++;

			}
		}

		while (i < a.length) {
			if (list.isEmpty() || (list.size() > 0 && list.get(list.size() - 1) != a[i]))
				list.add(a[i]);
			i++;
		}

		while (j < b.length) {
			if (list.isEmpty() || (list.size() > 0 && list.get(list.size() - 1) != b[j]))
				list.add(b[j]);
			j++;
		}

		System.out.println(list);
	}

}
//TC : O(n+m)
//SC : O(n+m)
