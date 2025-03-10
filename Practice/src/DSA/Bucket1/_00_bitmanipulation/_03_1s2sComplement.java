package DSA.Bucket1._00_bitmanipulation;

public class _03_1s2sComplement {

	public static String get1sComplement(String binary) {
		String res = "";
		for (int i = 0; i < binary.length(); i++)
			res += binary.charAt(i) == '1' ? '0' : '1'; // if 1 return 0 else 1

		return res;
	}

	/*
	 * First find 1s complimane to f binary number Second add 1 to previous result.
	 * 
	 */
	public static String get2sComplement(String binary) {

		String res = get1sComplement(binary);
		int i = 0;

		for (i = res.length() - 1; i >= 0; i--) {

			if (res.charAt(i) == '1') // By adding 1 to binary, you make 1 as 0 till you find 0 to make it as 1.
				res = res.substring(0, i) + '0' + res.substring(i + 1);

			else if (res.charAt(i) == '0') {
				res = res.substring(0, i) + '1' + res.substring(i + 1);
				break;
			}
		}

		if (i == -1) // if all the bits are set, Ex: 111 then doing +1 should result in 1000
			res = '1' + res;

		return res;
	}

	public static void main(String[] args) {

		String binary = "1101";

		System.out.println(get1sComplement(binary));
		System.out.println(get2sComplement(binary));
	}

}
