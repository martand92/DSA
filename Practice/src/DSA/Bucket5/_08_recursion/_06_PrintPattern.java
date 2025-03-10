package DSA.Bucket5._08_recursion;

//https://practice.geeksforgeeks.org/problems/print-pattern3549/1
public class _06_PrintPattern {

	public void printPattern(int n) {

		if (n <= 0) {
			System.out.println(n);
			return;
		}

		System.out.print(n + " ");
		printPattern(n - 5);
		System.out.print(n + " ");
	}

	public static void main(String[] args) {
		_06_PrintPattern sol = new _06_PrintPattern();
		sol.printPattern(10);
	}
}
