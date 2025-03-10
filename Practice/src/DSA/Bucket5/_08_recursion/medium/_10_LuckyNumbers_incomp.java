package DSA.Bucket5._08_recursion.medium;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1
public class _10_LuckyNumbers_incomp {

	static ArrayList<Integer> al = new ArrayList<Integer>();
	static int i = 1;

	public static void setOfNumbers(int n) {
		if (i > n)
			return;

		al.add(i);
		i = i + 1;
		setOfNumbers(n);
	}

	public static boolean removeEle(int deletionNum, int n) {
		if (al.size() < deletionNum) {
			if (al.indexOf(n) == -1)
				return false;
			else
				return true;
		}

		int i = deletionNum;
		while (i <= al.size()) {
			System.out.println("deletion: " + deletionNum);
			System.out.println("Removed: " + al.remove(i - 1));
			i = i + deletionNum - 1;

			if (al.indexOf(n) == -1)
				return false;
		}

//		for (int i = deletionNum; i < al.size();) {
//			
//		}
		return removeEle(deletionNum + 1, n);
	}

	// Complete the function
	// n: Input n
	// Return True if the given number is a lucky number else return False
	public static boolean isLucky(int n) {
		// Your code here
		if (n % 2 == 0)
			return false;

		setOfNumbers(n);

		return (removeEle(2, n));
	}

	public static void main(String[] args) {
		System.out.println(isLucky(11));
	}

}
