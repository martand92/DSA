package DSA.Bucket5._10_dynamicprogramming._10_SubSeq_CoinChange_InfiniteSupply;

public class _01_Recursion {

	public static int countCoins(int[] arr, int index, int target) {

		if (target == 0)
			return 1;

		if (index == 0) {
			// since coins are unlimited, target can be formed with multiple arr elements
			if (target % arr[index] == 0)
				return 1;
			else
				return 0;
		}

		int pick = 0;
		if (target >= arr[index])
			pick = countCoins(arr, index, target - arr[index]);

		int notPick = countCoins(arr, index - 1, target);

		return pick + notPick;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int target = 4;

		System.out.println(countCoins(arr, arr.length - 1, target));
	}

}
