package DSA.Bucket1._00_bitmanipulation._03_BitMasking;

import java.util.ArrayList;

//https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/xor-challenge-2420f189/
//https://youtu.be/0r2kXRQZ_lA?list=PLauivoElc3giVROwL-6g9hO-LlSen_NaV&t=1324

//given C = A ^ B, find a & b whose product is max  
public class _19_XORChallenge {

	public static int findMaxProd(int a, int b, int c) {

		int ans = 0;

		// first count no of bits in c. i.e, position of left most set bit(most
		// significant bit) as you shouldn't fo for all 32 bits
		int cBitCnt = (int) Math.log(c) + 1;
		ArrayList<Integer> setBitsPos = new ArrayList<Integer>();

		// c is result of a^b
		// if bit in c is 0, then a and b will either have 0^0 or 1^1. Since there is
		// need to find max of a*b, consider 1 & 1 for a & b at this pos

		// When c has set bit, a and b will either have value as 0 and 1 or 1 and 0 at
		// that pos. so consider both combination and derive max a*b value

		for (int i = 0; i <= cBitCnt; i++) { // loop upto most significant bit

			if ((c & (1 << i)) == 0) {// c has unset bit at ith pos
				a = a | (1 << i);
				b = b | (1 << i);

			} else // if c has set bit, then store its pos
				setBitsPos.add(i);

		}

		// Next logic is similar to power set bit masking where all permutations of set
		// bits in c should be tried with set & unset bits in a & b at that pos

		// From stored set bits in c, create bit mask with 2^setBitsCnt by having set &
		// unset values
		for (int i = 0; i < (1 << setBitsPos.size()); i++) { // this is same as i < 2^setBitsPos.size()

			int a1 = a, b1 = b;

			// as need to try both set and unset bits at pos i, below code says
			// if mask pos is set, then set a and keep b unset at this pos
			// else if mask pos is unset, then unset a and keep b set at this pos
			for (int j = 0; j < setBitsPos.size(); j++) {

				int orgPosOfSetBit = setBitsPos.get(j);// for 13 : 1101 -> 3,2,0 bit pos where its set

				if ((i & (1 << j)) != 0)
					a1 = a1 | (1 << orgPosOfSetBit);
				else
					b1 = b1 | (1 << orgPosOfSetBit);
			}

			ans = Math.max(ans, a1 * b1);
		}

		return ans;
	}

	public static void main(String[] args) {

		int c = 13;

		// a & b initialized to 0
		int a = 0, b = 0;

		// a and b where ^ is c and a * b should be max
		System.out.println(findMaxProd(a, b, c));
	}
}