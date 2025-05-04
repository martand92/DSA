package DSA.Bucket2._01_arrays._03_matrix;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1
public class _22_UniqueRowsInBooleanMatrix_imp {

	public static void main(String[] args) {

		int a[][] = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 } };

		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al1;
		@SuppressWarnings("rawtypes")
		HashSet<ArrayList> hs = new HashSet<ArrayList>();

		for (int i = 0; i < a.length; i++) {
			al1 = new ArrayList<Integer>(); // every time al need to be instantiated because if i clear al1 after adding
											// to al then entry in al is also cleared, looks like reference exists.
			for (int j = 0; j < a[0].length; j++)
				al1.add(a[i][j]);

			if (hs.add(al1))
				al.add(al1);
			
			//System.out.println(Arrays.deepToString(a));

			// al1.clear(); // this did not work so had to instantiate everytime

		}

	}
}
