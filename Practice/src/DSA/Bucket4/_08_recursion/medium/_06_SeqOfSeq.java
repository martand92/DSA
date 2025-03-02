package DSA.Bucket4._08_recursion.medium;

//https://practice.geeksforgeeks.org/problems/sequence-of-sequence1155/1
public class _06_SeqOfSeq {

	public static int seqOfSeq(int n, int m, int i, int len) {

		if (i > m && len == n)
			return 1;

		if (i > m)
			return 0;

		int left = seqOfSeq(n, m, i * 2, len + 1);
		int right = seqOfSeq(n, m, i + 1, len);

		return left + right;
	}

	public static void main(String[] args) {
		System.out.println(seqOfSeq(4, 10, 1, 0));
	}
}
//1 2 4 8
//1 2 4 9
//1 2 4 10
//1 2 5 10