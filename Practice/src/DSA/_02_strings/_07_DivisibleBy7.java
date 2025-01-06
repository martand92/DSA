package DSA._02_strings;

//https://www.geeksforgeeks.org/problems/divisible-by-73224/1
public class _07_DivisibleBy7 {
	public static void main(String[] args) {

		String num = "8955795758";
		int rem = 0;

		// Logic is to take 1st element check modulous of 7 and concatenate remainder
		// with next element till the last element. if final remainder is 0 then its
		// divisible by 7

		// Ex: num = 89, 8%7 -> remainder = 1, now concat this 1 with 9 and check if its
		// divisible by 7

		for (int i = 0; i < num.length(); i++)
			rem = Integer.valueOf(String.valueOf(rem) + num.charAt(i)) % 7;

		if (rem > 0)
			System.out.println(0);
		else
			System.out.println(1);

	}

}
