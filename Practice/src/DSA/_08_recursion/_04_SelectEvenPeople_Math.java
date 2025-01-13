package DSA._08_recursion;

//https://practice.geeksforgeeks.org/problems/finding-position2223/1

/*Given input : 1,2,3,4,5,6,7,8,9,10 
 * in 1st iteration after selecting only even indices, left with values : 2,4,6,8,10
 * in 2nd iteration after selecting only even indices, left with values : 4,8
 * in 3rd iteration left with : 8 */

// Algo :
/* so in every iteration reducing by half the current input till we are left with single element
 * and everytime the reduction approaches towards towards 2^itr */

public class _04_SelectEvenPeople_Math {

	static int selectPeople(int n, int itr) {

		if (n == 1)
			return (int) (Math.pow(2, itr));

		return selectPeople(n / 2, itr + 1);
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println(selectPeople(n, 0));
	}
}
