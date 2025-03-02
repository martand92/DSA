package DSA.Bucket1._00_maths._01_ExtractionOfDigits;

public class _03_IsPalindrome {

	public static int getCount(int num, int count) {

		while (num > 0) {
			count++;
			num = num / 10;
		}

		return count;
	}

	public static void main(String[] args) {

		// int num = 123;
		int num = 1331;
		int originalNum = num;

		// if num has trailing 0s then remove them first
		while (num % 10 == 0)
			num = num / 10;

		int reverseNum = 0;

		int count = getCount(num, 0);

		while (num > 0) {
			reverseNum += (num % 10) * Math.pow(10, count - 1);
			num = num / 10;
			count--;
		}

		if (originalNum == reverseNum)
			System.out.println("Is Palindrome");
		else
			System.out.println("Is not a Palindrome");
	}
}
