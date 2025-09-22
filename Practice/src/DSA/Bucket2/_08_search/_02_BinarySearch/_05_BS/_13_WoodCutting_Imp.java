package DSA.Bucket2._08_search._02_BinarySearch._05_BS;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/ffd66b6a0bf7cefb9987fa455974b6ea5695709e/1
public class _13_WoodCutting_Imp {

	public static int findHeight(int[] tree, int k) {

		Arrays.sort(tree);// not needed, you can just loop through and find highest num
		int[] heights = new int[tree[tree.length - 1] + 1];
		for (int i = 0; i < heights.length; i++)
			heights[i] = i;

		int l = 0, r = heights.length - 1, sum = 0;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			for (int i = 0; i < tree.length; i++)
				sum += tree[i] - mid < 0 ? 0 : tree[i] - mid;

			if (sum == k)
				return mid;
			else if (sum > k)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;

	}

	public static void main(String[] args) {

		int[] tree = { 2, 3, 6, 2, 4 };
		int k = 4;

		System.out.println(findHeight(tree, k));
	}
}
