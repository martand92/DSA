package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.easy;

import java.util.*;

public class LL_22_CountPairsWhoseSumIsX_O_N_Nice {

	public static void main(String[] args) {

		LinkedList<Integer> head1 = new LinkedList<Integer>();
		LinkedList<Integer> head2 = new LinkedList<Integer>();

		int sum = 15;

		head1.add(1);
		head1.add(2);
		head1.add(3);
		head1.add(4);
		head1.add(5);
		head1.add(6);

		head2.add(11);
		head2.add(12);
		head2.add(13);

		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < head1.size(); i++)
			hs.add(sum - head1.get(i));

		int count = 0;

		for (int i = 0; i < head2.size(); i++) {
			if (!hs.add(head2.get(i)))
				count++;
		}

		System.out.println("Number of Pairs : " + count);
	}

}
