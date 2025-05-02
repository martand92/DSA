package DSA.Bucket4._07_tree._01_binaryTree.medium.VerticalOrderTraverse;

import java.util.*;

public class _02_02_TopViewOfBinaryTree {

	Node root;

	static class Data {
		Node node;
		int vertical;

		Data(Node node, int vertical) {
			this.node = node;
			this.vertical = vertical;
		}
	}

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

		root = new Node(10);

		root.left = new Node(5);

		root.left.left = new Node(3);
		root.left.right = new Node(7);

		root.left.left.left = new Node(1);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(8);

		root.right = new Node(15);
		root.right.left = new Node(13);
		root.right.right = new Node(17);

	}

	// Instead of pq & hs just use treemap
	public TreeMap<Integer, Integer> topView() {

		TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(root, 0));

		while (!q.isEmpty()) {

			Data d = q.poll();

			if (!topViewMap.containsKey(d.vertical))
				topViewMap.put(d.vertical, d.node.data);

			if (d.node.left != null)
				q.add(new Data(d.node.left, d.vertical - 1));

			if (d.node.right != null)
				q.add(new Data(d.node.right, d.vertical + 1));
		}

		return topViewMap;

	}

	public static void main(String[] args) {

		_02_02_TopViewOfBinaryTree tree = new _02_02_TopViewOfBinaryTree();

		tree.insert();
		TreeMap<Integer, Integer> tm = tree.topView();

		for (int val : tm.values())
			System.out.print(val + " ");
	}
}
