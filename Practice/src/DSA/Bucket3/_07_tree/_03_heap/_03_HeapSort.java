package DSA.Bucket3._07_tree._03_heap;

public class _03_HeapSort {

	private void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private int leftChild(int index) {
		return (2 * index + 1);
	}

	private int rightChild(int index) {
		return (2 * index + 2);
	}

	private void heapify(int i, int[] arr, int heapSize) {

		int leftChildIndex = leftChild(i);
		int rightChildIndex = rightChild(i);
		int smallestIndex = i;

		if (leftChildIndex < heapSize && arr[leftChildIndex] < arr[i])
			smallestIndex = leftChildIndex;

		if (rightChildIndex < heapSize && arr[smallestIndex] > arr[rightChildIndex])
			smallestIndex = rightChildIndex;

		if (smallestIndex != i) {
			swap(i, smallestIndex, arr);
			heapify(smallestIndex, arr, heapSize);
		}
	}

	private int extractMin(int[] arr, int heapSize) {
		int root = -1;
		root = arr[0];
		arr[0] = arr[heapSize - 1];
		heapify(0, arr, heapSize);
		return root;
	}

	private int[] buildHeap(int[] arr) {

		// finding parent of last heap element index. This element essentially will be
		// the last element with children and need to heapify this and all previous
		// elements till entire heap becomes min heap
		int parentOfLastEleIndex = ((arr.length - 1) - 1) / 2;

		// now from this index heapify till root / first element
		while (parentOfLastEleIndex >= 0) {
			heapify(parentOfLastEleIndex, arr, arr.length);
			parentOfLastEleIndex--;
		}

		return arr;
	}

	private void heapSort(int[] arr) {

		buildHeap(arr);// Before starting with sorting, first it should be either min/max heap

		int heapSize = arr.length;

		while (heapSize > 0) {
			System.out.print(extractMin(arr, heapSize) + " ");
			heapSize--;
		}
	}

	public static void main(String[] args) {
		_03_HeapSort tree = new _03_HeapSort();
		int[] arr = { 4, 3, 7, 1, 10 };
		tree.heapSort(arr);
	}
}
