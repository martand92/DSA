package DSA.Bucket4._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/array-to-bst4443/1
public class _15_ArrayToBST_Imp2 {

	public void BST(int[] arr, int start, int end) {

		if (start > end)
			return;

		int mid = (start + end) / 2;
		System.out.print(arr[mid] + " ");

		BST(arr, start, mid - 1);
		BST(arr, mid + 1, end);

		return;
	}

	public static void main(String[] args) {
		_15_ArrayToBST_Imp2 tree = new _15_ArrayToBST_Imp2();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		// int[] nums = { 1, 2, 3, 4 };
		int start = 0;
		int end = nums.length - 1;

		tree.BST(nums, start, end);
		// tree.preorder(tree.root);

	}
}
