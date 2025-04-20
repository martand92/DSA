package DSA.Bucket4._07_tree._01_binaryTree;

public class _04_FindHeight {

	Node root;

	static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	public static Node insert(Node root, int data) {

		if (root == null) {
			return new Node(data);
		}

		if (data < root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);

		return root;

	}

	public int findHeight(Node root) {

		if (root == null)
			return 0; // return 0 if root's height=1, return -1 if root's height=0

		int left = findHeight(root.left) + 1;
		int right = findHeight(root.right) + 1;

		return Math.max(left, right);
	}

	public static void main(String[] args) {
		_04_FindHeight tree = new _04_FindHeight();

		int[] arr = { 50, 30, 20, 40, 70, 60, 80 };

		for (int i = 0; i < arr.length; i++)
			tree.insert(arr[i]);

		System.out.println(tree.findHeight(tree.root));
	}

}
