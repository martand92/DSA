package DSA.Bucket2._06_hash.Medium;

//https://www.naukri.com/code360/problems/three-sum_6922132
//https://www.youtube.com/watch?v=DhFh8Kw7ymk

//Note : if multiple ans exists with shuffled order of same elements then should return any 1
//Ex : arr={-1,0,1,-1} then ans contains {-1,0,1} and {0,-1,1}. But should return any 1 from these 
//https://www.youtube.com/watch?v=DhFh8Kw7ymk

import java.util.*;

public class _04_FindTripletsWithZeroSum_Imp {

	public static List<List<Integer>> findTripletsWithZeroSum_Better(int[] arr) {

		List<List<Integer>> result = new ArrayList<List<Integer>>(); // SC : O(no of unique triplets *2)

		for (int i = 0; i < arr.length - 1; i++) { // O(n)

			HashSet<Integer> hs = new HashSet<Integer>();// O(n)

			for (int j = i + 1; j < arr.length; j++) { // O(n)

				if (hs.contains(-(arr[i] + arr[j]))) { // O(log m)

					// if zero sum is found then add all 3 elements to result in sorted order
					// because same set of elements if re-occurs then need to be ignored
					List<Integer> al = new ArrayList<Integer>();
					al.add(arr[i]);
					al.add(arr[j]);
					al.add(-(arr[i] + arr[j]));
					Collections.sort(al);// O(3log3) ~ O(1)

					if (!result.contains(al)) // to avoid duplicating results as specified in "note". O(log3) ~ O(1)
						result.add(al);
				}

				else
					hs.add(arr[j]);
			}
		}

		return result;

		// TC : O(n^2 * log m)
		// SC : O(n) + O(no of unique triplets *2)
	}

	// 3 pointer approach
	public static List<List<Integer>> findTripletsWithZeroSum_Opt(int[] arr) {

		Arrays.sort(arr); // O(nlogn)
		List<List<Integer>> result = new ArrayList<List<Integer>>(); // SC : O(no of unique triplets *2)

		int j = 0, k = 0;

		for (int i = 0; i < arr.length; i++) {// O(n)

			j = i + 1;
			k = arr.length - 1;

			while (j < k) { // making j <= k would end up considering same element for j and k which
							// shouldn't be. O(n)

				if (arr[i] + arr[j] + arr[k] == 0) {
					List<Integer> al = new ArrayList<Integer>();
					al.add(arr[i]);
					al.add(arr[j]);
					al.add(arr[k]);// these will already be sorted

					// to avoid duplicating results as specified in "note"
					if (!result.contains(al))// O(log(unique combinations))
						result.add(al);

					j++;
					k--;

				} else if (arr[i] + arr[j] + arr[k] < 0)
					j++;

				else
					k--;
			}

		}

		return result;

		// TC : O(nlogn + n^2 * log(unique combinations))
		// SC : O(no of unique triplets * 2)
	}

	public static void main(String[] args) {

		int[] arr = { -1, 0, 1, 2, -1, -4 };
		System.out.println(findTripletsWithZeroSum_Better(arr));
		arr = new int[] { -1, 0, 1, 2, -1, -4 };
		// arr = new int[] { -2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2 };
		System.out.println(findTripletsWithZeroSum_Opt(arr));
	}

}
