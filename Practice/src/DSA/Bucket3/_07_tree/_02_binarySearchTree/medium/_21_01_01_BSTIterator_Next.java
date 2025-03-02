package DSA.Bucket3._07_tree._02_binarySearchTree.medium;

import java.util.*;

//To find next element in inorder using iterator
public class _21_01_01_BSTIterator_Next {

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

	// first add all the ele on left to stack as inorder is left->root->right
	public void initialization(Node root) {
		while (root != null) {
			st.add(root);
			root = root.left;
		}
	}

	// then pop out left most element, check if it has right
	// if yes then add it to stack and add all its left nodes to stack
	public int next() {

		Node a = st.pop();
		Node right = a.right;
		Node left = null;

		if (right != null) {
			st.add(right);
			left = right.left;
		}

		while (left != null) {
			st.add(left);
			left = left.left;
		}
		return a.data;
	}

	public boolean hasNext() {
		return !st.isEmpty();
	}

	public static void main(String[] args) {

		_21_01_01_BSTIterator_Next tree = new _21_01_01_BSTIterator_Next();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.initialization(tree.root);

		System.out.println(tree.next());
		System.out.println(tree.next());
		System.out.println(tree.next());
		System.out.println(tree.hasNext());
		System.out.println(tree.next());
		System.out.println(tree.next());
		System.out.println(tree.next());
		System.out.println(tree.hasNext());
		System.out.println(tree.next());
		System.out.println(tree.hasNext());
	}

}

//TC : O(H) because storing only H elements in stack at any moment and not all N elements
//SC : O(1), though you are pushing N elements to stack and popping out, but for that you are performing "n" next operations. 
//Hence to perform 1 next operation, it will take N pushes / N operation ~ O(1)