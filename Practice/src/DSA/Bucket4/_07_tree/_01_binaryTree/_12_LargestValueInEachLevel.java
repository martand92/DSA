package DSA.Bucket4._07_tree._01_binaryTree;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/largest-value-in-each-level/1
public class _12_LargestValueInEachLevel {

	Node root;
	int currHeight = -1, height = -1;

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

	public int findHeight(Node root) {

		if (root == null) {
			if (currHeight > height)
				height = currHeight;

			return height;
		}

		currHeight++;
		findHeight(root.left);
		findHeight(root.right);
		currHeight--;

		return height;
	}

	public int levelOrder(Node root, int level, int largeVal) {

		if (root == null)
			return largeVal;

		if (level == 0)
			return Math.max(largeVal, root.data);

		largeVal = levelOrder(root.left, level - 1, largeVal);
		largeVal = levelOrder(root.right, level - 1, largeVal);

		return largeVal;
	}

	public ArrayList<Integer> largestValues(Node root) {
		// code here
		int height = findHeight(root);
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i <= height; i++) {

			al.add(levelOrder(root, i, Integer.MIN_VALUE));
		}

		return al;
	}

	public static void main(String[] args) {
		_12_LargestValueInEachLevel tree = new _12_LargestValueInEachLevel();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.largestValues(tree.root));

	}
}
