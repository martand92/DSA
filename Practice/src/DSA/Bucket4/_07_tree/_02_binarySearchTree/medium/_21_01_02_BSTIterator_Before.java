package DSA.Bucket4._07_tree._02_binarySearchTree.medium;

import java.util.*;

//To find before element in inorder using iterator
public class _21_01_02_BSTIterator_Before {

	Node root;
	Stack<Node> st = new Stack<Node>();

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void insert(int data) {
		root = insert(root, data);
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

	// first add all the ele on right to stack as before element should be found
	// (reverse of inorder : right->root->left)
	public void initialization(Node root) {
		while (root != null) {
			st.add(root);
			root = root.right;
		}
	}

	// then pop out right most element, check if it has left
	// if yes then add it to stack and add all its right nodes to stack
	public int before() {

		Node a = st.pop();
		Node left = a.left;
		Node right = null;

		if (left != null) {
			st.add(left);
			right = left.right;
		}

		while (right != null) {
			st.add(right);
			right = right.right;
		}
		return a.data;
	}

	public boolean hasBefore() {
		return !st.isEmpty();
	}

	public static void main(String[] args) {

		_21_01_02_BSTIterator_Before tree = new _21_01_02_BSTIterator_Before();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.initialization(tree.root);

		System.out.println(tree.before());
		System.out.println(tree.before());
		System.out.println(tree.before());
		System.out.println(tree.hasBefore());
		System.out.println(tree.before());
		System.out.println(tree.before());
		System.out.println(tree.before());
		System.out.println(tree.hasBefore());
		System.out.println(tree.before());
		System.out.println(tree.hasBefore());
	}

}
