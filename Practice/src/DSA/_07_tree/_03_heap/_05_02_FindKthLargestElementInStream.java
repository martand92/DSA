package DSA._07_tree._03_heap;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=8HR8Ak5zuus
//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class _05_02_FindKthLargestElementInStream {

	int k;
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public _05_02_FindKthLargestElementInStream(int[] nums, int k) {
		this.k = k;
		for (int num : nums)
			add(num);
	}

	public int add(int val) {

		if (pq.size() < k) // first add k elements to min heap
			pq.add(val);
		else if (pq.peek() < val) { // if min heap size exceeds k then remove root(as its min ele) and add new
									// element only if new element is greater than current peek()
// if its lesser or equal than current peek() then adding it doesn't matter because it sits in root and heapification will again remove it

			pq.remove();
			pq.add(val);
		}
		return pq.peek();
	}

	public static void main(String[] args) {

		int[] nums = { 4, 5, 8, 2 };
		int k = 3;

		_05_02_FindKthLargestElementInStream obj = new _05_02_FindKthLargestElementInStream(nums, k);
		System.out.print(obj.add(3) + " ");
		System.out.print(obj.add(5) + " ");
		System.out.print(obj.add(10) + " ");
		System.out.print(obj.add(9) + " ");
		System.out.print(obj.add(4) + " ");

		// System.out.println(obj.pq);
	}
}
