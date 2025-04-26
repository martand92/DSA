package DSA.Bucket4._07_tree._01_binaryTree.easy;

//https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
public class _10_TransformToSumTree {

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

	public void print(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}

	public int toSumTree(Node node) {

		if (node == null)
			return 0;

		int nodeVal = node.data;

		int leftSum = toSumTree(node.left);
		int rightSum = toSumTree(node.right);

		node.data = leftSum + rightSum;

		return node.data + nodeVal;
	}

	public static void main(String[] args) {

		_10_TransformToSumTree tree = new _10_TransformToSumTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.toSumTree(tree.root);
		tree.print(tree.root);

	}
}
