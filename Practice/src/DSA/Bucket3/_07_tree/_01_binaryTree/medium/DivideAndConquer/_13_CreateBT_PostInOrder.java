package DSA.Bucket3._07_tree._01_binaryTree.medium.DivideAndConquer;

//https://www.youtube.com/watch?v=LgLRTaEMRVc
public class _13_CreateBT_PostInOrder {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void printList(Node node) {
		if (node == null)
			return;

		printList(node.left);
		System.out.print(node.data + " ");
		printList(node.right);
	}

	public Node constructBT(int[] inorder, int[] postorder, int postorderIndex) {

		if (inorder.length == 0)
			return null;

		if (inorder.length == 1)
			return new Node(postorder[0]);

		int rootIndex = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorderIndex]) {
				rootIndex = i;
				break;
			}

		}

		int[] inOrderLeft = new int[rootIndex];
		int[] inOrderRight = new int[inorder.length - rootIndex - 1];

		// fill inorder left and right
		for (int i = 0; i < inOrderLeft.length; i++)
			inOrderLeft[i] = inorder[i];

		for (int i = 0; i < inOrderRight.length; i++)
			inOrderRight[i] = inorder[rootIndex + 1 + i];

		int[] postOrderLeft = new int[rootIndex];
		int[] postOrderRight = new int[postorder.length - rootIndex - 1];

		// fill postorder left and right
		for (int i = 0; i < postOrderLeft.length; i++)
			postOrderLeft[i] = postorder[i];

		for (int i = 0; i < postOrderRight.length; i++)
			postOrderRight[i] = postorder[rootIndex + i];

		Node root = new Node(inorder[rootIndex]);

		root.left = constructBT(inOrderLeft, postOrderLeft, postOrderLeft.length - 1);
		root.right = constructBT(inOrderRight, postOrderRight, postOrderRight.length - 1);

		return root;
	}

	public static void main(String[] args) {

		_13_CreateBT_PostInOrder tree = new _13_CreateBT_PostInOrder();

		int[] inorder = { 40, 20, 50, 10, 60, 30 };
		int[] postorder = { 40, 50, 20, 60, 30, 10 };

		Node root = tree.constructBT(inorder, postorder, postorder.length - 1);
		tree.printList(root);
	}

}
