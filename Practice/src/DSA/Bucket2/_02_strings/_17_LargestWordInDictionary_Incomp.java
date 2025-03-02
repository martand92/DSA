package DSA.Bucket2._02_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

//https://www.geeksforgeeks.org/problems/find-largest-word-in-dictionary2430/1
public class _17_LargestWordInDictionary_Incomp {

	public static void main(String[] args) {
		ArrayList<String> d = new ArrayList<>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		d.add("b");
		d.add("a");
		d.add("c");

		String S = "abpcplea";

		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < d.size(); i++) {

			StringBuilder s = new StringBuilder(S);

			for (int j = 0; j < S.length(); j++) {
				int index = s.indexOf(String.valueOf(S.charAt(j)));

				if (index >= 0)
					s.deleteCharAt(index);

				if (s.length() == 0) {
					al.add(d.get(i));
					break;
				}
			}

		}

		Collections.sort(al, new Comparator<String>() {
			public int compare(String a, String b) {
				return b.length() - a.length();
			}
		});

		for (int j = 1; j < al.size(); j++) {
			if (al.get(0).length() != al.get(j).length()) {
				al.set(j, null);
			}
		}

		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			if (itr.next() == null)
				itr.remove();
		}

		Collections.sort(al);

		System.out.println(al.get(0));

	}

}
