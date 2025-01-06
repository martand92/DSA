package DSA._07_tree._03_heap.medium;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/game-with-string4100/1
public class _10_GameWithString {

	public static void main(String[] args) {

//		String s = "abccc";
//		int k = 1;

		String s = "fxnsmkasmlerxxoxhfwviluzttqqotdwrsqfcsxrddicaxahewemjyleudukxzgqrzvvrtmvwvxzuxiyvnngna";

		int k = 21, sum = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++)
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);

		Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.addAll(hm.values());

		while (k > 0) {
			pq.add(pq.poll() - 1);
			k--;
		}

		// then find square of every peek element
		while (!pq.isEmpty())
			sum += (pq.peek() * pq.poll());

		System.out.println(sum);

	}
}
