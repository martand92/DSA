package DSA.Bucket4._07_tree._03_heap;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
public class _07_MergeTwoBinaryMaxHeaps_Nice {

	public static int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}

	public static int getRightChildIndex(int i) {
		return 2 * i + 2;
	}

	public static int[] swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}

	// Heapification happens downward
	public static int[] heapify(int[] arr, int i, int leftChildIndex, int rightChildIndex, int largestIndex) {

		if (leftChildIndex < arr.length && arr[largestIndex] < arr[leftChildIndex])
			largestIndex = leftChildIndex;

		if (rightChildIndex < arr.length && arr[largestIndex] < arr[rightChildIndex])
			largestIndex = rightChildIndex;

		if (i == largestIndex) {
			return arr;
		}

		swap(arr, i, largestIndex);

		// Below statement is because after swapping largest number, you should also
		// check if below tree also follows maxHeap property. If it doesn't then heapify
		// again
		return heapify(arr, largestIndex, getLeftChildIndex(largestIndex), getRightChildIndex(largestIndex),
				largestIndex);

	}

	public static void main(String[] args) {
//		int[] a = { 10, 5, 6, 2 };
//		int[] b = { 12, 7, 9 };

		int[] a = { 6, 5, 4 };
		int[] b = { 12, 7, 2 };

		// Idea is array sorted in reverse order = Max heap
		int[] arr = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++)
			arr[i] = a[i];

		for (int i = 0; i < b.length; i++)
			arr[a.length + i] = b[i];

		// You have to heapify from lower level to higher level as its maxheap
		// In _03_MinHeap_Sort you started from upper level to lower level
		for (int i = arr.length / 2 - 1; i >= 0; i--)
			arr = heapify(arr, i, getLeftChildIndex(i), getRightChildIndex(i), i);

		System.out.println(Arrays.toString(arr));

	}
}
