package DSA.Bucket4._07_tree._02_binarySearchTree.traversal;

public class _05_BST_LevelOrder_Recursion {

	Node root;

	static class Node {
		int key;
		Node left, right;

		Node(int d) {
			key = d;
			left = right = null;
		}
	}

	void insert(int key) {
		root = insert(root, key);
	}

	public Node insert(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		else if (key < root.key)
			root.left = insert(root.left, key);

		else if (key > root.key)
			root.right = insert(root.right, key);

		return root;
	}

	public static int findHeight(Node node) {

		if (node == null)
			return 0;

		return Math.max(findHeight(node.left) + 1, findHeight(node.right) + 1);
	}

	public static void traverse(Node node, int height) {

		if (node == null)
			return;

		if (height == 0) {
			System.out.print(node.key + " ");
			return;
		}

		traverse(node.left, height - 1);
		traverse(node.right, height - 1);
	}

	public void levelOrderTraversal(Node node) {

		int height = findHeight(node);

		for (int i = 0; i <= height; i++) {
			traverse(node, i);
		}

	}

	public static void main(String[] args) {
		_05_BST_LevelOrder_Recursion tree = new _05_BST_LevelOrder_Recursion();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.levelOrderTraversal(tree.root);
	}

}
