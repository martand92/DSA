package DSA.Bucket4._07_tree._01_binaryTree;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
public class _04_SpiralTraversal {

	Node root;

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
			root.left = insert(root.left, d);// when new node formed, attach it to root.left /root.right

		else if (d > root.data)
			root.right = insert(root.right, d);

		return root;

	}

	public int findHeight(Node root) {

		if (root == null)
			return 0;

		return Math.max(findHeight(root.left) + 1, findHeight(root.right) + 1);
	}

	public static ArrayList<Integer> traversal(Node root, int level, int height, ArrayList<Integer> al) {

		if (root == null)
			return al;

		if (level == 0) {
			al.add(root.data);
			return al;
		}

		if (height % 2 != 0) {
			traversal(root.left, level - 1, height, al);
			traversal(root.right, level - 1, height, al);
		} else {
			traversal(root.right, level - 1, height, al);
			traversal(root.left, level - 1, height, al);
		}

		return al;
	}

	ArrayList<Integer> findSpiral(Node root) {

		int height = findHeight(root);
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < height; i++)
			al = traversal(root, i, i, al);

		return al;
	}

	public static void main(String[] args) {

		_04_SpiralTraversal tree = new _04_SpiralTraversal();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.findSpiral(tree.root));
	}
}
