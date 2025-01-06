package practice;

public class AbstractMain {
	public static void main(String args[]) {
		
		// Creating object of Subclass and calling methods of Abstract class which are both concrete & abstract methods 
		B b = new B();
		b.m1();
		b.m2();
		
		//Its possible to create reference to an abstract class so that it can be used to point to a subclass object
		//Run time polymorphism : In run time it will resolve reference and can call methods of both super and sub classes
		AbtractMethodEx abstractMethodObj = new B ();
		abstractMethodObj.m2();
	}
}