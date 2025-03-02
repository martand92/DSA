package DSA.Bucket3._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/sum-of-k-smallest-elements-in-bst3029/1
public class _21_SumOfKSmallestEleInBST {

	Node root;
	int sum = 0;

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

	public int sum(Node root, int k) {
		
		if (k == 0)
			return k;

		if (root == null)
			return k;

		k = sum(root.left, k);

		if (k > 0) {
			sum += root.data;
			k--;
		}

		k = sum(root.right, k);

		return k;
	}

	public static void main(String[] args) {
		_21_SumOfKSmallestEleInBST tree = new _21_SumOfKSmallestEleInBST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		int noOfEle = 3;

		tree.sum(tree.root, noOfEle);
		System.out.println(tree.sum);

	}
}
