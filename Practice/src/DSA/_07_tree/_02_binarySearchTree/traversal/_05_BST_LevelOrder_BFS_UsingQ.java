package DSA._07_tree._02_binarySearchTree.traversal;

import java.util.*;

public class _05_BST_LevelOrder_BFS_UsingQ {

	Node root;
	Queue<Node> q = new ArrayDeque<Node>();

	static class Node {
		int key;
		Node left, right;

		Node(int d) {
			key = d;
			left = null;
			right = null;
		}
	}

	void insert(int key) {
		root = insert(root, key);
	}

	// Overloaded method
	public Node insert(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		else if (key < root.key)
			root.left = insert(root.left, key);

		else if (key > root.key)
			root.right = insert(root.right, key);

		return root;
	}

	public void levelOrderTraversal(Node node) {

		q.add(node);

		while (!q.isEmpty()) {

			Node a = q.poll();
			System.out.println(a.key);
			if (a.left != null)
				q.add(a.left);

			if (a.right != null)
				q.add(a.right);
		}
	}

	public static void main(String[] args) {
		_05_BST_LevelOrder_BFS_UsingQ tree = new _05_BST_LevelOrder_BFS_UsingQ();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.levelOrderTraversal(tree.root);
	}

}
