package DSA.Bucket4._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/check-for-bst/1
public class _12_01_isBST {

	Node root;
	int val = Integer.MIN_VALUE;

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

	// Inorder traversal of BST is always sorted
	boolean isBST(Node root) {

		if (root == null)
			return true;

		if (!isBST(root.left))
			return false;

		if (val > root.data)
			return false;

		val = root.data;

		return isBST(root.right);
	}

	public static void main(String[] args) {

		_12_01_isBST tree = new _12_01_isBST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.isBST(tree.root));
	}
}
