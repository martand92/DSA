package practice;

import java.util.Arrays;

class AddTwoArrays {
	public static void main(String[] args) {
		int[][] oneArr = {{1,2} , {3,4}};
		int[][] twoArr = {{5,6} , {7,8}};
		int[][] sumArr = new int[2][2];
		
		for(int i = 0 ; i < oneArr.length; i++) {
			for(int j = 0 ; j < twoArr.length; j++) {
				sumArr[i][j] = oneArr[i][j] + twoArr[i][j];
				System.out.print(sumArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
