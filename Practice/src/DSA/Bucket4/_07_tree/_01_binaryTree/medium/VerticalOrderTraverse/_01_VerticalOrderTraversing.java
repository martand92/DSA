package DSA.Bucket4._07_tree._01_binaryTree.medium.VerticalOrderTraverse;

import java.util.*;

//traverse by vertical, if multiple nodes are on same vertical then traverse by level 
//if multiple nodes are on same vertical & level then sort by value
public class _01_VerticalOrderTraversing {

	Node root;

	PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {

		public int compare(Data a, Data b) {
			if (a.vertical != b.vertical)
				return a.vertical - b.vertical;
			else if (a.vertical == b.vertical && a.level != b.level)
				return a.level - b.level;
			else
				return a.nodeVal - b.nodeVal;
		}
	});

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	static class Data {
		
		int nodeVal;
		int vertical;
		int level;

		Data(int nodeVal, int vertical, int level) {
			this.nodeVal = nodeVal;
			this.vertical = vertical;
			this.level = level;
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

	public void verticalOrderTraversing(Node node, int vertical, int level) {

		if (node == null)
			return;

		pq.add(new Data(node.data, vertical, level));

		verticalOrderTraversing(node.left, vertical - 1, level + 1);
		verticalOrderTraversing(node.right, vertical + 1, level + 1);

		return;
	}

	public void verticalOrderTraverse() {

		// sort by vertical -> level -> value
		verticalOrderTraversing(root, 0, 0);

		// Group by vertical
		TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list;

		while (!pq.isEmpty()) {

			Data d = pq.poll();

			if (!hm.containsKey(d.vertical)) {
				list = new ArrayList<Integer>();
				list.add(d.nodeVal);
				hm.put(d.vertical, list);
			} else {
				list = hm.get(d.vertical);
				list.add(d.nodeVal);
				hm.put(d.vertical, list);
			}
		}

		for (ArrayList<Integer> e : hm.values())
			System.out.print(e + " ");
	}

	public static void main(String[] args) {

		_01_VerticalOrderTraversing tree = new _01_VerticalOrderTraversing();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.verticalOrderTraverse();

	}

}