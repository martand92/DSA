package DSA.Bucket3._07_tree._01_binaryTree.medium;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class _05_LeftViewOfBinaryTree {

	Node root;
	ArrayList<Integer> al = new ArrayList<Integer>();

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

	public int findHeight(Node root, int height) {

		if (root == null)
			return height;

		int left = findHeight(root.left, height + 1);
		int right = findHeight(root.right, height + 1);

		return Math.max(left, right);
	}

	ArrayList<Integer> leftView(Node root) {
		// Your code here
		int height = findHeight(root, 0);

		for (int i = 0; i <= height; i++)
			levelOrder(root, i);

		return al;

	}

	public boolean levelOrder(Node root, int level) {

		if (root == null)
			return false;

		if (level == 0) {
			al.add(root.data);
			return true;
		}

		if (levelOrder(root.left, level - 1))
			return true;

		if (levelOrder(root.right, level - 1))
			return true;

		// for right view, reverse above order -> first root.right then root.left
		return false;

	}

	public static void main(String[] args) {
		_05_LeftViewOfBinaryTree tree = new _05_LeftViewOfBinaryTree();
		tree.insert(50);
		tree.insert(30);
		// tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.leftView(tree.root));
	}
}
