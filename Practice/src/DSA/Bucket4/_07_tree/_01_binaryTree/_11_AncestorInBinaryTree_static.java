package DSA.Bucket4._07_tree._01_binaryTree;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/ancestors-in-binary-tree/1
//check for this solution in above link as its complicated because of static method
public class _11_AncestorInBinaryTree_static {

	Node root;
	ArrayList<Integer> al = new ArrayList<Integer>();
	boolean found = false;

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

	public ArrayList<Integer> ancestors(Node root, int target) {

		// to stop proceedings when target is found
		if (found)
			return al;

		if (root == null)
			return al;

		if (root.data == target) {
			found = true;
			return al; // returning here cz parent to this node should be part of ancestor
		}

		ancestors(root.left, target);

		//System.out.println(root.data);

		ancestors(root.right, target);

		// when target found, while backtracking add all elements
		if (found)
			al.add(root.data);

		return al;
	}

	public static void main(String[] args) {
		_11_AncestorInBinaryTree_static tree = new _11_AncestorInBinaryTree_static();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.ancestors(tree.root, 80));

	}
}
