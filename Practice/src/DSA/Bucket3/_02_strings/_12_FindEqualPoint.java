package DSA.Bucket3._02_strings;

//https://practice.geeksforgeeks.org/problems/find-equal-point-in-string-of-brackets2542/1

/* Intuition
 * 
 * 
 * To Find index where numOfOpenBracesOnLeft = numberOfClosedBracesOnRight --> eq 1
 * Say initial index = numOfOpenBracesOnLeft + numOfClosedBracesOnLeft
 * numOfClosedBracesOnLeft = index - numOfOpenBracesOnLeft --> eq 3
 * 
 * totalClosedBraces  = numOfClosedBracesOnLeft + numOfClosedBracesOnRight
 * numOfClosedBracesOnRight = totalClosedBraces - numOfClosedBracesOnLeft --> eq 2
 * 
 * Now in eq 1 replace "numberOfClosedBracesOnRight" with eq 2
 * numOfOpenBracesOnLeft = totalClosedBraces - numOfClosedBracesOnLeft
 * numOfOpenBracesOnLeft = totalClosedBraces - (index - numOfOpenBracesOnLeft). From eq 3
 * Hence, index = totalClosedBraces
 * 
 */

public class _12_FindEqualPoint {

	public static void main(String[] args) {

		String str = "(()";

		char[] strArr = str.toCharArray();
		long index = 0;

		for (int i = 0; i < strArr.length; i++) {

			if (strArr[i] == ')')
				index++;
		}
		
		System.out.println(index);
	}

}
