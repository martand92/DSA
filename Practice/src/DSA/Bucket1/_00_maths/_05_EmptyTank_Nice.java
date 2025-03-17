package DSA.Bucket1._00_maths;

//https://practice.geeksforgeeks.org/problems/empty-the-tank3831/1

//Given a tank with capacity C liters which is completely filled in starting. 
//At the end of every day, tank is filled with L liters of water and in the case of overflow extra water is thrown out. 
//Now on i-th day i liters of water is taken out for drinking. 
//We need to find out the day at which tank will become empty the first time.

public class _05_EmptyTank_Nice {

	public static void main(String[] args) {

		long C = 5, l = 2;

		long ans = C;
		long i = 1;

		while (ans > 0) {

			ans = ans - i;

			if (ans <= 0)
				break;

			if (ans + l > C)
				ans = C;
			else
				ans = ans + l;

			i++;
		}

		System.out.println(i);
	}
}