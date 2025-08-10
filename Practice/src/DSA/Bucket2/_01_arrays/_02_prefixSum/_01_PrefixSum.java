package DSA.Bucket2._01_arrays._02_prefixSum;
import java.util.Arrays;

public class _01_PrefixSum {

	public static void main(String[] args) {
		int[] arr = { 10, 4, 16, 20 };
		int[] prefixSum = new int[arr.length];

		prefixSum[0] = arr[0];

		for (int i = 1; i < arr.length; i++)
			prefixSum[i] = prefixSum[i - 1] + arr[i];

		System.out.println(Arrays.toString(prefixSum));

	}

}
