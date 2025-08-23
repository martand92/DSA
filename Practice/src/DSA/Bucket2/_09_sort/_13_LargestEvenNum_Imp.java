package DSA.Bucket2._09_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/largest-even-number3821/1
public class _13_LargestEvenNum_Imp {

	public static void main(String[] args) {

		// String S = "1324";
		String S = "333";
		Character[] chrArr = new Character[S.length()]; // Non-Primitive
		StringBuilder str = new StringBuilder();
		String finalStr = new String();
		int i = 0;

		for (i = 0; i < chrArr.length; i++)
			chrArr[i] = S.charAt(i);

		Arrays.sort(chrArr, Collections.reverseOrder()); // 1234

		for (i = 0; i < chrArr.length; i++)
			str.append(chrArr);

		// Find even digit from end of character array : '2' is found
		for (i = chrArr.length - 1; i >= 0; i--) {
			if (Integer.valueOf(chrArr[i]) % 2 == 0)
				break;
		}

		if (i > -1 && i < chrArr.length - 1) // add index with even number to end of arr to make it even
			finalStr = str.substring(0, i) + str.substring(i + 1) + chrArr[i];

		else// if char arr doesn't have even digit, return as is
			finalStr = String.valueOf(str);

		System.out.println(finalStr);

	}
}
