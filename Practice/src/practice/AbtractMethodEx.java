package practice;

abstract class AbtractMethodEx {
	abstract void m1();

	// concrete methods are still allowed in abstract classes
	void m2() {
		System.out.println("This is " + "a concrete method.");
	}
}

//concrete class B extending abstract class
class B extends AbtractMethodEx {
	// class B must override m1() method otherwise, compile-time exception will be
	// thrown
	@Override
	void m1() {
		System.out.println("B's " + "implementation of m1.");
	}
}

//public class AbstractMain {
//	public static void main(String[] args) {
//
//		// Creating object of Subclass and calling methods of Abstract class which are
//		// both concrete & abstract methods
//		B b = new B();
//		b.m1();
//		b.m2();
//
//		// Its possible to create reference to an abstract class so that it can be used
//		// to point to a subclass object
//		// Run time polymorphism : In run time it will resolve reference and can call
//		// methods of both super and sub classes
//		AbtractMethodEx abstractMethodObj = new B();
//		abstractMethodObj.m2();
//	}
//}