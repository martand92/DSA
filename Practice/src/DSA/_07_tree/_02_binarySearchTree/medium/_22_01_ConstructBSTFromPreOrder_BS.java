package DSA._07_tree._02_binarySearchTree.medium;

import java.util.Arrays;

//As binary tree here you need inorder of given tree only to construct BT. 
public class _22_01_ConstructBSTFromPreOrder_BS {

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

	public void print(Node node) {
		if (node == null)
			return;

		print(node.left);
		System.out.print(node.data + " ");
		print(node.right);
	}

	public Node constructTree(int preorder[], int l, int r) {

		if (l > r)
			return root;

		int mid = (l + r) / 2;
		Node root = new Node(preorder[mid]);

		root.left = constructTree(preorder, l, mid - 1);
		root.right = constructTree(preorder, mid + 1, r);

		return root;
	}

	public static void main(String[] args) {

		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		Arrays.sort(preorder); // O(NlogN)
		_22_01_ConstructBSTFromPreOrder_BS tree = new _22_01_ConstructBSTFromPreOrder_BS();
		tree.root = tree.constructTree(preorder, 0, preorder.length - 1); // O(N)
		tree.print(tree.root);
	}
}

//TC : O(NlogN) + O(N)
//SC : O(N) -> Auxiliary