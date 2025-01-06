package DSA._07_tree._02_binarySearchTree;

public class _23_FindCeil {
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

	// ceil is greater than given key but closest, if key is present then itself is
	// ceil
	public int findCeil(Node node, int x, int ceil) {

		if (node == null)
			return ceil;

		if (node.key == x)
			return node.key;

		if (node.key < x)
			return findCeil(node.right, x, ceil); // if need to find floor, then update this to node.key

		if (node.key > x)
			return findCeil(node.left, x, node.key);

		return ceil;
	}

	public static void main(String[] args) {

		_23_FindCeil tree = new _23_FindCeil();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(90);

		System.out.println(tree.findCeil(tree.root, 80, 0));
	}

}
