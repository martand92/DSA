package DSA.Bucket4._07_tree._01_binaryTree.medium;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
public class _04_ZigZagPattern { // Also known as Spiral traversal

	Node root;
	ArrayList<Integer> al = new ArrayList<Integer>();

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
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

	int findHeight(Node root) {
		if (root == null)
			return 0;

		return Math.max(findHeight(root.left) + 1, findHeight(root.right) + 1);
	}

	ArrayList<Integer> levelOrder(Node root, int level, int i) {

		if (root == null)
			return al;

		if (level == 0) {
			al.add(root.data);
			return al;
		}

		if (i % 2 == 0) {
			levelOrder(root.left, level - 1, i);
			levelOrder(root.right, level - 1, i);
		} else {
			levelOrder(root.right, level - 1, i);
			levelOrder(root.left, level - 1, i);
		}

		return al;
	}

	ArrayList<Integer> zigZagTraversal(Node root) {
		int height = findHeight(root);

		for (int i = 0; i < height; i++)
			levelOrder(root, i, i);

		return al;
	}

	public static void main(String[] args) {

		_04_ZigZagPattern tree = new _04_ZigZagPattern();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.zigZagTraversal(tree.root);

		System.out.println(tree.al);
	}
}
