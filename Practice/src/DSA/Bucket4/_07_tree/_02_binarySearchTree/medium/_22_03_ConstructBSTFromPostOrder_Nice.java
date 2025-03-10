package DSA.Bucket4._07_tree._02_binarySearchTree.medium;

//https://practice.geeksforgeeks.org/problems/construct-bst-from-post-order/1
public class _22_03_ConstructBSTFromPostOrder_Nice {

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

	public static Node insert(Node root, int d) {

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

	public static Node constructTree(int post[], int n) {

		// Add your code here.
		Node root = null;
		for (int i = n - 1; i >= 0; i--)
			root = insert(root, post[i]);

		return root;

	}

	public static void main(String[] args) {

		int[] post = { 1, 7, 5, 50, 40, 10 };
		System.out.println(constructTree(post, post.length));

	}
}
