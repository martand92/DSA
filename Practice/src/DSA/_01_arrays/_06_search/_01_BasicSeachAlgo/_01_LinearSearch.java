package DSA._01_arrays._06_search._01_BasicSeachAlgo;

public class _01_LinearSearch {

	public static void main(String[] args) {
		int[] arr = new int[10];
		int key = 5;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				System.out.println("Key found : " + key);
			else
				System.out.println("Key not found : " + key);
		}

	}

}

//O(N) time 
