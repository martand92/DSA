package DSA.Bucket4._07_tree._01_binaryTree.easy;

//https://practice.geeksforgeeks.org/problems/odd-even-level-difference/1
public class _13_OddEvenLevelDifference {

	Node root;
	int currHeight = -1, height = -1;

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

	public int levelOrder(Node root, int level, int sum) {

		if (root == null)
			return sum;

		if (level == 0)
			return sum += root.data;

		sum = levelOrder(root.left, level - 1, sum);
		sum = levelOrder(root.right, level - 1, sum);
		return sum;
	}

	int getLevelDiff(Node root) {

		int height = findHeight(root);
		int sum = 0;

		for (int i = 0; i < height; i++) {

			if (i % 2 == 0)
				sum += levelOrder(root, i, 0);

			else
				sum -= levelOrder(root, i, 0);
		}

		return sum;
	}

	public static void main(String[] args) {
		_13_OddEvenLevelDifference tree = new _13_OddEvenLevelDifference();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.getLevelDiff(tree.root));

	}
}
