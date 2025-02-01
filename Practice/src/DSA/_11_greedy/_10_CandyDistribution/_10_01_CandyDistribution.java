package DSA._11_greedy._10_CandyDistribution;

import java.util.Arrays;

public class _10_01_CandyDistribution {

	public static int minCandies(int[] ratings) {

		// have left and right array with candoes distribution

		// left array will always have more candies given to child with higher rating
		// wrt left child
		int[] left = new int[ratings.length];
		left[0] = 1;

		for (int i = 1; i < ratings.length; i++) {

			if (ratings[i - 1] < ratings[i]) // do +1 to left child's candy count
				left[i] = left[i - 1] + 1;

			else // if left > current, then given minimal no of candies = 1
				left[i] = 1;
		}

		System.out.println(Arrays.toString(left));

		// right array will always have more candies given to child with higher rating
		// wrt right child
		int[] right = new int[ratings.length];
		right[ratings.length - 1] = 1;

		for (int i = ratings.length - 2; i >= 0; i--) {

			if (ratings[i + 1] < ratings[i])
				right[i] = right[i + 1] + 1;

			else
				right[i] = 1;
		}

		System.out.println(Arrays.toString(right));

		// now need to find max of left and right for each child that gives max candies
		// this child can have compared to neighbor
		int[] max = new int[left.length];
		for (int i = 0; i < left.length; i++)
			max[i] = Math.max(left[i], right[i]);

		System.out.println(Arrays.toString(max));

		int sum = 0;
		for (int i = 0; i < max.length; i++)
			sum += max[i];

		return sum;
	}

	public static void main(String[] args) {
		int[] ratings = { 0, 2, 4, 3, 2, 1 };
		System.out.println(minCandies(ratings));
	}

}

//TC : O(3N) // for 3 for()
//SC : O(3N) // for left[], right[] and max[]