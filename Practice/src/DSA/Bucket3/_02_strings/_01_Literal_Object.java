package DSA.Bucket3._02_strings;

public class _01_Literal_Object {
	
	//Here String is created as Literal in Constant pool
	public static void asLiteral() {
		String b = "TAT";
		String a = null;
		System.out.println(a);
		System.out.println(b);
	}
	
	//Here String is created as Object in Heap with new keyword
	public static void asObject() {
		String a = new String();
		String b = new String("TAT");
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		
		asLiteral();
		asObject();
	}
}
