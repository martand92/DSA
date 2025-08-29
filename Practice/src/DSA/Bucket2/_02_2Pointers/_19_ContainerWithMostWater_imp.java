package DSA.Bucket2._02_2Pointers;

public class _19_ContainerWithMostWater_imp {

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		int l = 0, r = height.length - 1;
		int currArea = 0, maxArea = 0;

		while (l < r) {

			int minHeight = Math.min(height[l], height[r]);// for water to be stored between poles, consider pole with
															// shortest height
			currArea = minHeight * (r - l);

			maxArea = Math.max(maxArea, currArea); // update if needed

			// now what defines if l or r moves?

			// shorter pole's container capacity is already maxed at current index, moving
			// longer pole's index will further reduce container capacity(as width decrease)

			// but moving shorter pole's index might or might not increase holding capacity
			// based on height of pole
			if (height[l] < height[r])
				l++;
			else
				r--;
		}

		System.out.println(maxArea);
	}

}
