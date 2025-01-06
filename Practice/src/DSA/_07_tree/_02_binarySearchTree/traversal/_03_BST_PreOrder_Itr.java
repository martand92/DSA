package DSA._07_tree._02_binarySearchTree.traversal;

import java.util.Stack;

public class _03_BST_PreOrder_Itr {

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

	public void preorder() {
		preorder(root);
	}

	// Iterative. First insert root, then pop root -> print & then right and left
	// nodes to stack to first access left and then right for preorder print
	public void preorder(Node node) {

		Stack<Node> st = new Stack<Node>();
		st.push(node);

		while (!st.isEmpty()) {

			node = st.pop();

			System.out.print(node.key + " ");

			if (node.right != null)
				st.push(node.right);

			if (node.left != null)
				st.push(node.left);
		}

	}

	public static void main(String[] args) {
		_03_BST_PreOrder_Itr tree = new _03_BST_PreOrder_Itr();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.preorder();
	}

}
