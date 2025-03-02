package DSA.Bucket2._02_strings;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
public class _05_LongestCommonPrefix {

	public static void main(String[] args) {

		String[] arr = { "geeksforgeeks", "geeks", "geek", "geezer" };

		// String[] arr = { "hello", "world" };

//		String[] arr = {
//				"haufsfkrmibigeiwtpljyrpgtbcqjcasdvxxakoosrzyxjwsyhbxasfttkmeomwtjwqmggayyzyviwojergeknafxmmoa",
//				"hkgywmgwmeymcijqrphzvrnvzmjlamviwciuq", "sfvqrxbcpsrwsnqhkptwcwixggzqaqguvdloaorrgio", "xgh",
//				"xdgzbqwhwyzyqfunj" };

//      1st Approach
//		int initCount = arr[0].length(); // instead of selecting first element of String array, better approach is to select element with least string length so that other elements cab be compared with this with less further iterations
//		// String a = arr[0];
//		char[] initElement = arr[0].toCharArray();
//
//		for (int i = 1; i < arr.length; i++) {
//			int count = 0;
//			if (initCount > 0) {
//				
//				char[] temp = arr[i].toCharArray();
//				for (int j = 0; j < (temp.length < arr[0].length() ? temp.length : arr[0].length()); j++) { // No need to check current String length if above smallest string is initially considered
//					if (initElement[j] == temp[j]) {
//						count++;
//					} else
//						break;
//
//				}
//			} else 
//				break;
//
//			if (initCount > count)
//				initCount = count;
//
//		}
//		if (initCount > 0)
//			System.out.println(arr[0].substring(0, initCount));
//		else
//			System.out.println("-1");

		// 2nd Approach : Sorting String sorts lexiographically making first element
		// least
		// different and last element most different
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		char[] arr1 = arr[0].toCharArray();
		char[] arr2 = arr[arr.length - 1].toCharArray();

		int i = 0, j = 0, count = 0;

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] == arr2[j])
				count++;
			else
				break;

			i++;
			j++;
		}

		System.out.println(count > 0 ? count : -1);

	}
}
