package DSA._07_tree._01_binaryTree;

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

	public int sumOfST(Node initRoot, Node root, int sum) {
		if (root == null)
			return sum;

		sum += root.data;

		sum = sumOfST(initRoot, root.left, sum);
		sum = sumOfST(initRoot, root.right, sum);

		return sum;
	}

	public void toSumTree(Node root) {
		// add code here.
		if (root == null)
			return;

		root.data = sumOfST(root, root.left, 0) + sumOfST(root, root.right, 0);
		toSumTree(root.left);
		toSumTree(root.right);
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

		tree.print(tree.root);

		tree.toSumTree(tree.root);

		System.out.println();

		tree.print(tree.root);

	}
}
