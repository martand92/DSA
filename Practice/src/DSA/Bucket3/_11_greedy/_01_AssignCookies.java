package DSA.Bucket3._11_greedy;

import java.util.Arrays;

public class _01_AssignCookies {

	public static int content(int[] greedy, int[] s) {

		int l = 0, r = 0;

		Arrays.sort(greedy);
		Arrays.sort(s);

		while (l < s.length && r < greedy.length) {
			if (s[l] >= greedy[r]) {
				r++;
				l++;
			} else
				l++;
		}

		return r;
	}

	public static void main(String[] args) {
		int[] greedy = { 1, 5, 3, 3, 4 };
		int[] s = { 4, 2, 1, 2, 1, 3 };

		System.out.println(content(greedy, s));
	}

}
