package DSA.Bucket4._07_tree._01_binaryTree.medium.VerticalOrderTraverse;

//https://www.youtube.com/watch?v=Et9OCDNvJ78
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class _03_BottomViewOfBinaryTree {

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

	public TreeMap<Integer, Integer> bottomView() {

		TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(root, 0));

		while (!q.isEmpty()) {

			Data d = q.poll();

			bottomViewMap.put(d.vertical, d.node.data);// Overwrite always: the last node at each vertical seen during
														// level-order is the bottom view

			if (d.node.left != null)
				q.add(new Data(d.node.left, d.vertical - 1));

			if (d.node.right != null)
				q.add(new Data(d.node.right, d.vertical + 1));
		}

		return bottomViewMap;
	}

	public static void main(String[] args) {

		_03_BottomViewOfBinaryTree tree = new _03_BottomViewOfBinaryTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		TreeMap<Integer, Integer> bottomViewMap = tree.bottomView();
		for (int val : bottomViewMap.values())
			System.out.print(val + " ");

	}
}
