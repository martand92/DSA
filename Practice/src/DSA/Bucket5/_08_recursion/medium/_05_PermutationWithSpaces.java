package DSA.Bucket5._08_recursion.medium;

//https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1

//https://www.youtube.com/watch?v=f_6qd8OUzv0

//Algo : Here "A" need to be fixed then other characters should either add with or without space

public class _05_PermutationWithSpaces {

	public static void permutationWithSpaces(String s, String temp) {

		if (temp.length() == 0) {
			System.out.println(s);
			return;
		}

		// In first depth traversal, keep adding space after first character
		String s1 = s + " " + temp.charAt(0); // keep adding next character with space
		permutationWithSpaces(s1, temp.substring(1));

		String s2 = s + temp.charAt(0); // keep adding next character without space
		permutationWithSpaces(s2, temp.substring(1));

	}

	public static void main(String[] args) {
		// String s = "ABCDE";
		String s = "ABC";

		// first send first character "A" along with other characters
		permutationWithSpaces(s.substring(0, 1), s.substring(1));

	}

}

//A BCDE
//A BC DE
//A BCD E
//A B CDE
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