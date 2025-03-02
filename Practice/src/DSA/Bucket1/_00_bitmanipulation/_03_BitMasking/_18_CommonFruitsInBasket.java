package DSA.Bucket1._00_bitmanipulation._03_BitMasking;

public class _18_CommonFruitsInBasket {

	public static int countNumOfSetBits(int n) {

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

		for (int i = 0; i < firstbasket.length; i++)
			n1 |= (1 << firstbasket[i]);

		for (int i = 0; i < secondbasket.length; i++)
			n2 |= (1 << secondbasket[i]);

		// now do & of both baskets to check common type of fruit i.e, common set bit
		int commonSetBits = n1 & n2;

		// now count no of common fruits between given 2 baskets represented by set bits
		return countNumOfSetBits(commonSetBits);
	}

	public static void main(String[] args) {
		// int[] fruits = { 0, 1, 2, 3 }; // types of fruits present
		int[] basket1 = { 2, 3 }; // basket1 contains fruits of type 2 and 3
		int[] basket2 = { 0, 1, 2 }; // basket2 contains fruits of type 0,1 and 2
		int[] basket3 = { 1, 3 }; // basket3 contains fruits of type 1 and 3

		System.out.println(commonFruits(basket1, basket2));
		System.out.println(commonFruits(basket2, basket3));
		System.out.println(commonFruits(basket1, basket3));

	}

}
