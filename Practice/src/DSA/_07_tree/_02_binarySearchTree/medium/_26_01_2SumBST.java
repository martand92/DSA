package DSA._07_tree._02_binarySearchTree.medium;

import java.util.*;

//https://www.youtube.com/watch?v=ssL3sHwPeb4
public class _26_01_2SumBST {

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

	public void insert(int data) {
		root = insert(root, data);
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

	public ArrayList<Integer> inorder(Node node, ArrayList<Integer> al) { // O(N)

		if (node == null)
			return al;

		inorder(node.left, al);
		al.add(node.data); // SC : O(N)
		inorder(node.right, al);
		return al;
	}

	public boolean find2Sum(Node root, int target) { // O(N)
		ArrayList<Integer> al = new ArrayList<Integer>();
		al = inorder(root, al);

		int l = 0, r = al.size() - 1;

		while (l < r) {

			if (al.get(l) + al.get(r) > target)
				r--;
			else if (al.get(l) + al.get(r) < target)
				l++;
			else
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		_26_01_2SumBST tree = new _26_01_2SumBST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.find2Sum(tree.root, 50));

	}

}

//TC: O(N)
//SC: O(N) : This can be optimized to O(H) in next solution