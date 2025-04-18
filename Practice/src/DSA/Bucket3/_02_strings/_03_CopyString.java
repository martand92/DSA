package DSA.Bucket3._02_strings;

//Using iterative & recursion
public class _03_CopyString {
	public static void main(String[] args) {
		String s1 = "geeksforgeeks";

		char[] s1Char = s1.toCharArray();
		char[] s2Char = new char[s1Char.length];

		// Shallow copy
		String s2 = s1;
		System.out.println("Shallow copy");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

		// Deep copy
		for (int i = 0; i < s1Char.length; i++)
			s2Char[i] = s1Char[i];
		System.out.println();
		System.out.println("Deep copy");
		System.out.println(s1Char.hashCode());
		System.out.println(s2Char.hashCode());

	}
}