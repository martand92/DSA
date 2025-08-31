package DSA.Bucket2._03_prefixsum;

public class _03_CountVowelsInSubstring_imp_RangeQueries {

	public static void main(String[] args) {

		String word = "prefixSum";

		int[][] q = { { 0, 2 }, { 1, 4 }, { 3, 5 } }; // 0 based indexing

		int[] prefixSum = new int[word.length()]; // SC : O(N)
		prefixSum[0] = checkVowel(word.charAt(0)) ? 1 : 0;

		for (int i = 1; i < word.length(); i++) // TC : O(N)
			prefixSum[i] = prefixSum[i - 1] + (checkVowel(word.charAt(i)) ? 1 : 0);

		for (int k = 0; k < q.length; k++) { // TC : O(Q)

			int j = q[k][1];
			int i = q[k][0];

			// considering prefixSum[j] - prefixSum[i-1]
			if (i == 0)
				System.out.println(prefixSum[j]);
			else
				System.out.println(prefixSum[j] - prefixSum[i - 1]);
		}

	}

	public static boolean checkVowel(char chr) {

		if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u')
			return true;

		return false;

	}
}

//TC : O(N + Q)
//SC : O(N)