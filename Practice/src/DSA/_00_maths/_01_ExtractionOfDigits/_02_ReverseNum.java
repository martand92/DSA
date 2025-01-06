package DSA._00_maths._01_ExtractionOfDigits;

public class _02_ReverseNum {

	public static int getCount(int num, int count) {

		while (num > 0) {
			count++;
			num = num / 10;
		}

		return count;
	}

	public static void main(String[] args) {

		// int num = 9877; // ans : 7789
		int num = 10400; // ans : 401

		// if num has trailing 0s then remove them first
		while (num % 10 == 0)
			num = num / 10;

		int sum = 0;

		int count = getCount(num, 0);

		while (num > 0) {
			sum += (num % 10) * Math.pow(10, count - 1);
			num = num / 10;
			count--;
		}

		System.out.println("Reversed Number : " + sum);
	}
}
