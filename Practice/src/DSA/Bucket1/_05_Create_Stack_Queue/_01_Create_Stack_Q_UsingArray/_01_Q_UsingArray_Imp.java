package DSA.Bucket1._05_Create_Stack_Queue._01_Create_Stack_Q_UsingArray;


//https://youtu.be/tqQ5fTamIN4?list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&t=1557
public class _01_Q_UsingArray_Imp {

	final int MAX;
	int size;
	int front, rear;
	int[] q;

	_01_Q_UsingArray_Imp(int MAX) {
		front = 0;
		rear = -1;
		this.MAX = 5;
		q = new int[MAX];
	}

	public void enqueue(int d) {
		if (size == MAX)
			System.out.println("Queue Overflow");

		else {
			// meaning rear has reached end but q still has capacity as elements might have
			// been dequeued at the start
			if (rear == q.length - 1)
				rear = -1; // point rear to -1 as it will become circular array and start adding elements
							// again from start

			q[++rear] = d;
			size++;
		}
	}

	public void dequeue() {
		if (size == 0)
			System.out.println("Queue Underflow");
		else {

			if (front == q.length - 1)// when size != 0 but front has reached end of q, then there should be new
										// elements inserted at start, so need to dequeue them. Circular array
				front = 0;

			System.out.println(q[front++]);
			size--;
		}

	}

	public void front() {
		System.out.println("front :" + q[front]);
	}

	public void rear() {
		System.out.println("rear :" + q[rear]);
	}

	public void isEmpty() {
		if (size != 0)
			System.out.println("Q is nonEmpty");
		else
			System.out.println("Q is Empty");
	}

	public void isFull() {
		if (size == MAX)
			System.out.println("Q is full");
		else
			System.out.println("Q is not full");
	}

	public static void main(String[] args) {
		_01_Q_UsingArray_Imp queue = new _01_Q_UsingArray_Imp(5);
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5); // Q full
		// System.out.println(Arrays.toString(queue.q));
		queue.dequeue();
		// System.out.println(Arrays.toString(queue.q));
		queue.front();
		queue.rear();
		queue.isEmpty();
		queue.isFull();
		queue.enqueue(5);
		//System.out.println(Arrays.toString(queue.q));
		queue.isFull();
	}
}
