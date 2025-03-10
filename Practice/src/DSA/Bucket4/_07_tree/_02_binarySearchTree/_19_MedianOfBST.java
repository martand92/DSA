package DSA.Bucket4._07_tree._02_binarySearchTree;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/median-of-bst/1
public class _19_MedianOfBST {

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

	public static float findMedian(Node root) {
		// code here.
		ArrayList<Float> al = new ArrayList<Float>();

		al = getInOrderTraversal(root, al);
		int size = al.size();

		if (size % 2 != 0)
			return al.get(size / 2);
		else
			return (al.get(size / 2) + al.get(size / 2 - 1)) / 2;
	}

	public static ArrayList<Float> getInOrderTraversal(Node root, ArrayList<Float> al) {
		if (root == null)
			return al;

		al = getInOrderTraversal(root.left, al);
		al.add((float) root.data);
		al = getInOrderTraversal(root.right, al);
		return al;
	}

	public static void main(String[] args) {
		_19_MedianOfBST tree = new _19_MedianOfBST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(findMedian(tree.root));

	}
}
