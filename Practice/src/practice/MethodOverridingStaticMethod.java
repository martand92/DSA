package practice;

public class MethodOverridingStaticMethod {
	// Static method in base class which will be hidden in subclass
	static void m1() {
		System.out.println("From parent " + "static m1()");
	}

	// Non-static method which will be overridden in derived class
	void m2() {
		System.out.println("From parent " + "non-static(instance) m2()");
	}
}

class Child extends MethodOverridingStaticMethod {
	// This method hides m1() in Parent, doesn't override it
	static void m1() {
		System.out.println("From child static m1()");
	}

	// This method overrides m2() in Parent
	@Override
	public void m2() {
		System.out.println("From child " + "non-static(instance) m2()");
	}
}

class MainClass {
	public static void main(String[] args) {
		MethodOverridingStaticMethod obj1 = new Child();

		// As per overriding rules this should call to class Child static overridden
		// method. Since static method can not be overridden, it calls Parent's m1()
		// From parent static m1()
		obj1.m1();

		// Here overriding works and Child's m2() is called
		// From child non-static(instance) m2()
		obj1.m2();
	}
}
