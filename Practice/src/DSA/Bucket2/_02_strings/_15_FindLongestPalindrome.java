package DSA.Bucket2._02_strings;

public class _15_FindLongestPalindrome {
	static String palindromeSeq = new String();

	public static void main(String[] args) throws Exception {

		String s = "geeksforgeeks";
		movingLeft(s);

		if (palindromeSeq.length() != s.length())
			movingRight(s);

		if (!palindromeSeq.isBlank())
			System.out.println(palindromeSeq);
		else
			System.out.println(s.substring(0, 1));

	}

	public static void movingLeft(String temp) throws Exception {
		String str = temp;
		while (temp.length() > 1) {
			String smid = null;
			String tempPalindromeSeq = "";

			char[] s1 = temp.substring(0, temp.length() / 2).toCharArray();
			char[] s2;

			if (temp.length() % 2 != 0) {
				smid = temp.substring(temp.length() / 2, temp.length() / 2 + 1);
				s2 = temp.substring(temp.length() / 2 + 1).toCharArray();

			} else
				s2 = temp.substring(temp.length() / 2).toCharArray();

			for (int i = 0; i < s1.length; i++) {
				if (s1[i] != s2[s2.length - 1 - i])
					tempPalindromeSeq = "";

				else {
					if (smid != null && tempPalindromeSeq.length() < String.valueOf(s1).substring(i).length() + 1
							+ String.valueOf(s2).substring(0, s2.length - i).length())
						tempPalindromeSeq = String.valueOf(s1).substring(i) + smid
								+ String.valueOf(s2).substring(0, s2.length - i);

					else if (tempPalindromeSeq.length() < String.valueOf(s1).substring(i).length()
							+ String.valueOf(s2).substring(0, s2.length - i).length())
						tempPalindromeSeq = String.valueOf(s1).substring(i)
								+ String.valueOf(s2).substring(0, s2.length - i);
				}
			}

			if (palindromeSeq.length() < tempPalindromeSeq.length())
				palindromeSeq = tempPalindromeSeq;
			else if (palindromeSeq.length() == tempPalindromeSeq.length()
					&& str.indexOf(tempPalindromeSeq) < str.indexOf(palindromeSeq))
				palindromeSeq = tempPalindromeSeq;

			temp = temp.substring(0, temp.length() - 1);

			if (palindromeSeq.length() > temp.length())
				break;
		}

	}

	public static void movingRight(String temp) throws Exception {
		String str = temp;
		temp = temp.substring(1, temp.length());

		while (temp.length() > 1) {
			String smid = null;
			String tempPalindromeSeq = "";

			char[] s1 = temp.substring(0, temp.length() / 2).toCharArray();
			char[] s2;

			if (temp.length() % 2 != 0) {
				smid = temp.substring(temp.length() / 2, temp.length() / 2 + 1);
				s2 = temp.substring(temp.length() / 2 + 1).toCharArray();

			} else
				s2 = temp.substring(temp.length() / 2).toCharArray();

			for (int i = 0; i < s1.length; i++) {
				if (s1[i] != s2[s2.length - 1 - i])
					tempPalindromeSeq = "";
				else {
					if (smid != null && tempPalindromeSeq.length() < String.valueOf(s1).substring(i).length() + 1
							+ String.valueOf(s2).substring(0, s2.length - i).length())
						tempPalindromeSeq = String.valueOf(s1).substring(i) + smid
								+ String.valueOf(s2).substring(0, s2.length - i);

					else if (tempPalindromeSeq.length() < String.valueOf(s1).substring(i).length()
							+ String.valueOf(s2).substring(0, s2.length - i).length())
						tempPalindromeSeq = String.valueOf(s1).substring(i)
								+ String.valueOf(s2).substring(0, s2.length - i);
				}
			}

			if (palindromeSeq.length() < tempPalindromeSeq.length())
				palindromeSeq = tempPalindromeSeq;
			else if (palindromeSeq.length() == tempPalindromeSeq.length()
					&& str.indexOf(tempPalindromeSeq) < str.indexOf(palindromeSeq))
				palindromeSeq = tempPalindromeSeq;

			temp = temp.substring(1, temp.length());

			if (palindromeSeq.length() > temp.length())
				break;

		}

	}

}
