package DSA.Bucket3._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class _09_CheckForBalancedTree {

	Node root;
	boolean sol = true;
	int bf = 0;

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

	int height(Node root, int currHeight, int height) {

		if (root == null) {

			if (currHeight > height)
				height = currHeight;

			return height;
		}

		currHeight++;
		height = height(root.left, currHeight, height);// must update height value for every recursion call
		height = height(root.right, currHeight, height);
		currHeight--;

		return height;
	}

	boolean checkBalanceFactor(Node root1, Node root2) {

		if (Math.abs(height(root1, -1, -1) - height(root2, -1, -1)) < 2)
			return true;

		return false;

	}

	// Check bf of each node and if Math.abs(bf) > 1 for any node, tree is not
	// balanced
	public boolean isBalanced(Node root) {

		if (!sol)
			return sol;

		if (root == null)
			return sol;

		sol = isBalanced(root.left);
		sol = isBalanced(root.right);

		return checkBalanceFactor(root.left, root.right);
	}

	public static void main(String[] args) {

		_09_CheckForBalancedTree tree = new _09_CheckForBalancedTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.insert(90);
		// tree.insert(100);

		System.out.println(tree.isBalanced(tree.root));
	}
}
