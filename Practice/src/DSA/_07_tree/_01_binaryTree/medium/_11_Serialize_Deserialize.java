package DSA._07_tree._01_binaryTree.medium;

import java.util.*;

//https://www.youtube.com/watch?v=-YbXySKJsX8
public class _11_Serialize_Deserialize {

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

	public void insert() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
	}

	public void printList(Node n) {

		if (n == null)
			return;

		printList(n.left);
		System.out.print(n.data + " ");
		printList(n.right);
	}

	public String serialize(Node node) {

		Queue<Node> q = new LinkedList<Node>();
		String serializedStr = "";

		q.add(node);
		serializedStr += node.data;

		while (!q.isEmpty()) {

			Node n = q.poll();

			if (n.left != null) {
				q.add(n.left);
				serializedStr += n.left.data;
			} else
				serializedStr += "N";

			if (n.right != null) {
				q.add(n.right);
				serializedStr += n.right.data;
			} else
				serializedStr += "N";
		}
		System.out.println(serializedStr);
		return serializedStr;
	}

	public Node deSerialize(String str) {

		Queue<Node> q = new LinkedList<Node>();
		Node root = new Node(Character.getNumericValue(str.charAt(0)));
		q.add(root);

		for (int i = 1; i < str.length(); i++) {

			Node n = q.poll();

			if (str.charAt(i) != 'N') {
				n.left = new Node(Character.getNumericValue(str.charAt(i)));
				q.add(n.left);
			}

			i++;

			if (str.charAt(i) != 'N') {
				n.right = new Node(Character.getNumericValue(str.charAt(i)));
				q.add(n.right);
			}

		}

		return root;

	}

	public static void main(String[] args) {
		_11_Serialize_Deserialize tree = new _11_Serialize_Deserialize();
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);
		tree.insert();
		String serializedStr = tree.serialize(tree.root);
		Node n = tree.deSerialize(serializedStr);
		tree.printList(n);
	}
}
