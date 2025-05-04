package DSA.Bucket2._01_arrays._02_slidingWindow;

//https://www.youtube.com/watch?v=xtqN4qlgr8s
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
import java.util.HashMap;

//first calculate all sub arrays possible with <=3 chars -> x, then all subarrays possible with <=2 chars -> y
//then to get all subarrays possible with exact 3 chars, do x - y
public class _11_01_NumOfSubStrings {

	public static int countNumOfSubStrings(String s, int k) {

		int l = 0, count = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int r = 0; r < s.length(); r++) {

			hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);

			while (hm.size() > k) {

				hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);

				if (hm.get(s.charAt(l)) == 0)
					hm.remove(s.charAt(l));

				l++;
			}

			count += r - l + 1;
		}

		return count;
	}

	public static void main(String[] args) {
		//String s = "abc";
		// String s = "abcabc";
		String s = "bbacba";
		// Count of SubArrays with all 3 chars : Count of SubArrays with lesser or equal
		// to 3 chars - Count of SubArrays with lesser or equal to 2 chars
		System.out.println(countNumOfSubStrings(s, 3) - countNumOfSubStrings(s, 2));
	}

}
