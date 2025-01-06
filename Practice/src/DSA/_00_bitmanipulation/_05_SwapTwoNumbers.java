package DSA._00_bitmanipulation;

public class _05_SwapTwoNumbers {

	static int a = 13, b = 7;

	public static void swap() {
		a = a ^ b;
		b = a ^ b; // (a ^ b ^ b) -> a
		a = a ^ b; // (a ^ b ^ a) -> b
	}

	public static void main(String[] args) {
		System.out.println("a & b before swapping: " + a + "," + b);
		swap();
		System.out.println("swapping a & b : " + a + "," + b);
	}

}
