package DSA.Bucket3._05_Create_Stack_Queue._01_Create_Stack_Q_UsingArray;

class _01_Stack_UsingArray {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX]; // Maximum size of Stack

	boolean isEmpty() {
		return (top < 0); 
	}

	_01_Stack_UsingArray() {
		top = -1;
	}

	boolean push(int x) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	int pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top--];
			return x;
		}
	}

	int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top];
			return x;
		}
	}

	void print() {
		for (int i = top; i > -1; i--) {
			System.out.print(" " + a[i]);
		}
	}
}

// Driver code
class Main {
	public static void main(String args[]) {
		_01_Stack_UsingArray s = new _01_Stack_UsingArray();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println("Top element is :" + s.peek());
		System.out.print("Elements present in stack :");
		s.print();
	}
}
