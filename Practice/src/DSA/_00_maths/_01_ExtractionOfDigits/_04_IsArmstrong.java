package DSA._00_maths._01_ExtractionOfDigits;

//Armstrong num : if sum of cube of every digit of a num = num itself
//Ex: 371 = 3^3 + 7^3 + 1^3 = 371

public class _04_IsArmstrong {

	public static void main(String[] args) {
		// int num = 35;
		int num = 371;
		int originalNum = num;
		int sum = 0;

		while (num > 0) {
			sum += Math.pow(num % 10, 3);
			num = num / 10;
		}

		if (originalNum == sum)
			System.out.println("Is Armstrong number");
		else
			System.out.println("Is not a Armstrong number");
	}
}
