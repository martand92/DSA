package DSA._00_bitmanipulation;

/*ASCII of 'A' in binary is 00001000001 and ASCII of 'a' in binary is 00001100001 
 * Hence the difference lies in 5th bit i.e, for 'A' 5th bit is set and for 'a' 5th bit is unset*/
public class _17_Upper_Lower_Conversion {

	public static char toLowerCase(char upperCaseChar) {
		/*
		 * as operations will be performed on binary rep of ASCII value of a char,
		 * upperCaseChar implicitly get casted to int type and performs bitwise
		 * operation
		 * 
		 * so the result of bitwise operation is also int, hence need to cast it back to
		 * char
		 */

		return (char) (upperCaseChar | (1 << 5));

		/*
		 * value of (1 << 5) is ''(space) Hence above line can also be written as
		 * upperCaseChar | ''
		 */
	}

	public static char toUpperCase(char lowerCaseChar) {

		return (char) (lowerCaseChar & (~(1 << 5)));
		/*
		 * value of ~(1 << 5) is '_'(underscore). Hence above line can also be written
		 * as lowerCaseChar & '_'
		 */
	}

	public static void main(String[] args) {

		char lowerCaseChar = 'b';
		char upperCaseChar = 'A';
		System.out.println(upperCaseChar + "->" + toLowerCase(upperCaseChar));
		System.out.println(lowerCaseChar + "->" + toUpperCase(lowerCaseChar));

	}
}
