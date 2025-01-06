package DSA._06_stacks;

//https://www.youtube.com/watch?v=1_5VuquLbXg

//Intuition : to trap water between buildings, both left and right side buildings should be taller than current building height

//Algo:
//First find max height of left side buildings and right side buildings
//Then check for min of left max height and right max height as water beyond the min of max heights would over flow
//Then, water that can be trapped at current building arr[i] = min(maxHeightOfLeft - maxHeightOfRight) - height of curr ith building
public class _20_01_TrappingRainWater_PrefixSum {

	public static int maxWaterTrapped(int[] arr) {

		// First find prefix max height from current index on both left and right side
		int[] maxLeft = new int[arr.length]; // O(N)
		int[] maxRight = new int[arr.length]; // O(N)

		maxLeft[0] = arr[0];
		for (int i = 1; i < arr.length; i++) // O(N)
			maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);

		maxRight[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) // O(N)
			maxRight[i] = Math.max(maxRight[i + 1], arr[i]);

		int totalWaterTrapped = 0;
		for (int i = 0; i < arr.length; i++) // O(N)
			totalWaterTrapped += Math.min(maxLeft[i], maxRight[i]) - arr[i];

		return totalWaterTrapped;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 3, 1, 0, 4 }; // given height of buildings
		System.out.println(maxWaterTrapped(arr));
	}

}

//TC : O(N) + O(N) + O(N)
//SC : O(N) + O(N)
