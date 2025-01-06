package DSA._08_recursion.medium;

//https://practice.geeksforgeeks.org/problems/sequence-of-sequence1155/1
public class _06_SeqOfSeq {

	public static int numberSequence(int m, int n, int i, int count, int len, boolean proceed) {

		if (!proceed)
			return count;

		if (i > m)
			return count;

		if (len == n) {
			count++;

			if (i == m)
				proceed = false;
		}

		count = numberSequence(m, n, i * 2, count, len + 1, proceed);
		count = numberSequence(m, n, i + 1, count, len, proceed);

		return count;
	}

	public static void main(String[] args) {

		int count = numberSequence(10, 4, 1, 0, 1, true);
		// numberSequence(5, 2, 1, 1);
		System.out.println(count);
	}
}
//1 2 4 8
//1 2 4 9
//1 2 4 10
//1 2 5 10