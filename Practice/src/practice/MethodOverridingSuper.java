package practice;

class ParentClass {
	void show() {
		System.out.println("Parent Show");
	}

}

class ChildClass extends ParentClass {
	@Override
	void show() {
		super.show(); //Calls parent method, super() refers to parent class Object
		System.out.print("Child Show");
	}
}

public class MethodOverridingSuper {
	public static void main(String[] args) {
		ParentClass obj = new ChildClass();
		obj.show();

	}
}
