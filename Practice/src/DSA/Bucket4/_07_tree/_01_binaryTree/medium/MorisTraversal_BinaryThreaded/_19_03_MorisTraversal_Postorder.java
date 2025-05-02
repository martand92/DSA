package DSA.Bucket4._07_tree._01_binaryTree.medium.MorisTraversal_BinaryThreaded;

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
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(6);
	}

	public ArrayList<Integer> morisTraversal(Node root) {

		Node curr = root;

		while (curr != null) {

			// if right subtree is available
			if (curr.right != null) {

				Node node = curr.right;

				while (node.left != null && node.left != curr)
					node = node.left;

				if (node.left == null) {
					node.left = curr;
					al.add(curr.data);
					curr = curr.right;

				} else {
					node.left = null;
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
