package DSA.Bucket2._03_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/positive-negative-pair5209/1
public class _11_PosNegPair_ON_Hash {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 6, -2, -1, -3, 2, 7 };
		ArrayList<Integer> al = new ArrayList<Integer>();

		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hs.contains(Math.abs(arr[i]))) {
				al.add(-Math.abs(arr[i]));
				al.add(Math.abs(arr[i]));
			} else
				hs.add(Math.abs(arr[i]));
		}
		
		if (al.size() > 0)
			System.out.println(al);
		else
			System.out.println(0);
		
		

	}
}
