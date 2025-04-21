package DSA.Bucket4._07_tree._01_binaryTree.medium;

//https://www.youtube.com/watch?v=fnmisPM6cVo

//expectation is root node value = sum of both children in O(N)
public class _08_ChildrenSum {

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

	public void insert() {
		root = new Node(40);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(30);
		root.right.right = new Node(40);
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

	public void findChildrenSum(Node node) {

		if (node == null || (node.left == null && node.right == null))
			return;

		findChildrenSum(node.left);
		findChildrenSum(node.right);

		int leftData = node.left != null ? node.left.data : 0;
		int rightData = node.right != null ? node.right.data : 0;
		node.data = leftData + rightData;
	}

	public void printTraversal(Node node) {

		if (node == null)
			return;

		System.out.print(node.data + " ");
		printTraversal(node.left);
		printTraversal(node.right);
	}

	public static void main(String[] args) {

		_08_ChildrenSum tree = new _08_ChildrenSum();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		// tree.insert();
		tree.findChildrenSum(tree.root);
		tree.printTraversal(tree.root);
	}
}
