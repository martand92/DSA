package DSA.Bucket2._01_arrays._01_basic;

//https://www.naukri.com/code360/problems/majority-element_6915220
//https://www.youtube.com/watch?v=vwZj1K0e9U8

//Majority element is an element that occurs more than n/3
//Note : At max only 2 elements could be more than n/3 times
public class _17_02_MajorityElement {

	// Moore's Voting Algo
	// Step 1 : Have 2 elements element1, element2 and have count1 and count2 to
	// track occurrences of these 2 elements. At the end these 2 elements might
	// occur > n/3 times

	// Step 2 : Assign current arr[i] to element1 if count1 = 0 & != element2 and
	// assign current arr[i] to element2 if count2 = 0 & != element1

	// Step 3 : When new element doesn't match both element1 and element2 then
	// reduce both count1 and count2 by 1

	// Step 4 : To confirm if its majority, loop again and count occurrences of both
	// element1 and element2 tagged as majority elements. If any of their count >
	// n/3 then it is majority

	public static String majorityElement_Opt(int[] arr) {

		int element1 = -1, element2 = -1, count1 = 0, count2 = 0;

		for (int i = 0; i < arr.length; i++) { // O(n)

			if (count1 == 0 && arr[i] != element2) {
				element1 = arr[i];
				count1++;
			}

			else if (count2 == 0 && arr[i] != element1) {
				element2 = arr[i];
				count2++;
			}

			else if (arr[i] == element1)
				count1++;

			else if (arr[i] == element2)
				count2++;

			else {
				count1--;
				count2--;
			}
		}

		// if count for current majority element already exceeds n/3 then just return it
		if (count1 > (arr.length / 3) && count2 > (arr.length / 3))
			return "element1 : " + element1 + ", element2 : " + element2;

		// else traverse and check if count of both element1 and element2 is > n/3
		count1 = 0;// reset counters
		count2 = 0;

		for (int i = 0; i < arr.length; i++) {// O(n)
			if (element1 != -1 && arr[i] == element1) // if 2 distinct elements exists and then check their counts
				count1++;

			if (element2 != -1 && arr[i] == element2)
				count2++;
		}

		String ans = "";
		if (count1 > arr.length / 3)
			ans = "element1 : " + element1;
		else
			ans = "element1 : " + Integer.MIN_VALUE;

		if (count2 > arr.length / 3)
			ans += ", element2 : " + element2;
		else
			ans += ", element2 : " + Integer.MIN_VALUE;

		return ans;

		// TC : O(2n)
		// SC : O(1)
	}

	public static void main(String[] args) {

		int[] arr = { 2, 2, 1, 3, 3, 3, 3 };
		System.out.println(majorityElement_Opt(arr));
	}
}
