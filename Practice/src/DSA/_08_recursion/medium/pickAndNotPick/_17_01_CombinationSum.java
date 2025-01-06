package DSA._08_recursion.medium.pickAndNotPick;

//https://www.youtube.com/watch?v=OyZFFqQtu98
import java.util.ArrayList;

public class _17_01_CombinationSum {

	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int index, int sum,
			ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {

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
		combinationSum(candidates, target, index, sum + candidates[index], list, result);
		list.remove(list.size() - 1);
		combinationSum(candidates, target, index + 1, sum, list, result); // not adding /picking
		return result;

	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(),
				new ArrayList<ArrayList<Integer>>()));
	}

}
