package DSA._08_recursion;

//https://practice.geeksforgeeks.org/problems/recursive-sequence1611/1
public class _03_RecursiveSeq {

	static int sum = 0, n = 5, count = 1;

	public int seq(int itr, int res) {

		if (itr == 0)
			return res;

		res = (res * count) % 1000000007;
		count++;
		return seq(itr - 1, res);
	}

	public static void main(String[] args) {
		_03_RecursiveSeq sol = new _03_RecursiveSeq();
		for (int i = 1; i <= n; i++)
			sum = (sum + sol.seq(i, 1)) % 1000000007;

		System.out.println(sum);
	}
}
