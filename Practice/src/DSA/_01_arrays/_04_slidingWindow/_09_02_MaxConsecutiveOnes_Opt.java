package DSA._01_arrays._04_slidingWindow;

//https://www.youtube.com/watch?v=3E4JBHSLpYk
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class _09_02_MaxConsecutiveOnes_Opt {

	public static int maxConsecutiveOnes(int[] arr, int k) {

		int l = 0, maxLength = 0;

		for (int r = 0; r < arr.length; r++) { // O(N)

			if (arr[r] == 0)// as k zeros can be flipped to 1, consider this 0 as part of consecutive 1s
							// window
				k--;

			// O(1)
			if (k == -1) { // When more than allowed zeros form part of window then do l-- and keep window
							// size static (which would be current max window size) and move both l and r
							// together
				if (arr[l] == 0)
					k++;

				l++;
			}

			maxLength = Math.max(maxLength, r - l + 1);

		}

		return maxLength;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2; // can switch max 2 0's to 1's
		System.out.println(maxConsecutiveOnes(arr, k));
	}

}
//TC : O(N)
//SC : O(1)