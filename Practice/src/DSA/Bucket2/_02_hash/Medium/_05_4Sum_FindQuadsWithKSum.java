package DSA.Bucket2._02_hash.Medium;

//https://www.youtube.com/watch?v=eD95WRfh81c
//https://www.naukri.com/code360/problems/4sum_5713771
import java.util.*;

public class _05_4Sum_FindQuadsWithKSum {

	public static List<List<Integer>> fourSum_Better(int[] arr, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>(); // O(unique elements * 2)

		for (int i = 0; i < arr.length; i++) { // O(n)

			for (int j = i + 1; j < arr.length; j++) { // O(n)

				HashSet<Integer> hs = new HashSet<Integer>(); // SC : O(n)

				for (int k = j + 1; k < arr.length; k++) { // O(n)

					if (hs.contains(target - (arr[i] + arr[j] + arr[k]))) { // O(logn)

						List<Integer> al = new ArrayList<Integer>();
						al.add(arr[i]);
						al.add(arr[j]);
						al.add(arr[k]);
						al.add(target - (arr[i] + arr[j] + arr[k]));
						Collections.sort(al);// O(3log3) ~ O(1)

						if (!result.contains(al)) // O(logm)
							result.add(al);
					} else
						hs.add(arr[k]); // O(logm)
				}
			}
		}

		return result;

		// TC : O(n^3 * logn)
		// SC : O(n + unique elements * 2)
	}

	public static List<List<Integer>> fourSum_Opt(int[] arr, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>(); // O(unique elements * 2)
		Arrays.sort(arr); // O(nlogn)

		for (int i = 0; i < arr.length; i++) { // O(n)

			for (int j = i + 1; j < arr.length; j++) { // O(n)

				int k = j + 1, l = arr.length - 1;

				while (k < l) { // O(n)

					int sum = arr[i] + arr[j] + arr[k] + arr[l];

					if (sum == target) {

						List<Integer> al = new ArrayList<Integer>();
						al.add(arr[i]);
						al.add(arr[j]);
						al.add(arr[k]);
						al.add(arr[l]); // this will already be sorted

						// to avoid duplicating results by comparing with last result's element as
						// result elements are sorted
						if (!result.contains(al)) // O(log(unique combinations))
							result.add(al);

						k++;
						l--;
					}

					else if (sum < target)
						k++;

					else
						l--;
				}
			}
		}

		return result;
		// TC : O(nlogn + n^3 * log(unique combinations))
		// SC : O(unique elements * 2)
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
		int target = 9;

		System.out.println(fourSum_Better(arr, target));
		System.out.println(fourSum_Opt(arr, target));
	}
}
