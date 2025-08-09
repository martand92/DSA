package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._05_Imp_BS;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/ffd66b6a0bf7cefb9987fa455974b6ea5695709e/1
public class _13_WoodCutting_NLogH_BS_Nice {

	public static void main(String[] args) {

		int[] tree = { 2, 3, 6, 2, 4 };
		int k = 4;

		Arrays.sort(tree);

		System.out.println(Arrays.toString(tree));

		int[] arr = new int[tree[tree.length - 1] + 1];
		
		System.out.println(tree[tree.length - 1] + 1);
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = i;

		int l = 0;
		int r = arr.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int sum = 0;

			for (int i = 0; i < tree.length; i++)
				sum += tree[i] - mid < 0 ? 0 : tree[i] - mid;

			if (sum == k) {
				System.out.println(mid);
				break;
			} else if (sum > k)
				l = mid + 1;
			else
				r = mid - 1;
		}

	}
}
