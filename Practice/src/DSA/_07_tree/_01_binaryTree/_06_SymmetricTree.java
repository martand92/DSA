package DSA._07_tree._01_binaryTree;

//https://practice.geeksforgeeks.org/problems/symmetric-tree/1
public class _06_SymmetricTree {

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

//	public void insert(int d) {
//		root = insert(root, d);
//	}

	public Node insert() {

//		if (root == null) {
//			root = new Node(d);
//			return root;
//		}
//
//		if (d < root.data)
//			root.left = insert(root.left, d);
//
//		else if (d > root.data)
//			root.right = insert(root.right, d);

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);

		root.left.left = new Node(3);
		root.left.right = new Node(4);

		root.right.left = new Node(4);
		root.right.right = new Node(3);

		return root;

	}

	public boolean isSymmetric(Node root) {

		return isMirror(root.left, root.right);
	}

	public boolean isMirror(Node root1, Node root2) {

		if (root1 == null && root2 == null) // Checking if both left & right traversals have reached end together
			return true;

		// Checking if either left or right traversals have reached end alone
		if (root1 == null && root2 != null || root1 != null && root2 == null)
			return false;

		if (root1.data != root2.data)
			return false;

		if (!isMirror(root1.left, root2.right))
			return false;

		if (!isMirror(root1.right, root2.left))
			return false;

		return true;
	}

	public static void main(String[] args) {
		_06_SymmetricTree tree = new _06_SymmetricTree();
		tree.insert();
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);

		System.out.println(tree.isSymmetric(tree.root));
	}
}
