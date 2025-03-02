package DSA.Bucket3._07_tree._01_binaryTree.medium.MorisTraversal_BinaryThreaded;

import java.util.ArrayList;
import java.util.Collections;

public class _19_03_MorisTraversal_Postorder {

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

	public void insert() {
		root = new Node(50);
		root.left = new Node(20);
		root.right = new Node(70);
		root.left.left = new Node(30);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
	}

	public ArrayList<Integer> morisTraversal(Node node) {

		Node curr = node;

		while (curr != null) {

			// if right subtree is available
			if (curr.right != null) {

				Node prev = curr.right;

				while (prev.left != null && prev.left != curr)
					prev = prev.left;

				if (prev.left == null) {
					prev.left = curr;
					al.add(curr.data);
					curr = curr.right;

				} else {
					prev.left = null;
					curr = curr.left;
				}
			} else {
				al.add(curr.data);
				curr = curr.left;
			}
		}

		Collections.reverse(al);
		return al;

	}

	public static void main(String[] args) {

		_19_03_MorisTraversal_Postorder tree = new _19_03_MorisTraversal_Postorder();
		tree.insert();
		System.out.println(tree.morisTraversal(tree.root));
	}

}
