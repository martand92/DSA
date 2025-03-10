package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.easy;

// https://practice.geeksforgeeks.org/problems/linked-list-matrix/1
public class LL_31_ImplementMatrix {

	static class Node {
		int data;
		Node right, down;

		Node(int d) {
			data = d;
			right = null;
			down = null;
		}
	}

	public void matrixPatter(int[][] arr) {

		@SuppressWarnings("unused")
		Node head = null;
		Node top = null;
		Node prev = null;
		Node start = null;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				Node newNode = new Node(arr[i][j]);

				if (i == 0 && j == 0)
					head = newNode;

				if (j == 0)
					start = newNode;

				if (prev != null)
					prev.right = newNode;

				if (i != 0) {
					top.down = newNode;
					top = top.right;
				}

				prev = newNode;

			}

			top = start;

			prev = null;
		}
	}

	public static void main(String[] args) {

		LL_31_ImplementMatrix lList = new LL_31_ImplementMatrix();

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		lList.matrixPatter(arr);
	}

}
