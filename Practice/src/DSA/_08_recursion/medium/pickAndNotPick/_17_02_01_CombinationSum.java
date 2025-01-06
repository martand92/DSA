package DSA._08_recursion.medium.pickAndNotPick;

import java.util.*;

//https://www.youtube.com/watch?v=G1fRTGRxXU8
public class _17_02_01_CombinationSum {

	public static HashSet<ArrayList<Integer>> combinationSum(int[] candidates, int target, int index, int sum,
			ArrayList<Integer> list, HashSet<ArrayList<Integer>> result) {

		if (index == candidates.length) {

			if (sum == target) {
				result.add(new ArrayList<Integer>(list));
				return result;
			}

			return result;
		}

		if (sum > target)
			return result;

		list.add(candidates[index]);
		combinationSum(candidates, target, index + 1, sum + candidates[index], list, result);
		list.remove(list.size() - 1);
		combinationSum(candidates, target, index + 1, sum, list, result); // not adding /picking
		return result;

	}

	public static void main(String[] args) {
		int[] candidates = { 1, 1, 1, 2, 2 };
		int target = 4;
		System.out.println(
				combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(), new HashSet<ArrayList<Integer>>()));
	}

}
