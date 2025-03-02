package DSA.Bucket3._11_greedy;

public class _02_LemonadeChange {

	private static boolean checkLemonadeChange(int[] bills) {
		int five = 0, ten = 0;

		for (int i = 0; i < bills.length; i++) {

			if (bills[i] == 5)
				five++;

			else if (bills[i] == 10) {

				if (five == 0)
					return false;
				five--;
				ten++;

			} else {
				if (five >= 1 && ten >= 1) { // first 10s changes are given
					five--;
					ten--;
				} else if (five >= 3)// only if 10s changes are exhausted then 5s are given
					five -= 3;
				else
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// int[] bills = { 5, 5, 5, 10, 20 };
		int[] bills = { 5, 5, 10, 10, 20 };

		System.out.println(checkLemonadeChange(bills));
	}

}
