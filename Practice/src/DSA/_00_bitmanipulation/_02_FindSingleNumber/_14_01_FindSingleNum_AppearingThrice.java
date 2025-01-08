package DSA._00_bitmanipulation._02_FindSingleNumber;

public class _14_01_FindSingleNum_AppearingThrice {

	public static int findSingleNum(int[] nums) {
		int res = 0;

		for (int bitIndex = 0; bitIndex <= 31; bitIndex++) {

			int cnt = 0;

			for (int j = 0; j < nums.length; j++) {

				if ((nums[j] & (1 << bitIndex)) != 0)
					cnt++;
			}

			if (cnt % 3 != 0)
				res = res | (1 << bitIndex);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 5, 5, 2, 4, 4, 4 };
		System.out.println(findSingleNum(nums));
	}
}
//TC : O(N * 32)