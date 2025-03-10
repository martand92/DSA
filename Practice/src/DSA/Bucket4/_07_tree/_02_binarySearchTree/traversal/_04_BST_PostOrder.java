package DSA.Bucket4._07_tree._02_binarySearchTree.traversal;

public class _04_BST_PostOrder {

	Node root;

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

	public void postorder() {
		postorder(root);
	}

	// Overloaded method
	public void postorder(Node root) {

		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.println(root.key);

	}

	public static void main(String[] args) {
		_04_BST_PostOrder tree = new _04_BST_PostOrder();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.postorder();
	}

}
