package DSA.Bucket5._08_recursion.medium.pickAndNotPick;

//https://www.youtube.com/watch?v=OyZFFqQtu98
import java.util.*;

public class _22_01_CombinationSum {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int index, int sum,
			ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {

		if (sum > target)
			return result;

		if (index == candidates.length) {

			// Instead of checking for every loop whether subseq sum = target, just check at
			// the fag end of the recursion (at this place), As you will get all possible
			// sub sequences here
			if (sum == target) {
				result.add(new ArrayList<Integer>(list));
				return result;
			}

			return result;
		}

		list.add(candidates[index]);

		// as same element can be picked multiple times, not increasing index
		combinationSum(candidates, target, index, sum + candidates[index], list, result); // Infinite supply

		list.remove(list.size() - 1);

		combinationSum(candidates, target, index + 1, sum, list, result); // not picking

		return result;

	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		/*
		 * Below data results in duplicate subseq matching given target. To avoid result
		 * showing duplicates, refer to next problem
		 *
		 * int[] candidates = { 1, 1, 1, 2, 2 }; int target = 4;
		 */

		System.out.println(combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(),
				new ArrayList<ArrayList<Integer>>()));
	}

}
