package DSA.Bucket4._07_tree._02_binarySearchTree.medium;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
public class _20_CommonNodeIn2BST {

	Node root1;
	Node root2;
	static HashSet<Integer> hs = new HashSet<Integer>();
	static ArrayList<Integer> result = new ArrayList<Integer>();

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void insert(int d, int rootNumber) {
		if (rootNumber == 1)
			root1 = insert(root1, d);
		else
			root2 = insert(root2, d);
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

	public static ArrayList<Integer> findCommon(Node root1, Node root2) {

		getInorderTraversal(root1, true);
		getInorderTraversal(root2, false);

		return result;
	}

	public static ArrayList<Integer> getInorderTraversal(Node root, boolean first) {

		if (root == null)
			return result;

		result = getInorderTraversal(root.left, first);

		if (!hs.add(root.data))
			result.add(root.data);

		return getInorderTraversal(root.right, first);
	}

	public static void main(String[] args) {
		_20_CommonNodeIn2BST tree = new _20_CommonNodeIn2BST();

		tree.insert(50, 1);
		tree.insert(30, 1);
		tree.insert(20, 1);
		tree.insert(40, 1);
		tree.insert(70, 1);
		tree.insert(60, 1);
		tree.insert(80, 1);

		tree.insert(50, 2);
		tree.insert(30, 2);
		tree.insert(20, 2);
		tree.insert(45, 2);
		tree.insert(55, 2);
		tree.insert(65, 2);
		tree.insert(80, 2);

		System.out.println(findCommon(tree.root1, tree.root2));

	}
}
