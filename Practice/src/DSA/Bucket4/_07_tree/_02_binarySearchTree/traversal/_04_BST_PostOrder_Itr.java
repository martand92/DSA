package DSA.Bucket4._07_tree._02_binarySearchTree.traversal;

import java.util.Stack;

public class _04_BST_PostOrder_Itr {

	Node root;
	Stack<Node> st1 = new Stack<>();
	Stack<Node> st2 = new Stack<>();

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

	// Iterative
	public Node insert(Node root, int key) {

		Node prev = null;

		if (root == null) {
			root = new Node(key);
			return root;
		}

		Node temp = root;

		while (temp != null) {

			prev = temp;

			if (key < temp.key)
				temp = temp.left;
			else if (key > temp.key)
				temp = temp.right;

		}

		if (prev.key > key)
			prev.left = new Node(key);
		else
			prev.right = new Node(key);

		return root;
	}

	public void postorder() {
		postorder(root);
	}

	// Iterative

	// As post-order is left right and root. So need to store root at last and then
	// right and then left in stack as answer
	public void postorder(Node node) {

		st1.push(node);
		while (!st1.isEmpty()) {
			Node n = st1.pop();
			st2.push(n);

			if (n.left != null)
				st1.push(n.left);

			if (n.right != null)
				st1.push(n.right);
		}

		while (!st2.isEmpty())
			System.out.print(st2.pop().key + " ");
	}

	public static void main(String[] args) {
		_04_BST_PostOrder_Itr tree = new _04_BST_PostOrder_Itr();
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
