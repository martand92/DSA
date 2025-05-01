package DSA.Bucket4._07_tree._02_binarySearchTree.medium;

public class _25_LargestBST {

	static Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public static Node insert() {

		root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(70);
		// root.right = new Node(20);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		return root;
	}

	public static boolean isBST(Node node, int lowerBound, int upperBound) {

		if (node == null)
			return true;

		if (node.data > lowerBound && node.data < upperBound)
			return isBST(node.left, lowerBound, node.data) && isBST(node.right, node.data, upperBound);

		return false;
	}

	public static int countNodes(Node node) {

		if (node == null)
			return 0;

		return 1 + countNodes(node.left) + countNodes(node.right);
	}

	public static int largestBST_BruteForce(Node node) {

		if (node == null)
			return 0;

		if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE))
			return countNodes(node);

		return Math.max(largestBST_BruteForce(node.left), largestBST_BruteForce(node.right));
	}

	public static void main(String[] args) {

		insert();
		System.out.println(largestBST_BruteForce(root));
	}

}
