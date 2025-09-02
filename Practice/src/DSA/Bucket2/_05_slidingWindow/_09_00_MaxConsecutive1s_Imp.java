package DSA.Bucket2._05_slidingWindow;

public class _09_00_MaxConsecutive1s_Imp {

	public static int maxConsecutive1s(int[] arr) {

		int l = 0, maxCount = 0;
		for (int r = 0; r < arr.length; r++) {

			if (arr[r] != 1) {
				l = r + 1;// move l pointer ahead of r assuming next element could be 1
				continue;
			}

			maxCount = Math.max(maxCount, r - l + 1);
		}

		return maxCount;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };
		System.out.println(maxConsecutive1s(arr));
	}

}
