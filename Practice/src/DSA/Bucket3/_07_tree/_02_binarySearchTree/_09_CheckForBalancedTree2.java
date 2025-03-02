package DSA.Bucket3._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class _09_CheckForBalancedTree2 {

	Node root;
	int bf = 0;

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

	int height(Node root, int height) {

		if (root == null)
			return height;

		int left = height(root.left, height + 1);
		int right = height(root.right, height + 1);

		return Math.max(left, right);
	}

	// Check bf of each node and if Math.abs(bf) > 1 for any node, tree is not
	// balanced
	public boolean isBalanced(Node root) {

		if (root == null)
			return true;

		if (!isBalanced(root.left))
			return false;

		if (!isBalanced(root.right))
			return false;

		return (Math.abs(height(root.left, -1) - height(root.right, -1)) < 2);
	}

	public static void main(String[] args) {

		_09_CheckForBalancedTree2 tree = new _09_CheckForBalancedTree2();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.insert(90);
		tree.insert(100);

		System.out.println(tree.isBalanced(tree.root));
	}
}
