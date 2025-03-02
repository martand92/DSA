package DSA.Bucket3._07_tree._03_heap.medium;

//https://www.youtube.com/watch?v=l8CuET0jlDU
import java.util.*;

//below solution works for any dimension of each array
public class _09_02_MergeKSortedArray {

//Algo :
//	1. Create an output array. 
//	2. Create a min-heap of size k and insert 1st element in all the arrays into the heap 
//	3. Repeat the following steps while the priority queue is not empty. 
//	…..a) Remove the minimum element from the heap (minimum is always at the root) and store it in the output array. 
//	…..b) Insert the next element from the array from which the element is extracted. If the array doesn’t have any more elements, then do nothing.

//As height of min-heap will remain k, hence for every added n element gets heapified in log(k) time
// Hence TC : Nlog(k)

	public static class Data {
		int val; // refers to actual data
		int arrPos; // refers to kth array in which this element is present of all k arrays
		int valPos; // refers to index of this val in kth array

		Data(int val, int arrPos, int valPos) {
			this.val = val;
			this.arrPos = arrPos;
			this.valPos = valPos;
		}

		private static ArrayList<Integer> mergeKSortedArray(ArrayList<ArrayList<Integer>> al) {

			ArrayList<Integer> finalList = new ArrayList<Integer>();
			PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
				public int compare(Data a, Data b) {
					return a.val - b.val;
				}
			});// min heap, sort by val in ascending order

			// first add all 0th index elements from all the arrays to min-heap
			// as each array is sorted, first indexed element contains the smallest element
			for (int i = 0; i < al.size(); i++)
				pq.add(new Data(al.get(i).get(0), i, 0));

			// now extract root of min-heap which will be the min element, then check for
			// next element from same root element's array and add it to min-heap
			while (!pq.isEmpty()) {

				Data node = pq.poll(); // as we are polling root everytime, the height of tree is maintained as k so
										// that heapification would take O(logK) time
				finalList.add(node.val);

				int arrPos = node.arrPos;
				int nextValPos = node.valPos + 1;

				if (nextValPos < al.get(arrPos).size()) // only if next element in the same array of current root
																// is
																// present then add it to min-heap
					pq.add(new Data(al.get(arrPos).get(nextValPos), arrPos, nextValPos));

			}

			return finalList;
		}

		public static void main(String[] args) {
			ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

			// in each list, elements are already sorted. Need to create final list where
			// all the elements will be sorted
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(3);
			al.add(list);

			list = new ArrayList<Integer>();
			list.add(2);
			list.add(4);
			list.add(6);
			al.add(list);

			list = new ArrayList<Integer>();
			list.add(0);
			list.add(9);
			list.add(10);
			list.add(11);
			al.add(list);

			System.out.println(mergeKSortedArray(al));
		}
	}

}

//TC : Nlog(k)
//SC :  