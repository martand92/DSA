package DSA._07_tree._01_binaryTree.medium.VerticalOrderTraverse;

//https://www.youtube.com/watch?v=Et9OCDNvJ78
import java.util.*;

public class _07_BottomViewOfBinaryTree {

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

	// using postorder, storing last nodes from a tree
	public void bottomView(Node node) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm = bottomView(node, 0, hm);

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

	public HashMap<Integer, Integer> bottomView(Node node, int vertical, HashMap<Integer, Integer> hm) {

		if (node == null)
			return hm;

		hm = bottomView(node.left, vertical - 1, hm);
		hm = bottomView(node.right, vertical + 1, hm);

		if (!hm.containsKey(vertical))
			hm.put(vertical, node.data);

		return hm;
	}

	public static void main(String[] args) {
		_07_BottomViewOfBinaryTree tree = new _07_BottomViewOfBinaryTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.bottomView(tree.root);
	}
}
