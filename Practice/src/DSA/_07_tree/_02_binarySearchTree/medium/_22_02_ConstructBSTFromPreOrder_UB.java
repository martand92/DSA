package DSA._07_tree._02_binarySearchTree.medium;

//https://www.youtube.com/watch?v=UmJT3j26t1I
public class _22_02_ConstructBSTFromPreOrder_UB {

	Node root;
	int index = 0;

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

	public Node constructTree(int preorder[], int upperBound) {

		if (index == preorder.length)
			return null;

		if (preorder[index] > upperBound)// backtrack whenever upper bound validation fails
			return null;

		Node root = new Node(preorder[index++]);

		root.left = constructTree(preorder, root.data);
		root.right = constructTree(preorder, upperBound);

		return root;

	}

	public static void main(String[] args) {

		int[] preorder = { 8, 5, 1, 7, 10, 12 };

		_22_02_ConstructBSTFromPreOrder_UB tree = new _22_02_ConstructBSTFromPreOrder_UB();

		tree.root = tree.constructTree(preorder, Integer.MAX_VALUE);
		tree.print(tree.root);
	}
}
