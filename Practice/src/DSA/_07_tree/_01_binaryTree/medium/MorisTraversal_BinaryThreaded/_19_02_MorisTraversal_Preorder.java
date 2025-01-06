package DSA._07_tree._01_binaryTree.medium.MorisTraversal_BinaryThreaded;

public class _19_02_MorisTraversal_Preorder {

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
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(6);
	}

	public void morisTraversal(Node node) {

		Node curr = node;

		while (curr != null) {

			// if left subtree is available
			if (curr.left != null) {

				Node prev = curr.left;

				while (prev.right != null && prev.right != curr)
					prev = prev.right;

				if (prev.right == null) {
					prev.right = curr;
					System.out.print(curr.data + " "); // for pre order before moving curr to curr.left print it
					curr = curr.left;

				} else {
					prev.right = null;
					curr = curr.right;
				}
			} else {
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
		}

	}

	public static void main(String[] args) {

		_19_02_MorisTraversal_Preorder tree = new _19_02_MorisTraversal_Preorder();
		tree.insert();
		tree.morisTraversal(tree.root);
	}

}
