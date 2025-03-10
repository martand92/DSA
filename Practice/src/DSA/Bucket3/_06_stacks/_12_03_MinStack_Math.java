package DSA.Bucket3._06_stacks;

import java.util.*;

//https://www.youtube.com/watch?v=NdDIaH91P0g

//Previous solution used custom class to store pair, so uses O(2N) SC
//This solution provides with SC:O(N)

//Intuition : When stack is empty, just insert first element and tag it as min.
//When element with higher value than current min is inserted, then curr min remains as is
//When element with lower val than currMin to be inserted, then update currMin to currVal & insert prevMin-currVal to stack. 
// prevMin-currVal is being inserted to stack because when currVal need to be popped, then currMin should revert back to prevMin

//Hence if currVal < currMin, then st.push(currMin - currVal) and currMin = currVal

//Need to get Min in given stack in O(1)

//Note : Striver has different formula for below
public class _12_03_MinStack_Math {
	int currMin = 0;

	public void push(Stack<Integer> st, int currVal) {

		if (st.isEmpty()) {
			currMin = currVal;
			st.push(currVal);
		}

		else if (currVal > currMin)
			st.push(currVal);

		else { // if currVal < currMin
			st.push(currMin - currVal);
			currMin = currVal;
		}
	}

	public int getMin() {
		return currMin;
	}

	public int top(Stack<Integer> st) {
		return st.peek();
	}

	public int pop(Stack<Integer> st) {

		if (st.peek() > currMin)
			return st.pop();

		else {
			int temp = currMin;
			currMin += st.peek();
			st.pop();
			return temp;
		}
	}

	public static void main(String[] args) {

		_12_03_MinStack_Math obj = new _12_03_MinStack_Math();

		Stack<Integer> st = new Stack<Integer>();
		obj.push(st, 12);
		obj.push(st, 15);
		obj.push(st, 10);

		System.out.println("Current min:" + obj.getMin()); // return 10
		System.out.println("Popped:" + obj.pop(st)); // 10 is taken out
		System.out.println("Stack top:" + obj.top(st)); // top is 15
		System.out.println("Current min:" + obj.getMin()); // this should return 12 though top is 15 in O(1)

	}
}

//TC : O(1)
//SC : O(N) 
