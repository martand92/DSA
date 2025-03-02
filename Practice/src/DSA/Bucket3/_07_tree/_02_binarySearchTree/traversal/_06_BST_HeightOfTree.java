package DSA.Bucket3._07_tree._02_binarySearchTree.traversal;

public class _06_BST_HeightOfTree {

	Node root;
	int currHeight = -1, maxHeight = -1;

	static class Node {
		int key;
		Node left, right;

		Node(int d) {
			key = d;
			left = null;
			right = null;
		}
	}

	void insert(int key) {
		root = insert(root, key);
	}

	// Overloaded method
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

	public int findHeight() {
		return findHeight(root, -1); // send 0 if height of root = 1, else send -1 if height of root = 0
	}

	// Overloaded method
	public int findHeight(Node root, int height) {

		if (root == null)
			return height;

		int left = findHeight(root.left, height + 1);
		int right = findHeight(root.right, height + 1);

		return Math.max(left, right);
	}

	public static void main(String[] args) {
		_06_BST_HeightOfTree tree = new _06_BST_HeightOfTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.findHeight());
	}

}
