package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/divisible-by-73224/1
public class _07_DivisibleBy7 {
	public static void main(String[] args) {

		String num = "8955795758";
		int rem = 0;

		// Logic : do 1st element % 7. Concatenate remainder with next element & repeat.
		// if final remainder is 0 then its divisible by 7

		for (int i = 0; i < num.length(); i++)
			rem = Integer.valueOf(String.valueOf(rem) + num.charAt(i)) % 7;

		if (rem > 0)
			System.out.println(0);
		else
			System.out.println(1);

	}
}