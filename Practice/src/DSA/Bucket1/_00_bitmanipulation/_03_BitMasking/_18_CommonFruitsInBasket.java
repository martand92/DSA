package DSA.Bucket1._00_bitmanipulation._03_BitMasking;

public class _18_CommonFruitsInBasket {

	public static int countSetBits(int n) {

		int count = 0;

		while (n != 0) {
			n = n & n - 1;
			count++;
		}

		return count;
	}

	public static int commonFruits(int[] firstbasket, int[] secondbasket) {

		// bitmask type of fruits i.e, set bit pos representing type i.e, if type 2
		// fruit is present then set 2nd bit pos

		int n1 = 0, n2 = 0;

		for (int i : firstbasket)
			n1 |= (1 << i);

		for (int i : secondbasket)
			n2 |= (1 << i);

		// now do & of both baskets to check common type of fruit
		int commonSetBits = n1 & n2;

		// now count no of common fruits
		return countSetBits(commonSetBits);
	}

	public static void main(String[] args) {
		int[] basket1 = { 2, 3 }; // basket1 contains fruits of type 2 and 3
		int[] basket2 = { 0, 1, 2 }; // basket2 contains fruits of type 0,1 and 2
		int[] basket3 = { 1, 3 }; // basket3 contains fruits of type 1 and 3

		System.out.println(commonFruits(basket1, basket2));
		System.out.println(commonFruits(basket2, basket3));
		System.out.println(commonFruits(basket1, basket3));

	}

}
