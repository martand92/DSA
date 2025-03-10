package DSA.Bucket4._07_tree._02_binarySearchTree;

public class _07_SearchBST {

	Node root;

	static class Node {
		int key;
		Node left, right;

		Node(int d) {
			key = d;
			left = right = null;
		}
	}

	public void insert(int key) {
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

	public Node search(Node node, int x) {

		if (node == null)
			return null;

		if (node.key == x)
			return node;

		if (node.key < x)
			return search(node.right, x);
		if (node.key > x)
			return search(node.left, x);

		return null;

	}

	public static void main(String[] args) {

		_07_SearchBST tree = new _07_SearchBST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.search(tree.root, 10));
	}

}
