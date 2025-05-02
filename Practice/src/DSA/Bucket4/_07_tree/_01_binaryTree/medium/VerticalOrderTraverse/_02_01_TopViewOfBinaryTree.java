package DSA.Bucket4._07_tree._01_binaryTree.medium.VerticalOrderTraverse;

//https://www.youtube.com/watch?v=Et9OCDNvJ78
import java.util.*;

public class _02_01_TopViewOfBinaryTree {

	Node root;

	HashSet<Integer> hs = new HashSet<Integer>();

	PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
		public int compare(Data a, Data b) {
			return a.vertical - b.vertical;
		}
	});

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


	public PriorityQueue<Data> topView() {

		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(root, 0));

		while (!q.isEmpty()) {

			Data d = q.poll();

			if (!hs.contains(d.vertical)) {
				pq.add(new Data(d.node, d.vertical));
				hs.add(d.vertical);
			}

			if (d.node.left != null)
				q.add(new Data(d.node.left, d.vertical - 1));

			if (d.node.right != null)
				q.add(new Data(d.node.right, d.vertical + 1));
		}

		return pq;

	}

	public static void main(String[] args) {

		_02_01_TopViewOfBinaryTree tree = new _02_01_TopViewOfBinaryTree();

		tree.insert();
		PriorityQueue<Data> pq = tree.topView();

		while (!pq.isEmpty())
			System.out.print(pq.poll().node.data + " ");
	}
}
