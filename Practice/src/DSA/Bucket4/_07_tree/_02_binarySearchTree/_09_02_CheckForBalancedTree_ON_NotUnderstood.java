package DSA.Bucket4._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class _09_02_CheckForBalancedTree_ON_NotUnderstood {

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

	int checkHeight(Node root) { // O(N)

		if (root == null)
			return 0;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return -1; // left subtree not balanced

		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1; // right subtree not balanced

		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1; // current node not balanced

		return Math.max(leftHeight, rightHeight) + 1; // return height
	}

	public boolean isBalanced(Node root) {

		if (checkHeight(root) != -1)
			return true;

		return false;
	}

	public static void main(String[] args) {

		_09_02_CheckForBalancedTree_ON_NotUnderstood tree = new _09_02_CheckForBalancedTree_ON_NotUnderstood();

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
