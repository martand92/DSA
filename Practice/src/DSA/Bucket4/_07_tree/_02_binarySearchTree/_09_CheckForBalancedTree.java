package DSA.Bucket4._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class _09_CheckForBalancedTree {

	Node root;

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

	int height(Node root) {

		if (root == null)
			return 0;

		return Math.max(height(root.left) + 1, height(root.right) + 1);
	}

	public boolean isBalanced(Node root) {

		if (root == null)
			return true;

		if (Math.abs(height(root.left) - height(root.right)) > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static void main(String[] args) {

		_09_CheckForBalancedTree tree = new _09_CheckForBalancedTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.insert(90);
		// tree.insert(100);

		System.out.println(tree.isBalanced(tree.root));
	}
}
