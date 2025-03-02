package DSA.Bucket3._07_tree._01_binaryTree.medium;

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

	public void childrenSum(Node node) {

		if (node == null)
			return;

		if (node.left == null && node.right == null)
			return;

		int sum = 0;

		if (node.left != null)
			sum += node.left.data;

		if (node.right != null)
			sum += node.right.data;

//		if (node.data < sum)
//			node.data = sum;
		if (sum < node.data) {
			if (node.left != null)
				node.left.data = node.data;
			if (node.right != null)
				node.right.data = node.data;
		}

		childrenSum(node.left);
		childrenSum(node.right);

		sum = 0;
		if (node.left != null)
			sum += node.left.data;

		if (node.right != null)
			sum += node.right.data;

		node.data = sum;
		return;
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
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);
		tree.insert();
		tree.childrenSum(tree.root);
		tree.printTraversal(tree.root);
	}
}
