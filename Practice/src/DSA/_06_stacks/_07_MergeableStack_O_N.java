package DSA._06_stacks;

import java.util.Arrays;

public class _07_MergeableStack_O_N {

//	static Stack<Integer> s1 = new Stack<>();
//	static Stack<Integer> s2 = new Stack<>();

	final int MAX = 5;
	int top1 = -1, top2 = -1;
	int[] arr1 = new int[MAX];
	int[] arr2 = new int[MAX];

	public void push(int stNum, int d) {
		if (stNum == 1) {
			if (top1 == MAX - 1)
				System.out.println("Stack 1 Overflow");
			else
				arr1[++top1] = d;
		} else {
			if (top2 == MAX - 1)
				System.out.println("Stack 2 Overflow");
			else
				arr2[++top2] = d;
		}
	}

	public void pop(int stNum) {

		if (stNum == 1) {
			if (top1 < 0)
				System.out.println("Stack 1 Underflow");
			else {
				System.out.println(arr1[top1]);
				top1--;
			}
		} else {
			if (top2 < 0)
				System.out.println("Stack 2 Underflow");
			else {
				System.out.println(arr2[top2]);
				top2--;
			}
		}

	}

	public void mergeStack() {

		int[] arr = new int[arr1.length + arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			arr[i] = arr1[i];
		}

		for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
			arr[i] = arr2[i - arr1.length];
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {

		_07_MergeableStack_O_N s = new _07_MergeableStack_O_N();

		s.push(1, 1);
		s.push(1, 2);
		s.push(1, 3);
		s.push(1, 4);
		s.push(1, 5);
		s.push(2, 1);
		s.push(2, 2);
		s.push(2, 3);
		s.push(2, 4);
		s.push(2, 5);

		System.out.println(Arrays.toString(s.arr1));
		System.out.println(Arrays.toString(s.arr2));

		s.mergeStack();

	}

}
