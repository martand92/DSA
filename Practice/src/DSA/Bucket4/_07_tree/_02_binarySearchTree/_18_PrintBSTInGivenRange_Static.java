package DSA.Bucket4._07_tree._02_binarySearchTree;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1
public class _18_PrintBSTInGivenRange_Static {

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
			root.left = insert(root.left, d);

		else if (d > root.data)
			root.right = insert(root.right, d);

		return root;
	}

	public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al = printNearNodes(root, low, high, al);
		return al;
	}

	public static ArrayList<Integer> printNearNodes(Node root, int low, int high, ArrayList<Integer> al) {
		if (root == null)
			return al;

		printNearNodes(root.left, low, high, al);

		if (root.data >= low && root.data <= high)
			al.add(root.data);

		printNearNodes(root.right, low, high, al);
		return al;
	}

	public static void main(String[] args) {
		_18_PrintBSTInGivenRange_Static tree = new _18_PrintBSTInGivenRange_Static();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(printNearNodes(tree.root, 30, 70));

	}
}
