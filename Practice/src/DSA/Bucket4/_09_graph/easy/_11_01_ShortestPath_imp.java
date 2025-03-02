package DSA.Bucket4._09_graph.easy;

//https://practice.geeksforgeeks.org/problems/shortest-path-from-1-to-n0156/1
public class _11_01_ShortestPath_imp {

	static int minStep(int n, int i, int length) {

		if (i > n)
			return Integer.MAX_VALUE;

		if (i == n)
			return length;

		int left = minStep(n, i + 1, length + 1);
		int right = minStep(n, i * 3, length + 1);

		return Math.min(left, right);

	}

	public static void main(String[] args) {
		System.out.println(minStep(493, 1, 0));
	}

}
