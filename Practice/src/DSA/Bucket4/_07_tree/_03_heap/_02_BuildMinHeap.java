package DSA.Bucket4._07_tree._03_heap;

import java.util.Arrays;

//Algo :
//goto bottom most , right most, internal node. i.e, right most's parent or last array element's parent
//Then start heapifying from this parent element upto first element of array. 
//Result will be min heap

public class _02_BuildMinHeap {

	private int left(int i) {
		return (2 * i) + 1;
	}

	private int right(int i) {
		return (2 * i) + 2;
	}

	private void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void heapify(int i, int[] arr) {

		int smallestIndex = -1;

		while (i < arr.length) {

			int leftIndex = left(i);
			int rightIndex = right(i);
			smallestIndex = i;

			if (leftIndex < arr.length && arr[smallestIndex] > arr[leftIndex])
				smallestIndex = leftIndex;

			if (rightIndex < arr.length && arr[smallestIndex] > arr[rightIndex])
				smallestIndex = rightIndex;

			if (smallestIndex == i)
				break;

			swap(i, smallestIndex, arr);
			i = smallestIndex;
		}
	}

	private int[] buildHeap(int[] arr) {

		// finding parent of last heap element index. This element essentially will be
		// the last element with children and need to heapify this and all previous
		// elements till entire heap becomes min heap
		int parentOfLastEleIndex = ((arr.length - 1) - 1) / 2;

		// now from this index heapify till root / first element
		while (parentOfLastEleIndex >= 0) {
			heapify(parentOfLastEleIndex, arr);
			parentOfLastEleIndex--;
		}

		return arr;

	}

	public static void main(String[] args) {
		_02_BuildMinHeap heap = new _02_BuildMinHeap();
		int[] arr = { 10, 5, 20, 2, 4, 8 };
		heap.buildHeap(arr);
		System.out.println(Arrays.toString(arr));
	}
}

//TC: O(N)