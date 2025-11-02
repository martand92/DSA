package DSA.Bucket3._05_queue;

import java.util.*;
import java.util.Queue;

//print all binary forms of decimal nums from 1 -> n
public class _12_PrintBinaryNumber_Nice {

	public static void main(String[] args) {

		int n = 5;
		ArrayList<String> al = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();

		q.add("1");
		String a;

		int i = 0;

		while (i < n) {
			a = q.poll();
			al.add(a);
			q.add(a + "0");
			q.add(a + "1");
			i++;
		}
		// System.out.println(q);
		System.out.println(al);

	}
}
