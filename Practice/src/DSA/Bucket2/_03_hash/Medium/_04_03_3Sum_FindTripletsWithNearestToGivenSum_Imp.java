package DSA.Bucket2._03_hash.Medium;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/three-sum-closest/1
public class _04_03_3Sum_FindTripletsWithNearestToGivenSum_Imp {

	public static void main(String[] args) {

		// int[] array = { -7, 9, 8, 3, 1, 1 };
		// int target = 13;

		// int[] array = { -1, 2, 1, -4 };
		// int target = 1;

		// int[] array = { 5, 2, 7, 5 };
		// int target = 7;

		int[] array = { 93, 28, 61, 50, -9, 35, 35, 22, 97 };
		int target = 195;

		TreeSet<Integer> ts = new TreeSet<Integer>();
		TreeSet<Integer> targetTs = new TreeSet<Integer>();

		for (int i = 0; i < array.length; i++)
			ts.add(array[i]);

		for (int i = 0; i < array.length; i++) {

			int reqSum = target - array[i];
			HashSet<Integer> hs = new HashSet<Integer>();

			for (int j = i + 1; j < array.length; j++) {

				int hsContains = reqSum - array[j];

				if (hs.contains(hsContains)) {
					System.out.println("Found exactly matching triplets");
					return;
				}

				else {
					hs.add(array[j]);

					if (ts.ceiling(hsContains) == null)
						hsContains = ts.floor(hsContains);

					else if (ts.floor(hsContains) == null)
						hsContains = ts.ceiling(hsContains);

					else
						hsContains = Math.abs(ts.ceiling(hsContains) - hsContains) < Math
								.abs(ts.floor(hsContains) - hsContains) ? ts.ceiling(hsContains) : ts.floor(hsContains);

					targetTs.add(array[i] + array[j] + hsContains);
				}
			}
		}

		if (targetTs.higher(target) == null)
			System.out.println(targetTs.lower(target));

		if (Math.abs(target - targetTs.higher(target)) > Math.abs(target - targetTs.lower(target)))
			System.out.println(targetTs.lower(target));

		else
			System.out.println(targetTs.higher(target));

	}

}
