package DSA.Bucket4._07_tree._01_binaryTree.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//https://practice.geeksforgeeks.org/problems/maximum-gcd-of-siblings-of-a-binary-tree/1
public class _03_MaxGCD {

	public static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {

		int maxGCD = Integer.MIN_VALUE;

		if (N < 3)
			return 0;

		Collections.sort(arr, new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(0) - o2.get(0);
			}
		});

		// arr.sort((n, m) -> n.get(0) - m.get(0));
		int i = 1;

		while (i < arr.size()) {

			if (arr.get(i).get(0) == arr.get(i - 1).get(0)) {
				maxGCD = Math.max(maxGCD, calculategcd(arr.get(i).get(1), arr.get(i - 1).get(1)));
				i = i + 2;
			} else
				i = i + 1;
		}

		if (maxGCD != Integer.MIN_VALUE)
			return maxGCD;
		else
			return 0;

	}

	static int calculategcd(int a, int b) {

		int gcd = Math.min(a, b);

		while (gcd > 0) {
			if (a % gcd == 0 && b % gcd == 0)
				return gcd;
			gcd--;
		}

		return gcd;
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(4);
		arr1.add(5);
		arr.add(arr1);
		arr1 = new ArrayList<Integer>();

		arr1.add(4);
		arr1.add(2);
		arr.add(arr1);
		arr1 = new ArrayList<Integer>();

		arr1.add(2);
		arr1.add(3);
		arr.add(arr1);
		arr1 = new ArrayList<Integer>();

		arr1.add(2);
		arr1.add(1);
		arr.add(arr1);
		arr1 = new ArrayList<Integer>();

		arr1.add(3);
		arr1.add(6);
		arr.add(arr1);
		arr1 = new ArrayList<Integer>();

		arr1.add(3);
		arr1.add(12);
		arr.add(arr1);
		arr1 = new ArrayList<Integer>();

		System.out.println(maxBinTreeGCD(arr, 7));

	}
}
