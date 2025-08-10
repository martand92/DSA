package DSA.Bucket2._01_arrays._01_basic;

import java.util.HashMap;
import java.util.Map;

//https://www.naukri.com/code360/problems/majority-element_6783241
//https://www.youtube.com/watch?v=nP_ns3uSh80

//Majority element is an element that occurs more than n/2
public class _17_01_MajorityElement_imp {

	public static int majorityElement_Brute(int[] arr) {

		int count = 0, majorityElement = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j])
					count++;
			}

			if (count > arr.length / 2)
				majorityElement = arr[i];
		}

		return majorityElement;
		// TC : O(n^2)
		// SC : O(1)
	}

	public static int majorityElement_Better(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int majorityElement = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {

			if (e.getValue() > (arr.length / 2))
				majorityElement = e.getKey();
		}

		return majorityElement;

		// TC : O(2n)
		// SC : O(n)
	}

	// Moore's Voting Algo
	// Step 1 : Consider 1st element as majority element and start counting its
	// occurrences. Decrease count if other elements are seen

	// Step 2 : If count reaches 0, this means currently considered majority
	// element's occurrences is less than or equal to current length as all other
	// elements takes another half of current length. Hence this element cannot be
	// majority

	// Step 3 : So whenever count becomes 0, then replace current majority element
	// with current element in itr and increase count to 1 and repeat

	// Step 4 : whenever loop ends, there would be 1 element tagged as majority
	// element. Now this is the last left element that have not cancelled out
	// doesn't guarantee it as majority. It says current tagged majority element
	// might be a majority and no other elements can be majority

	// Step 5 : To confirm if its majority, loop again and count occurrences of this
	// tagged majority element. If its > n/2 then it is majority

	public static int majorityElement_Opt(int[] arr) {

		int majorityElement = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) { // O(n)

			if (arr[i] == majorityElement)
				count++;
			else
				count--;

			if (count == 0) {
				majorityElement = arr[i];
				count = 1;
			}
		}

		// if count for current majority element already exceeds n/2 then just return it
		if (count > (arr.length / 2))
			return majorityElement;

		// else check count of currently marked majority element to see if its > n/2
		count = 0;
		for (int i = 0; i < arr.length; i++) {// O(n)
			if (arr[i] == majorityElement)
				count++;
		}

		if (count > (arr.length / 2))
			return majorityElement;
		else
			return Integer.MIN_VALUE;

		// TC : O(2n)
		// sc : O(1)
	}

	public static void main(String[] args) {

		int[] arr = { 2, 2, 1, 3, 3, 3, 3 };
		System.out.println(majorityElement_Brute(arr));
		System.out.println(majorityElement_Better(arr));
		System.out.println(majorityElement_Opt(arr));
	}

}
