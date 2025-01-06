package DSA._08_recursion.medium.pickAndNotPick;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/generating-all-possible-subsequences-using-recursion/
//https://youtu.be/AxNNVECce8c
public class _16_01_PrintAllSubSequences {

	public static ArrayList<ArrayList<Integer>> getAllSubSequences(int[] arr, int index, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> finalList) {

		if (index == arr.length) {
			finalList.add(new ArrayList<Integer>(list));
			return finalList;
		}

		list.add(arr[index]);
		finalList = getAllSubSequences(arr, index + 1, list, finalList);
		list.remove(list.size() - 1);// remove last element from list
		finalList = getAllSubSequences(arr, index + 1, list, finalList);

		return finalList;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(getAllSubSequences(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
	}

}
