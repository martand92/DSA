package DSA._02_strings;

//https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1
public class _13_CheckKAnagram {

	public static void main(String[] args) {

		String s1 = "ukdbgygrsjlaukwsgc";
		String s2 = "memdwhetaewfahkc";
		int k = 14;

		if (s1.length() != s2.length()) {
			System.out.println("Not K-Anagram");
			return;
		}

		StringBuilder str1 = new StringBuilder(s1);

		for (int i = 0; i < s2.length(); i++) {

			int index = str1.indexOf(String.valueOf(s2.charAt(i)));

			if (index >= 0)
				str1.deleteCharAt(index);
		}

		if (str1.length() <= k)
			System.out.println("K Anagram");
		else
			System.out.println("Not K-Anagram");

	}

}
