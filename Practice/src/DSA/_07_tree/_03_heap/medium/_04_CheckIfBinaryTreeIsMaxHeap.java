package DSA._07_tree._03_heap.medium;

//https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1
public class _04_CheckIfBinaryTreeIsMaxHeap {

	Node root;
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

	public int findHeight(Node root, int currHeight, int height) {

		if (root == null)
			return Math.max(currHeight, height);

		currHeight++;
		height = findHeight(root.left, currHeight, height);
		height = findHeight(root.right, currHeight, height);
		currHeight--;

		return height;
	}

	public int getBalanceFactor(Node root) {
		if (root == null)
			return -1;

		return findHeight(root.left, -1, -1) - findHeight(root.right, -1, -1);
	}

	public boolean isHeap(Node root) {

		if (!sol)
			return sol;

		if (root == null)
			return sol;

		sol = isHeap(root.left);
		sol = isHeap(root.right);

		int bf = getBalanceFactor(root);

		if (bf == 0) {
			if (root.left != null && root.right != null)
				if (root.data < root.left.data || root.data < root.right.data)
					return false;

		} else if (bf == 1) {
			if (root.data < root.left.data)
				return false;

		} else
			return false;

		return sol;
	}

	public static void main(String[] args) {
		_04_CheckIfBinaryTreeIsMaxHeap tree = new _04_CheckIfBinaryTreeIsMaxHeap();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.left = new Node(3);

		System.out.println(tree.isHeap(tree.root));
	}
}
