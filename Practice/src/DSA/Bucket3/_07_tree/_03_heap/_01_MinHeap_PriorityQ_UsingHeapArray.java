package DSA.Bucket3._07_tree._03_heap;

//Priority Queue implementation using heap
public class _01_MinHeap_PriorityQ_UsingHeapArray {

	int[] heapArr;
	int capacity;// max size of min heap during initialization;
	int heapSize; // current no of elements in min heap. This is fluctuating between 0 to
					// "capacity" value

	_01_MinHeap_PriorityQ_UsingHeapArray(int capacity) {
		this.capacity = capacity;
		this.heapSize = 0;
		heapArr = new int[this.capacity];
	}

	// ---------- Utility functions --------------//

	// if heapSize=1 (contains only 1 root node) then height = 0
	// if heapSize>=2 and <=3 then height = 1. log(2) = 1, log(3) = 1.58 but floor =
	// 1
	// if heapSize>=4 and <=7 then height = 2
	// if heapSize>=8 and <=15 then height= 3 .. etc
	private int height() {
		// if heapSize = 7, then math.log (heapSize + 1) = 3
		// return (int) Math.ceil(Math.log(heapSize + 1) / Math.log(2)) - 1;
		return (int) Math.floor(Math.log(heapSize));
	}

	// Parent of current element thats getting inserted at "index" of an array
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// Left child of node @index i
	private int leftChild(int i) {
		return (2 * i) + 1;
	}

	// right child of node @index i
	private int rightChild(int i) {
		return (2 * i) + 2;
	}

	private void swap(int a, int b) {
		int temp = heapArr[a];
		heapArr[a] = heapArr[b];
		heapArr[b] = temp;
	}

	// O(N)
	private void printArray() {
		for (int i = 0; i < heapSize; i++)
			System.out.println(heapArr[i]);
	}

	// O(N)
	private void printHeap() {
		for (int i = 0; i <= heapSize / 2; i++)
			System.out.print("Parent : " + heapArr[i] + " Left Child : " + heapArr[(2 * i) + 1] + " Right Child : "
					+ heapArr[(2 * i) + 2]);

		System.out.println();
	}

	// ---------- Utility functions --------------//
	//
	//
	//
	// As heap is not sorted/ordered, searching key is done linearly O(N) unlike BST
	// where it was sorted and binary search was done O(Log N)
	private int linearSearch(int key) {
		for (int i = 0; i < heapSize; i++) { // will only search for heap size and not entire capacity as heap size = no
												// of elements in heap
			if (heapArr[i] == key)
				return i;
		}
		return Integer.MAX_VALUE;
	}

	// Insert new node/key and heapify if needed
	private void insert(int key) {

		if (heapSize == capacity) {
			System.out.println("Heap Overflow");
			return;
		}

		heapSize++;

		// Index of the array where this element should be inserted
		int index = heapSize - 1; // index of heap Array ranges from 0 to capacity -1
		heapArr[index] = key; // inserting given key into array at "index"

		// Run this while till child element value > it's parent (non-heap property)
		while (index != 0 && heapArr[parent(index)] > heapArr[index]) {
			swap(index, parent(index));
			index = parent(index); // when last child element is swapped with its parent, now this swapped parent
									// should also be compared with its parent
		}

	}

	private void decreaseKey(int index) {
		heapArr[index] = Integer.MIN_VALUE;

		// again we are doing swapping between child and its parent to push small value
		// to top of min heap
		while (index != 0 && heapArr[index] < heapArr[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}

	}

	// delete given node/key and heapify if needed
	// Step 1: Search for the node to be deleted
	// Step 2: To delete given node, first replace its value with Integer.MIN_VALUE
	// Step 3: Heapify current tree by sending this replaced node to root of tree
	// (as it will be the least value in current tree)
	// Step 4: extractMin()
	private int deleteKey(int key) {

		int index = linearSearch(key);

		if (index == Integer.MAX_VALUE)
			return -1;

		int deletedElement = heapArr[index];

		decreaseKey(index);
		extractMin();

		return deletedElement;
	}

	// Get least elements from tree
	private int getMin() {
		if (heapSize == 0)
			return Integer.MAX_VALUE;

		else
			return heapArr[0];
	}

// Need to modify tree after inserting or deleting for tree to be heap
//	private void heapify(int i) {
//		int leftChildIndex = leftChild(i);
//		int rightChildIndex = rightChild(i);
//		int smallestIndex = i;
//
//		if (leftChildIndex < heapSize && heapArr[leftChildIndex] < heapArr[i])
//			smallestIndex = leftChildIndex;
//
//		if (rightChildIndex < heapSize && heapArr[rightChildIndex] < heapArr[smallestIndex])
//			smallestIndex = rightChildIndex;
//
//		// recur till smallest element is not parent
//		if (smallestIndex != i) {
//			// swap found smallest element with root element to maintain heap property
//			swap(i, smallestIndex);
//			heapify(smallestIndex); // recursively call again on smallest index as root element for that subtree
//		}
//
//	}

	// Heapification happens downward
	private void heapify(int i, int leftChildIndex, int rightChildIndex, int smallestIndex) {

		if (leftChildIndex < heapSize && heapArr[leftChildIndex] < heapArr[i]) // here heapify scope is only upto
																				// heapSize and not arr.length()
			smallestIndex = leftChildIndex;

		if (rightChildIndex < heapSize && heapArr[rightChildIndex] < heapArr[smallestIndex])
			smallestIndex = rightChildIndex;

		if (smallestIndex == i)
			return;

		swap(i, smallestIndex);
		heapify(smallestIndex, leftChild(smallestIndex), rightChild(smallestIndex), smallestIndex);
	}

	// Get and delete least elements from tree
	private int extractMin() {
		if (heapSize == 0)
			return Integer.MAX_VALUE;

		// If only 1 element in tree, then it would be the least element
		if (heapSize == 1) {
			heapSize--;
			return heapArr[0];

		} else {
			// extract heapArr[0] as it would be the least element
			int root = heapArr[0];
			heapArr[0] = heapArr[heapSize - 1]; // replace root element with last element in array
			// Note : In above step only root node's value which gets extracted is replaced
			// with last node. Last node is not yet deleted. So currently, root node value =
			// last node value

			heapSize--;
			// Note: here heapsize is reduced after extraction. Even though last element of
			// tree or Array is still present as duplicate of root, its not relevant as
			// heapSize pointer is now pointing to heapArray.size - 2
			// So when new element gets inserted to this heap array it will basically
			// override this last element (duplicate of root)

			// heapify(0);
			heapify(0, leftChild(0), rightChild(0), 0); // heapify from root index to
			// (last - 1)th element
			return root;
		}
	}

	public static void main(String[] args) {

		_01_MinHeap_PriorityQ_UsingHeapArray minHeap = new _01_MinHeap_PriorityQ_UsingHeapArray(10);

		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);

		minHeap.linearSearch(84);
		minHeap.deleteKey(84);
		minHeap.getMin();
		minHeap.extractMin();
		System.out.println(minHeap.height());
		minHeap.printArray();
		minHeap.printHeap();

	}
}
