package DSA._08_recursion;

//https://practice.geeksforgeeks.org/problems/finding-position2223/1
public class _04_SelectEvenPeople_Math {

	static int find(int n, int i) {
		if (n == 1)
			return (int) (Math.pow(2, i));

		return find(n / 2, i + 1);
	}

	static int selectPeople(int n) {
		return find(n, 0);
	}

	public static void main(String[] args) {
		System.out.println(selectPeople(2));
	}

}
