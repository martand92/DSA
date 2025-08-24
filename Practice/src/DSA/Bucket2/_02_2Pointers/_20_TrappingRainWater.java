package DSA.Bucket2._02_2Pointers;

//https://www.youtube.com/watch?v=1_5VuquLbXg
//https://www.geeksforgeeks.org/trapping-rain-water/

//Intuition : to trap water between buildings, both left and right side buildings should be taller than current building height

//Algo:
//If we consider a subarray arr[left…right], we can decide the amount of water either for arr[left] or arr[right] if we know the left max (max element in arr[0…left-1]) and right max (max element in arr[right+1…n-1].
//If left max is less than the right max, then we can decide for arr[left]. Else we can decide for arr[right]
//If we decide for arr[left], then the amount of water would be left max – arr[left]

public class _20_TrappingRainWater {

	public static int maxWaterTrapped(int[] arr) {

		int lmax = arr[0], rmax = arr[arr.length - 1];
		int l = 1, r = arr.length - 2;

		int total = 0;
		while (l <= r) {

			if (lmax < rmax) {

				if (arr[l] < lmax)
					total += lmax - arr[l];
				else // (arr[l] >= lmax)
					lmax = arr[l];

				l++;

			} else {

				if (arr[r] < rmax)
					total += rmax - arr[r];

				else // arr[r] >= rmax
					rmax = arr[r];

				r--;
			}

		}

		return total;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 3, 1, 0, 4 }; // given height of buildings
		System.out.println(maxWaterTrapped(arr));
	}

}

//TC : O(N) + O(N) + O(N)
//SC : O(1)
