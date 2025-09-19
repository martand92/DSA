package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/paths-to-reach-origin3850/1
public class _23_PathToOrigin {
	static int a = 0;

	public static void main(String[] args) {
		 int n = 3, m = 0;
		//int n = 3, m = 6;
		System.out.println(pathToOrigin(n, m));
	}

	public static int pathToOrigin(int n, int m) {

		if (n < 0 || m < 0)
			return 0;

		if (n == 0 && m == 0)
			return 1;

		return pathToOrigin(n - 1, m) + pathToOrigin(n, m - 1);

	}
}