package DSA.Bucket4._07_tree._01_binaryTree.medium;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class _16_MaximumPathSum_Imp {

	Node root;
	int max = 0;

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

	public int maxPathSum(Node node) {

		if (node == null)
			return 0;

		int left = maxPathSum(node.left);
		int right = maxPathSum(node.right);

		// for given node you sum up left and right path and current node
		max = Math.max(max, left + right + node.data);

		// while backtracking consider path with max weight and add current root's val
		return node.data + Math.max(left, right);

	}

	public static void main(String[] args) {

		_16_MaximumPathSum_Imp tree = new _16_MaximumPathSum_Imp();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.maxPathSum(tree.root);
		System.out.println(tree.max);
	}

}