package DSA.Bucket3._07_tree._01_binaryTree.medium;

public class _14_BoundaryTraversal {

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

	public void boundarytraversal(Node node) {

	}

	public static void main(String[] args) {

		_14_BoundaryTraversal tree = new _14_BoundaryTraversal();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.boundarytraversal(tree.root);
	}

}
