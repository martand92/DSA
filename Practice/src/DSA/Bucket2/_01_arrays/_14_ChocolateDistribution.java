package DSA.Bucket2._01_arrays;

//https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
import java.util.ArrayList;
import java.util.Collections;

public class _14_ChocolateDistribution {

	public static void main(String[] args) {

		int m = 5;
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(3);
		al.add(4);
		al.add(1);
		al.add(9);
		al.add(56);
		al.add(7);
		al.add(9);
		al.add(12);
		Collections.sort(al);

		int l = 0;
		int min = Integer.MAX_VALUE;

		for (int r = m - 1; r < al.size(); r++) { // Fixed sliding window
			min = Math.min(min, al.get(r) - al.get(l));
			l++;
		}

		System.out.println(min);
	}
}
