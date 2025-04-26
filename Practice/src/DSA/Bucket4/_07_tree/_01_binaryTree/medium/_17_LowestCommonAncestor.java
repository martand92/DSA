package DSA.Bucket4._07_tree._01_binaryTree.medium;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=_-QHfMDde90

//this is different than lowest common ancestor in bst

// Bruteforce :
// Find ancestors of both numbers using algo and then check for its lowest common ancestor
// TC : O(2N) -> to find ancestor of both the nums. SC : O(2N) to find store ancestors of both nums

//Optimized:
//Start DFS from root and keep traversing, if you find null return null else if found num then return num

//Scenario 1:if null is returned from 1 subtree(say left) and num is returned from another subtree then return num further
//Scenario 2:if null is returned at both choices then return null
//Scenario 3:if both sides return num, meaning found both nums on either side then return this root's val as its LCA
//Scenario 4:if both nums are on the same path ex: 70 and 80. When you find 70 then you will directly return 70 and no need to check further for 80 as it will be in same path
public class _17_LowestCommonAncestor {

	Node root;
	ArrayList<Integer> al = new ArrayList<Integer>();
	boolean found = false;

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

	public Node lca(Node node, int n1, int n2) {

		if (node == null || node.data == n1 || node.data == n2)
			return node;

		Node left = lca(node.left, n1, n2);
		Node right = lca(node.right, n1, n2);

		if (left != null && right != null)
			return node;

		if (left != null && right == null)
			return left;

		else if (left == null && right != null)
			return right;

		else
			return null;
	}

	public static void main(String[] args) {

		_17_LowestCommonAncestor tree = new _17_LowestCommonAncestor();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.lca(tree.root, 70, 80).data);

	}

}
