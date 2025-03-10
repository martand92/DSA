package DSA.Bucket4._07_tree._03_heap.medium;

import java.util.*;

//https://www.youtube.com/watch?v=cjQNm2eS6Lw
//https://www.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
public class _13_FindMedianInStream_Hard {

	public static void findMedian(int[] arr) {
		// maxHeap, as you need to arrange first half elements in descending order
		PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(Collections.reverseOrder());

		// minHeap as you need to arrange second half elements in ascending order
		PriorityQueue<Integer> greater = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {

			// additional element is added to smaller heap, so smaller.size() > or = to
			// greater.size()

			if (smaller.size() == 0)
				smaller.add(arr[i]);

			else if (smaller.size() > greater.size()) { // if smaller heap has an additional element

				if (arr[i] > smaller.peek()) // if next stream element is > smaller top, then move it to greater heap
					greater.add(arr[i]);

				else { // if next stream element is < smaller top, you need to add it to smaller heap
						// but pop smaller's root & add to greater heap to balance both sides to find
						// median
					smaller.add(arr[i]);
					greater.add(smaller.poll());
				}

			} else { // when both heap sizes are equal

				if (arr[i] < smaller.peek())
					smaller.add(arr[i]);

				else {
					greater.add(arr[i]);
					smaller.add(greater.poll());
				}

			}

			if (smaller.size() != greater.size())
				System.out.println("Median " + smaller.peek()); // as smaller will have 1 extra
			else
				System.out.println("Median " + (smaller.peek() + greater.peek()) / 2);
		}

	}

	public static void main(String[] args) {
		int[] x = { 5, 15, 1, 3 };
		findMedian(x);
	}

}
