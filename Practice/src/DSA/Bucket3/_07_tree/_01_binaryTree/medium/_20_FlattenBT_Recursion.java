package DSA.Bucket3._07_tree._01_binaryTree.medium;

public class _20_FlattenBT_Recursion {

	Node root;
	Node prev;

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

	public void printTree(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		printTree(node.left);
		printTree(node.right);
	}

	// Intuition : goto right side first & to last element and start aligning any
	// left node to right by pointing its parent's right to this node and making
	// parent's left as null
	public void flattenBT(Node node) {

		if (node == null)
			return;

		flattenBT(node.right);
		flattenBT(node.left);

		node.right = prev;// point current node's right to prev node
		node.left = null; // point current node's left to null

		prev = node;// point last aliigned node on right side as prev before backtracking
	}

	public static void main(String[] args) {

		_20_FlattenBT_Recursion tree = new _20_FlattenBT_Recursion();
		tree.insert();
		tree.flattenBT(tree.root);
		tree.printTree(tree.root);
	}

}
