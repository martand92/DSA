package DSA.Bucket3._02_strings;

//Using iterative & recursion
public class _03_CopyString {

	public static int shallowCopy(String str) {
		String str2 = str;
		return str2.hashCode();
	}

	public static int deepCopy(String str) {

		char[] str2 = new char[str.length()];

		for (int i = 0; i < str.length(); i++)
			str2[i] = str.charAt(i);

		String strCopy = str2.toString();
		return strCopy.hashCode();
	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		System.out.println(shallowCopy(str) == str.hashCode());
		System.out.println(deepCopy(str) == str.hashCode());
	}
}