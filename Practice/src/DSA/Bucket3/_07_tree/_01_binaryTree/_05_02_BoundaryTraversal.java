package DSA.Bucket3._07_tree._01_binaryTree;

public class _05_02_BoundaryTraversal {

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

	public int findHeight(Node root, int height) {

		if (root == null)
			return height;

		int left = findHeight(root.left, height + 1);
		int right = findHeight(root.right, height + 1);

		return Math.max(left, right);
	}

	public void levelOrder(Node root) {
		// Your code here
		int height = findHeight(root, -1); // consider root as height 0

		// not go upto height value as leaf nodes should not be considered
		for (int i = 0; i < height; i++) // left side nodes except leaf boundary nodes
			leftView(root, i);

		printLeafNodes(root);// just print nodes with both left and right = null

		for (int i = height - 1; i >= 1; i--) // from bottom to up fro right boundary nodes
			rightView(root, i);

		return;

	}

	public boolean leftView(Node root, int level) {

		if (root == null)
			return false;

		if (level == 0) {
			System.out.print(root.data + " ");
			return true;
		}

		if (root.left != null) {
			if (leftView(root.left, level - 1))
				return true;
		} else {
			if (leftView(root.right, level - 1))
				return true;
		}

		// for right view, reverse above order -> first root.right then root.left

		return false;

	}

	public void printLeafNodes(Node node) {
		if (node == null)
			return;

		if (node.left == null && node.right == null)
			System.out.print(node.data + " ");

		printLeafNodes(node.left);
		printLeafNodes(node.right);
	}

	public boolean rightView(Node root, int level) {

		if (root == null)
			return false;

		if (level == 0) {
			System.out.print(root.data + " ");
			return true;
		}

		if (root.right != null) {
			if (rightView(root.right, level - 1))
				return true;
		} else {
			if (rightView(root.left, level - 1))
				return true;
		}

		// for right view, reverse above order -> first root.right then root.left

		return false;

	}

	public static void main(String[] args) {
		_05_02_BoundaryTraversal tree = new _05_02_BoundaryTraversal();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.levelOrder(tree.root);
	}
}
