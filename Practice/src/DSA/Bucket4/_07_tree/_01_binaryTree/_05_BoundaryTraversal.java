package DSA.Bucket4._07_tree._01_binaryTree;

public class _05_BoundaryTraversal {

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

	public int findHeight(Node root) {

		if (root == null)
			return 0;

		return Math.max(findHeight(root.left) + 1, findHeight(root.right) + 1);
	}

	public boolean leftView(Node root, int level) {

		if (root == null)
			return false;

		if (level == 0) {
			System.out.print(root.data + " ");
			return true;
		}

		if (leftView(root.left, level - 1))
			return true;

		if (leftView(root.right, level - 1))
			return true;

		return false;
	}

	public void printLeafNodes(Node node, int level) {
		if (node == null)
			return;

		if (level == 0)
			System.out.print(node.data + " ");

		printLeafNodes(node.left, level - 1);
		printLeafNodes(node.right, level - 1);
	}

	public boolean rightView(Node root, int level) {

		if (root == null)
			return false;

		if (level == 0) {
			System.out.print(root.data + " ");
			return true;
		}

		if (rightView(root.right, level - 1))
			return true;

		if (rightView(root.left, level - 1))
			return true;

		return false;
	}

	public void levelOrder(Node root) {

		int height = findHeight(root) - 1; // consider root as height 0

		// left side nodes except leaf boundary nodes
		for (int i = 0; i < height; i++)
			leftView(root, i);

		// goto last level
		printLeafNodes(root, height);

		for (int i = height - 1; i > 0; i--)
			rightView(root, i);

		return;

	}

	public static void main(String[] args) {

		_05_BoundaryTraversal tree = new _05_BoundaryTraversal();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.levelOrder(tree.root);
	}
}
