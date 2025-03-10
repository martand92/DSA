package DSA.Bucket4._07_tree._01_binaryTree;

//https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
public class _06_CheckIfTwoBTAreIdentical {

	Node root1;
	Node root2;
	boolean sol = true;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void insertRoot1(int d) {
		root1 = insert(root1, d);
	}

	public void insertRoot2(int d) {
		root2 = insert(root2, d);
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

	// handling both trees at once
	public boolean isIdentical(Node root1, Node root2) {

		if (!sol)
			return sol;

		if (root1 == null && root2 == null)
			return sol;

		if (root1 == null && root2 != null || root1 != null && root2 == null)
			return false;

		if (root1.data != root2.data)
			return false;

		sol = isIdentical(root1.left, root2.left);
		sol = isIdentical(root1.right, root2.right);

		return sol;
	}

	public static void main(String[] args) {
		_06_CheckIfTwoBTAreIdentical tree = new _06_CheckIfTwoBTAreIdentical();
		tree.insertRoot1(50);
		tree.insertRoot1(30);
		tree.insertRoot1(20);
		tree.insertRoot1(40);
		tree.insertRoot1(70);
		tree.insertRoot1(60);
		tree.insertRoot1(80);

		tree.insertRoot2(50);
		tree.insertRoot2(30);
		tree.insertRoot2(20);
		tree.insertRoot2(40);
		tree.insertRoot2(70);
		tree.insertRoot2(60);
		tree.insertRoot2(80);

		System.out.println(tree.isIdentical(tree.root1, tree.root2));
	}
}
