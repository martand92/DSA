package DSA._07_tree._02_binarySearchTree.medium;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1
public class _15_NormalBSTToBalancedBST {

	Node root;
	Node root1;
	static ArrayList<Integer> al = new ArrayList<Integer>();

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

	// left skewed insert
	public Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		root.left = insert(root.left, data);
		return root;

	}

	public Node inorder(Node root) {
		if (root == null)
			return root;

		inorder(root.left);
		al.add(root.data);
		inorder(root.right);

		return root;
	}

	public Node buildBalancedTree(ArrayList<Integer> al, int start, int end) {

		if (start > end)
			return root1;

		int mid = (start + end) / 2;

		Node root1 = new Node(al.get(mid));

		root1.left = buildBalancedTree(al, start, mid - 1);
		root1.right = buildBalancedTree(al, mid + 1, end);

		return root1;
	}

	public static void main(String[] args) {
		_15_NormalBSTToBalancedBST tree = new _15_NormalBSTToBalancedBST();

		// Forming noraml BST which is left skewed first
		tree.insert(30);
		tree.insert(20);
		tree.insert(10);

		// Adding BST node data into arraylist as sorted : inorder
		tree.inorder(tree.root);

		// now building balanced BST with arraylist elements by picking mid element
		// everytime
		tree.root1 = tree.buildBalancedTree(al, 0, al.size() - 1);

	}
}
