package DSA._01_arrays._01_basic;

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

		int l = 0, r = m - 1;
		int diff = Integer.MAX_VALUE;

		while (r < al.size()) {
			diff = Math.min(diff, al.get(r) - al.get(l));
			l++;
			r++;
		}

		System.out.println(diff);
	}
}
