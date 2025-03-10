package DSA.Bucket4._07_tree._02_binarySearchTree.traversal;

public class _02_BST_InOrder {

	Node root;

//	_02_BinarySearchTree_Recursion() {
//		root = null;
//	}

//	_02_BinarySearchTree_Recursion(int value) {
//		root = new Node(value);
//	}

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

	public void inorder() {
		inorder(root);
	}

	// Overloaded method
	public void inorder(Node root) {

		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		_02_BST_InOrder tree = new _02_BST_InOrder();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder();
	}

}
