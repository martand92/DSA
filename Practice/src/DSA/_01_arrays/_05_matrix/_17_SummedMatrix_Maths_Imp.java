package DSA._01_arrays._05_matrix;

//https://practice.geeksforgeeks.org/problems/summed-matrix5834/1
public class _17_SummedMatrix_Maths_Imp {

	public static void main(String[] args) {

		int n = 4, q = 7, count = 0;

		if (q > 2 * n)
			count = 0;

		if (q > n + 1)
			count = (2 * n) - q + 1;

		else
			count = q - 1;

		System.out.println(count);

	}
}
