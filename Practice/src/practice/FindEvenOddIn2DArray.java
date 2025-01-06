package practice;

public class FindEvenOddIn2DArray {

	public static void main(String[] args) {

		int[][] inArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		/*
		 * System.out.println("Please provide row*column value "); // only row value
		 * will also suffice int row = scanner.nextInt(); int column= scanner.nextInt();
		 */

		int evenCount = 0, oddCount = 0;

		/*
		 * for(int i = 0 ; i < row ; i++) { for(int j = 0 ; j < column ; j++) {
		 * inArr[i][j] = scanner.nextInt(); } }
		 */

		for (int i = 0; i < inArr.length; i++) {
			for (int j = 0; j < inArr[i].length; j++) {
				if (inArr[i][j] % 2 == 0)
					evenCount += 1;
				else
					oddCount += 1;
			}
		}
		System.out.println("Even Count : " + evenCount);
		System.out.println("Odd Count : " + oddCount);
	}

}
