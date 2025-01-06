package DSA._07_tree._01_binaryTree.medium.VerticalOrderTraverse;

//https://www.youtube.com/watch?v=Et9OCDNvJ78
import java.util.*;

public class _06_TopViewOfBinaryTree {

	Node root;
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	Queue<Data> q = new LinkedList<Data>();

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

	// using level order, only storing first node on a given vertical
	public void topView(Node node, int vertical) {

		q.add(new Data(node, vertical));

		while (!q.isEmpty()) {

			Data data = q.poll();

			if (!hm.containsKey(data.vertical))
				hm.put(data.vertical, data.node.data);

			if (data.node.left != null)
				q.add(new Data(data.node.left, data.vertical - 1));
			if (data.node.right != null)
				q.add(new Data(data.node.right, data.vertical + 1));
		}

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> aa : list)
			temp.put(aa.getKey(), aa.getValue());

		System.out.println(temp);

	}

	public static void main(String[] args) {
		_06_TopViewOfBinaryTree tree = new _06_TopViewOfBinaryTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.topView(tree.root, 0);
	}
}
