package DSA._08_recursion.medium;

//https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1

//https://www.youtube.com/watch?v=f_6qd8OUzv0

//Algo : Here "A" need to be fixed then other characters should either add with or without space

public class _05_PermutationWithSpaces2 {

	public static String permutationWithSpaces(String s, String newStr, int i) {

		if (i == s.length() - 1)
			return newStr;

		newStr += " " + s.charAt(i);
		permutationWithSpaces(s, newStr, i + 1);

		newStr += s.charAt(i);// keep adding next character without space

		permutationWithSpaces(s, newStr, i + 1);

		return newStr;
	}

	public static void main(String[] args) {
		// String s = "ABCDE";
		String s = "ABC";

		// first send first character "A" along with other characters
		permutationWithSpaces(s, "A", 0);
	}

}

//A BCDE
//A B CDE
//A BC DE
//A BCD E

//A B C DE
//A B C D E

//AB CDE
//AB CD E
//AB C DE
//AB C D E

//ABC DE
//ABC D E

//ABCD E

//ABCDE