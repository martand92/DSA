package DSA.Bucket3._02_strings;

public class _01_PrintDiamond {
	public static void main(String[] args) {
		int width = 5;
		int index = 0;
		for (int i = 0; i < width; i = i + 2) {

			for (int k = index; k < width / 2; k++)
				System.out.print(" ");

			index++;

			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		index = 1;
		for (int i = 0; i < width; i = i + 2) {
			for (int k = 0; k < index; k++)
				System.out.print(" ");

			index++;
			for (int j = i + 1; j < width - 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}
}
