package DSA.Bucket4._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/array-to-bst4443/1

/* Below implementation can also be used to balance BST (without AVL / Red black) 
 * where inorder of BST results in sorted list using which balanced BST can be created
 */
public class _15_ArrayToBST_Imp {

	Node root;

	static class Node {

		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public Node binarySearchTree(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);

		node.left = binarySearchTree(arr, start, mid - 1);
		node.right = binarySearchTree(arr, mid + 1, end);

		return node;
	}

	public static void main(String[] args) {

		_15_ArrayToBST_Imp tree = new _15_ArrayToBST_Imp();

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };// array is sorted

		int start = 0, end = nums.length - 1;

		tree.root = tree.binarySearchTree(nums, start, end);

	}

}