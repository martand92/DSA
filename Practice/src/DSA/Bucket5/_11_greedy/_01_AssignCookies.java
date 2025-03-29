package DSA.Bucket5._11_greedy;

import java.util.Arrays;

public class _01_AssignCookies {

	public static int content(int[] greedy, int[] s) {

		int sptr = 0, gptr = 0;

		Arrays.sort(greedy);
		Arrays.sort(s);

		while (sptr < s.length && gptr < greedy.length) {
			if (s[sptr] >= greedy[gptr]) {
				sptr++;
				gptr++;
			} else
				sptr++;
		}

		return gptr;
	}

	public static void main(String[] args) {

		int[] greedy = { 1, 5, 3, 3, 4 };
		int[] s = { 4, 2, 1, 2, 1, 3 };

		System.out.println(content(greedy, s));
	}
}