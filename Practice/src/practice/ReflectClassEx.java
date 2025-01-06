package practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReflectClassEx {
	public static void main(String[] args) {
		int[] arr = (int[]) Array.newInstance(int.class, 4); // Creating array : X[] arrayOfXType = (X[])
																// Array.newInstance(X.class, size);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < 4; i++) {
			Array.setInt(arr, i, i + 1); // Inserting elements into reflection array : Array.setX(X[], indexOfInsertion,
											// elementToBeInserted);
		}
		System.out.println();
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Array.getInt(arr, i)); // Array.getX(X[], indexOfRetrieval);
		}
	}

}
