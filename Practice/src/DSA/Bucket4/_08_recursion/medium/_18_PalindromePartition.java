package DSA.Bucket4._08_recursion.medium;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=WBgsABoClE0
public class _18_PalindromePartition {

	public static String reverseStr(String str) {

		if (str.length() == 1)
			return str;

		return reverseStr(str.substring(1)) + str.charAt(0);
	}

	public static ArrayList<ArrayList<String>> palindromePartition(String str, ArrayList<String> list,
			ArrayList<ArrayList<String>> result) {

		if (str == "") {
			result.add(new ArrayList<String>(list));
			return result;
		}

		for (int part = 1; part <= str.length(); part++) {//till last cz substring(0, j-1)

			String strSub = str.substring(0, part);

			if (reverseStr(strSub).compareTo(strSub) == 0) {// checking if each substring is a palindrome
				list.add(strSub);
				palindromePartition(str.substring(part), list, result);
				list.remove(list.size() - 1);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		String str = "abba";
		System.out.println(palindromePartition(str, new ArrayList<String>(), new ArrayList<ArrayList<String>>()));
	}

}
