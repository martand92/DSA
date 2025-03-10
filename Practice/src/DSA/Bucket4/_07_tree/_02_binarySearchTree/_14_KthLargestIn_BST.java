package DSA.Bucket4._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
public class _14_KthLargestIn_BST {

	Node root;
	int val;
	static int k = 2;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void insert(int d) {
		root = insert(root, d);
	}

	public Node insert(Node root, int d) {

		if (root == null) {
			root = new Node(d);
			return root;
		}

		if (d < root.data)
			root.left = insert(root.left, d);

		else if (d > root.data)
			root.right = insert(root.right, d);

		return root;

	}

	public int kthLargest(Node root) {

		if (k == 0)
			return val;

		if (root == null)
			return val;

		val = kthLargest(root.right);

		k--;

		if (k == 0)
			return root.data;

		return kthLargest(root.left);
	}

	public static void main(String[] args) {

		_14_KthLargestIn_BST tree = new _14_KthLargestIn_BST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.kthLargest(tree.root));
	}
}
