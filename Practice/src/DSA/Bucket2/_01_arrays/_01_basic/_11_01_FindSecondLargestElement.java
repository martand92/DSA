package DSA.Bucket2._01_arrays._01_basic;

public class _11_01_FindSecondLargestElement {
	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 20 };
		// int[] arr = { 7,2};
		
		int max = arr[0], secondLargest = -1;

		for (int i = 1; i < arr.length; i++) // O(N)
		{
			// if there exist another largest element then first make current largest and
			// second largest
			if (arr[i] > max) {
				secondLargest = max;
				max = arr[i];

				// adding another check where current element is lesser than max but greater
				// than second largest then consider it as second largest
			} else if (arr[i] != max && arr[i] > secondLargest)
				secondLargest = arr[i];
			
		}

		System.out.println(secondLargest);
	}
}
//TC : O(N)