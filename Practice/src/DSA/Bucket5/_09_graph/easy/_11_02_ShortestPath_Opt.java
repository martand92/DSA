package DSA.Bucket5._09_graph.easy;

//https://practice.geeksforgeeks.org/problems/shortest-path-from-1-to-n0156/1
public class _11_02_ShortestPath_Opt {

	static int minStep(int n, int count) {
		// complete the function here
		if (n == 1)
			return count;

		else if (n % 3 == 0)
			count = minStep(n / 3, count + 1);

		else
			count = minStep(n - 1, count + 1);

		return count;

	}

	public static void main(String[] args) {
		System.out.println(minStep(15, 0));
	}
}