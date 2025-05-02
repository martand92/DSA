package DSA.Bucket4._07_tree._01_binaryTree.medium.MorisTraversal_BinaryThreaded;

//https://www.youtube.com/watch?v=80Zug6D1_r4

//this traversal reduces SC from O(N) to O(1) using iterative method

//Whole concept is around creating thread/link between last node and its root so that no need to recurse back to root using stack
//Once you reach last node then go back to root by traversing instead of recursing
//carefully add and delete links from last node to root node
public class _19_01_MorisTraversal_Inorder {

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

	// need to do inorder traversal in TC:O(N) & SC:O(1)
	// recursion uses O(N) SC and iterative also uses stack so O(N)

	// Algo : start traversing left from root,
	// if node.left!=null, point right most node of this node's left subtree to root
	// if you reach node.left == null then point this node's right to root.
	// print node's value whose
	public void morisTraversal(Node root) {

		Node curr = root;

		while (curr != null) {

			if (curr.left != null) { // if left subtree is available

				Node node = curr.left;

				while (node.right != null && node.right != curr)
					node = node.right;

				if (node.right == null) {
					node.right = curr;
					curr = curr.left;

				} else { // if prev.right == curr
					node.right = null;
					System.out.print(curr.data + " "); // as you are transitioning to right via this root, it will be
														// part of inorder
					curr = curr.right;
				}

			} else { // if curr.left == null

				System.out.print(curr.data + " ");// as inorder is left -> root -> right, if you reach node whose left
													// is null print root
				curr = curr.right;
			}
		}

	}

	public static void main(String[] args) {

		_19_01_MorisTraversal_Inorder tree = new _19_01_MorisTraversal_Inorder();
		tree.insert();
		tree.morisTraversal(tree.root);
	}

}
