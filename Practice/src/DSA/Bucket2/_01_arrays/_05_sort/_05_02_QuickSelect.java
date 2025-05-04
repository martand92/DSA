package DSA.Bucket2._01_arrays._05_sort;

public class _05_02_QuickSelect { // https://www.youtube.com/watch?v=BP7GCALO2v8

	int[] arr = { 3, 7, 1, 8, 2, 5, 9, 4, 6 };
	int temp;
	int keythSmallestElement = -1, key = 2;// Find 2nd smallest element

	public int quickSelect(int[] arr, int lowIndex, int highIndex) {

		if (lowIndex >= highIndex)
			return keythSmallestElement;

		// If required element is found then return index of that element
		if (keythSmallestElement != -1)
			return keythSmallestElement;

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
		// Now in every iteration, above swap will provide final pivot placement

		//
		//
		//
		// Check if above pivot's index is < or > required index (Ex: 2nd smallest)
		// Ex: In 1st itr, if pivot is placed at index 5, it will be 6th smallest

		// If required smallest element index is < current pivot index, then search left
		// of pivot
		if (key < leftPointer + 1)
			keythSmallestElement = quickSelect(arr, lowIndex, leftPointer - 1);

		// If required smallest element index is > current pivot index, then search
		// right of pivot
		else if (key > leftPointer + 1)
			keythSmallestElement = quickSelect(arr, leftPointer + 1, highIndex);

		// If required element index = current pivot index => found, return 2nd smallest element
		else
			keythSmallestElement = arr[leftPointer + 1];

		return keythSmallestElement;

	}

	//
	//
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
		_05_02_QuickSelect select = new _05_02_QuickSelect();

		select.keythSmallestElement = select.quickSelect(select.arr, 0, select.arr.length - 1);

		System.out.println(select.keythSmallestElement);
	}

}
