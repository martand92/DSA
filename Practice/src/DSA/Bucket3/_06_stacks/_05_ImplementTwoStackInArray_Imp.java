package DSA.Bucket3._06_stacks;

import java.util.Arrays;

public class _05_ImplementTwoStackInArray_Imp {

	int[] arr = new int[10];
	int stackIndex1 = -1, stackIndex2 = 4;

	public void push(int stackNum, int d) {

		if (stackNum == 1) {

			if (stackIndex1 == arr.length / 2 - 1)
				System.out.println("Stack Overflow for Stack 1");

			else {
				stackIndex1++;
				arr[stackIndex1] = d;
			}

		} else {
			if (stackIndex2 == arr.length - 1)
				System.out.println("Stack Overflow for Stack 2");

			else {
				stackIndex2++;
				arr[stackIndex2] = d;
			}
		}
	}

	public int pop(int stackNum) {
		int a;
		if (stackNum == 1) {
			if (stackIndex1 < 0)
				System.out.println("Stack1 Underflow");

			a = arr[stackIndex1];
			stackIndex1--;

		} else {
			if (stackIndex2 < arr.length / 2 - 1)
				System.out.println("Stack2 Underflow");

			a = arr[stackIndex2];
			stackIndex2--;
		}
		return a;

	}

	public void isEmpty(int stackNum) {
		if (stackNum == 1) {
			if (stackIndex1 < 0)
				System.out.println("Stack1 is Empty");
			else
				System.out.println("Stack1 is not Empty");
		} else {
			if (stackIndex2 < arr.length / 2)
				System.out.println("Stack2 is Empty");
			else
				System.out.println("Stack2 is not Empty");
		}
	}

	public void isFull(int stackNum) {
		if (stackNum == 1) {
			if (stackIndex1 == arr.length / 2 - 1)
				System.out.println("Stack1 is Full");
			else
				System.out.println("Stack1 is not Full");
		} else {
			if (stackIndex2 == arr.length - 1)
				System.out.println("Stack2 is Full");
			else
				System.out.println("Stack2 is not Full");
		}

	}

	public static void main(String[] args) {
		_05_ImplementTwoStackInArray_Imp s = new _05_ImplementTwoStackInArray_Imp();
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
		
		System.out.println(Arrays.toString(s.arr));
		s.isFull(1);
		s.isFull(2);

		

		System.out.println(s.pop(1));
		s.isEmpty(1);
		s.isFull(1);

		System.out.println(s.pop(2));
		s.isEmpty(2);
		s.isFull(2);
		
		System.out.println(s.pop(1));
		System.out.println(s.pop(1));
		s.push(1, 3);
		s.push(1, 4);
		s.push(1, 5);
		s.isFull(1);
		s.push(1, 5);

	}

}
