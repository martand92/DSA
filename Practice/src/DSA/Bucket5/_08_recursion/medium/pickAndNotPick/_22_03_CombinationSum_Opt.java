package DSA.Bucket5._08_recursion.medium.pickAndNotPick;

import java.util.*;

//https://www.youtube.com/watch?v=G1fRTGRxXU8
public class _22_03_CombinationSum_Opt {

	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int index, int sum,
			ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {

		if (sum > target)
			return result;

		if (sum == target)
			result.add(new ArrayList<Integer>(list));

		for (int i = index; i < candidates.length; i++) {

			if (i == index || candidates[i - 1] != candidates[i]) {

				list.add(candidates[i]);
				combinationSum(candidates, target, i + 1, sum + candidates[i], list, result);
				list.remove(list.size() - 1);

			}
		}

		return result;
	}

	public static void main(String[] args) {

//		int[] candidates = { 1, 1, 1, 2, 2 };
//		int target = 4;

		int[] candidates = { 1, 2, 2 };
		int target = 3;

		Arrays.sort(candidates); // input need to be sorted

		System.out.println(combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(),
				new ArrayList<ArrayList<Integer>>()));

	}

}