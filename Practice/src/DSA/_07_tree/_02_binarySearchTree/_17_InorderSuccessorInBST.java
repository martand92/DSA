package DSA._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
public class _17_InorderSuccessorInBST {

	Node root;
	boolean found;
	Node nextNode;

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

	public Node inorderSuccessor(Node root, int x) {

		if (root == null)
			return root;

		inorderSuccessor(root.left, x);

		if (found && nextNode != null)
			return nextNode;

		if (found && nextNode == null) {
			nextNode = root;
			return nextNode;
		}

		if (root.data == x)
			found = true;

		inorderSuccessor(root.right, x);

		return nextNode;
	}

	public static void main(String[] args) {

		_17_InorderSuccessorInBST tree = new _17_InorderSuccessorInBST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		Node n = tree.inorderSuccessor(tree.root, 80);

		if (n != null)
			System.out.println(n.data);
		else
			System.out.println(n);

	}
}
