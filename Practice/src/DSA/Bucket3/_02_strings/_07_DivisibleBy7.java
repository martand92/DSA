package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/divisible-by-73224/1
public class _07_DivisibleBy7 {

	public static boolean isDivisibleBy7(String num) {

		int rem = 0;
		for (int i = 0; i < num.length(); i++)
			rem = Integer.valueOf(String.valueOf(rem) + num.charAt(i)) % 7;

		return rem == 0;
	}

	public static void main(String[] args) {

		String num = "8955795758";

		// do ele % 7. Concatenate remainder with next element & repeat.
		// if final remainder is 0 then its divisible by 7
		System.out.println(isDivisibleBy7(num));
	}
}

//TC:O(S)