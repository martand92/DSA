package DSA.Bucket3._07_tree._02_binarySearchTree.medium;

//https://practice.geeksforgeeks.org/problems/array-to-bst4443/1
public class _15_SortedArrToBST_Imp {

	Node root;
	int l = 0, r = 0;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public Node insert(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;

		Node root = new Node(arr[mid]);

		root.left = insert(arr, start, mid - 1);
		root.right = insert(arr, mid + 1, end);

		return root;
	}

	public Node preorder(Node root) {
		if (root == null)
			return root;

		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		return root;
	}

	public static void main(String[] args) {
		_15_SortedArrToBST_Imp tree = new _15_SortedArrToBST_Imp();
		//int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int[] nums = { 1, 2, 3, 4};
		int start = 0;
		int end = nums.length - 1;

		tree.root = tree.insert(nums, start, end);
		tree.preorder(tree.root);

	}
}
