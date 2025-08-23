package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/paths-to-reach-origin3850/1
public class _23_PathToOrigin {
	static int a = 0;

	public static void main(String[] args) {
		int n = 3, m = 0;
		System.out.println(pathToOrigin(n, m, 0));
	}

	public static int pathToOrigin(int n, int m, int count) {

		// increase count by 1 only when cell 0,0 is reached
		if (n == 0 && m == 0) {
			count++;
			return count;
		}

		// keep reducing n and m till they are -1
		if (n < 0 || m < 0)
			return count;

		count = pathToOrigin(n - 1, m, count);
		count = pathToOrigin(n, m - 1, count);
		return count;
	}
}