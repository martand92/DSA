package DSA._11_greedy;

import java.util.Arrays;

public class _10_02_CandyDistribution_Opt {

	public static int minCandies(int[] ratings) {

		int[] left = new int[ratings.length];
		left[0] = 1;

		for (int i = 1; i < ratings.length; i++) {

			if (ratings[i - 1] < ratings[i]) // do +1 to left child's candy count
				left[i] = left[i - 1] + 1;

			else // if left > current, then given minimal no of candies = 1
				left[i] = 1;
		}

		System.out.println(Arrays.toString(left));

		// Here no need to maintain extra right[], just calculate right[i] based on prev
		// and update left[i] with max
		int prevRight = 1; // meaning right[lastIndex]
		int sum = left[ratings.length - 1];

		for (int i = ratings.length - 2; i >= 0; i--) {

			if (ratings[i + 1] < ratings[i]) {

				// current left should only be updated if prevRight+1 > left[i]
				prevRight++; // as current > prev right
				left[i] = Math.max(prevRight, left[i]);

			} else // if right neighbor is not greater
				left[i] = Math.max(left[i], 1);

			// above code is not required as left[i] will either contain 1 or > 1 and below
			// statement will result in left[i] holding same value

			sum += left[i]; // sum it up in this iteration only
		}

		System.out.println(Arrays.toString(left));

		return sum;
	}

	public static void main(String[] args) {
		int[] ratings = { 0, 2, 4, 3, 2, 1 };
		System.out.println(minCandies(ratings));
	}
}

//TC : O(2N) for 2 for()
//SC : O(N) as only left[] is used now