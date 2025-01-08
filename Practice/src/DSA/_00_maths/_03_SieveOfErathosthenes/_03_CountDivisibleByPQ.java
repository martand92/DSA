package DSA._00_maths._03_SieveOfErathosthenes;

//https://www.youtube.com/watch?v=Dg5D-k1rUgY
//https://www.hackerearth.com/problem/algorithm/monk-and-divisor-conundrum-56e0eb99/
public class _03_CountDivisibleByPQ {

	public static int gcd(int p, int q) {

		while (p > 0 && q > 0) {

			if (p > q)
				p = p % q;
			else
				q = q % p;

		}

		if (p == 0)
			return q;
		else
			return p;
	}

	public static int lcm(int p, int q) {

		return (p * q) / gcd(p, q);

	}

	public static int countDivisible(int[] arr, int p, int q) {

		int n = arr[arr.length - 1]; // store last element of arr as n as its largest in sorted

		// create hash counter to store frequency of each element in arr[]
		int[] hash = new int[n + 1];// have freq counter of arr of length largest ele of arr
		for (int i = 0; i < arr.length; i++)
			hash[arr[i]]++;

		int[] count = new int[n + 1];

		// now count no of elements that are in arr[] which are divisible by i
		// i.e, if i = 2, count elements in arr, that are divisible by i = 2,4,20
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j += i)
				count[i] += hash[j];
		}

		// Now count[p] has num of elements in arr that are divisible by p.
		// hence to get total count of elements in arr that are divisible by p & q
		return count[p] + count[q] - count[lcm(p, q)];
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 7, 4, 9, 20 }; // assuming sorted array
		int p = 4, q = 5; // count all nums from arr that are divisible by both 4 & 5
							// i.e, 4,5,20 are divisible by both 4 & 5

		System.out.println(countDivisible(arr, p, q));

	}

}
