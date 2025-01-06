package DSA._10_dynamicprogramming._15_String_EditDistance;

public class _01_Recursion {

	public static int countMinOperations(String s1, String s2, int index1, int index2) {

		if (index1 < 0)
			return index2 + 1;
		if (index2 < 0)
			return index1 + 1;

		if (s1.charAt(index1) == s2.charAt(index2))
			return 0 + countMinOperations(s1, s2, index1 - 1, index2 - 1);

		else {
			int insertCount = 1 + countMinOperations(s1, s2, index1, index2 - 1);
			int deleteCount = 1 + countMinOperations(s1, s2, index1 - 1, index2);
			int replaceCount = 1 + countMinOperations(s1, s2, index1 - 1, index2 - 1);

			int minTemp = Math.min(insertCount, deleteCount);
			return Math.min(minTemp, replaceCount);
		}
	}

	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "ros";

		System.out.println(countMinOperations(s1, s2, s1.length() - 1, s2.length() - 1));
	}
}
//TC : O(3^n * 3^m)
//SC : O(N+M) 