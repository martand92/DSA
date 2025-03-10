package DSA.Bucket4._07_tree._02_binarySearchTree.traversal;

import java.util.Stack;

public class _02_BST_InOrder_Itr_Imp_Notunderstood {

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

	// Iteratively insert
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

	public void inorder() {
		inorder(root);
	}

	// Iterative
	public void inorder(Node node) {

		Stack<Node> st = new Stack<Node>();

		while (true) {

			if (node != null) {
				st.push(node);
				node = node.left;

			} else {

				if (st.isEmpty())
					break;

				node = st.pop();
				System.out.print(node.key + " ");
				node = node.right;
			}
		}
	}

	public static void main(String[] args) {
		_02_BST_InOrder_Itr_Imp_Notunderstood tree = new _02_BST_InOrder_Itr_Imp_Notunderstood();
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
