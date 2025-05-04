package DSA.Bucket2._01_arrays._05_sort;

import java.util.Arrays;

//https://www.happycoders.eu/algorithms/quicksort/
public class _05_01_QuickSort { // https://www.youtube.com/watch?v=h8eyY7dIiN4

	int[] arr = { 3, 7, 1, 8, 2, 5, 9, 4, 6 };
	int temp;

	public void quickSort(int[] arr, int lowIndex, int highIndex) {

		if (lowIndex >= highIndex)
			return;

		int pivot = arr[highIndex];

		// ------ Below section can be part of separate method : partition()---------
		int leftPointer = lowIndex, rightPointer = highIndex;

		//
		//
		//
		//
		// loop for each sub array till leftPointer < rightPointer
		while (leftPointer < rightPointer) {

			// If arr[leftPointer] is less than pivot, continue doing leftPointer++
			while (arr[leftPointer] <= pivot && leftPointer < rightPointer)
				leftPointer++;

			// If arr[rightPointer] is greater than pivot, continue doing rightPointer--
			while (arr[rightPointer] >= pivot && leftPointer < rightPointer)
				rightPointer--;

			// If arr[leftPointer] > pivot && arr[rightPointer] < pivot then swap
			// arr[leftPointer] with arr[rightPointer]
			swap(arr, leftPointer, rightPointer);

		}

		//
		// Lastly when leftPointer = rightPointer, swap pivot with arr[leftPointer] or
		// arr[rightPointer]. Hence after every iteration pivot finds its final position
		swap(arr, leftPointer, highIndex);

		// ------------- End of partitioning ---------------

		//
		//
		//
		// Now take sub arrays available to left and right sides of pivot
		quickSort(arr, lowIndex, leftPointer - 1);
		quickSort(arr, leftPointer + 1, highIndex);

	}

	// Swapping array elements
	public static void swap(int[] arr, int leftPointer, int rightPointer) {
		int temp = arr[leftPointer];
		arr[leftPointer] = arr[rightPointer];
		arr[rightPointer] = temp;
	}

	//
	//
	//
	public static void main(String[] args) {
		_05_01_QuickSort sort = new _05_01_QuickSort();
		sort.quickSort(sort.arr, 0, sort.arr.length - 1);
		System.out.println(Arrays.toString(sort.arr));
	}

}
