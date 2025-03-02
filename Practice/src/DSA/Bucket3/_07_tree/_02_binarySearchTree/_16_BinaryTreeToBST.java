package DSA.Bucket3._07_tree._02_binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

//https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
public class _16_BinaryTreeToBST {

	Node root;
	ArrayList<Integer> al = new ArrayList<Integer>();
	int i = 0;

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

	Node loadArrayListForSorting(Node root) {
		if (root == null)
			return root;

		loadArrayListForSorting(root.left);
		al.add(root.data);
		loadArrayListForSorting(root.right);

		return root;
	}

	Node updateCurrentTree(Node root) {

		if (root == null)
			return root;

		updateCurrentTree(root.left);
		root.data = al.get(i++);
		updateCurrentTree(root.right);

		return root;
	}

	Node binaryTreeToBST(Node root) {

		// Your code here
		root = loadArrayListForSorting(root);
		Collections.sort(al);
		root = updateCurrentTree(root);
		return root;
	}

	public static void main(String[] args) {
		_16_BinaryTreeToBST tree = new _16_BinaryTreeToBST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(40);
		tree.insert(20);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.binaryTreeToBST(tree.root);

	}
}
