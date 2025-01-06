package DSA._00_maths._01_ExtractionOfDigits;

public class _01_CountDigits {

	public static void main(String[] args) {

		int num = 9877, count = 0;

		while (num > 0) {
			count++;
			num = num / 10;
		}

		System.out.println("Number of Digits : " + count);
	}
}
