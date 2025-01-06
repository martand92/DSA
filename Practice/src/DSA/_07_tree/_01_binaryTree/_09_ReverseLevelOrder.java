package DSA._07_tree._01_binaryTree;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
public class _09_ReverseLevelOrder {

	Node root;
	int currHeight = -1, height = -1;
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

	public int findHeight(Node node) {
		if (node == null) {
			if (currHeight > height)
				height = currHeight;

			return height;
		}

		currHeight++;
		findHeight(node.left);
		findHeight(node.right);
		currHeight--;

		return height;
	}

	public ArrayList<Integer> reverseLevelOrder(Node node) {
		// code here
		height = findHeight(node);
		for (int i = height; i >= 0; i--)
			reverseLevelOrder(node, i);

		return al;
	}

	public ArrayList<Integer> reverseLevelOrder(Node node, int level) {

		if (node == null)
			return al;

		if (level == 0)// when level reaches to height, then add
			al.add(node.data);

		reverseLevelOrder(node.left, level - 1);
		reverseLevelOrder(node.right, level - 1);

		return al;
	}

	public static void main(String[] args) {
		_09_ReverseLevelOrder tree = new _09_ReverseLevelOrder();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.reverseLevelOrder(tree.root);
		System.out.println(tree.al);

	}
}
