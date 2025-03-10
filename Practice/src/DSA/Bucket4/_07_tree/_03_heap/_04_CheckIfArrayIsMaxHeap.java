package DSA.Bucket4._07_tree._03_heap;

//https://practice.geeksforgeeks.org/problems/does-array-represent-heap4345/1
public class _04_CheckIfArrayIsMaxHeap {

	public boolean isArrayMaxHeap(int[] arr) {

		for (int i = 1; i < arr.length; i++)
			if (arr[i] > arr[(i - 1) / 2]) // you should know relation between parent and child else this will be
											// difficult to solve
				return false;

		return true;
	}

	public static void main(String[] args) {
		_04_CheckIfArrayIsMaxHeap tree = new _04_CheckIfArrayIsMaxHeap();
		int[] arr = { 90, 15, 10, 7, 12, 2 };
		System.out.println(tree.isArrayMaxHeap(arr));
	}
}
