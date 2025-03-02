package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.easy;

import java.util.*;

public class LL_25_BinaryToDecimalLL {

	LinkedList<Integer> head = new LinkedList<Integer>();

	public void DecimalValue() {

		long sum = 0;

		for (int i = 0; i < head.size(); i++)
			sum += head.get(i) * (Math.pow(2, head.size() - 1 - i) % 1000000007);

		System.out.println(sum);
	}

	public static void main(String[] args) {

		LL_25_BinaryToDecimalLL lList = new LL_25_BinaryToDecimalLL();
		lList.head.add(1);
		lList.head.add(1);
		lList.head.add(0);// 110 -> 1 * 2^2 + 1 * 2^1 + 0 * 2^0 = 6

		lList.DecimalValue();
	}

}
