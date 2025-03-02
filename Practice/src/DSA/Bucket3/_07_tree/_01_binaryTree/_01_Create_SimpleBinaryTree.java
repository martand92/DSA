package DSA.Bucket3._07_tree._01_binaryTree;

/*To construct below simple binary tree
  	  1    
	/   \
   2     3  
  /   
 4                                     */

public class _01_Create_SimpleBinaryTree {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

//	public void push(int d) {
//		Node newNode = new Node(d);
//		
//		if(root == null)
//			root = newNode;
//		
//		else {
//			while (root.)
//		}
//	}

	public static void main(String[] args) {
		_01_Create_SimpleBinaryTree tree = new _01_Create_SimpleBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
	}
}
