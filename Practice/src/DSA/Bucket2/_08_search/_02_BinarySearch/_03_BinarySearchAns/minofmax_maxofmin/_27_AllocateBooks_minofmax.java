package DSA.Bucket2._08_search._02_BinarySearch._03_BinarySearchAns.minofmax_maxofmin;

//https://www.naukri.com/code360/problems/allocate-books_1090540
//https://www.youtube.com/watch?v=Z0hwjftStI4
public class _27_AllocateBooks_minofmax {

	public static int maxPagesOfBook(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++)
			max = Math.max(max, arr[i]);

		return max;
	}

	public static int sumOfAllPages(int[] arr) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		return sum;
	}

	public static boolean isPossible(int[] arr, int noOfStudents, int minPages) {

		// here basically trying to find if all the students can be allocated books with
		// minPages

		int initialStudentPages = 0;

		for (int i = 0; i < arr.length; i++) {

			if ((initialStudentPages + arr[i]) <= minPages)
				initialStudentPages += arr[i];
			else {
				noOfStudents--;
				initialStudentPages = arr[i];
			}
		}

		if (noOfStudents > 0)
			return true;
		else
			return false;

	}

	public static int sumOfMinPages(int[] arr, int noOfStudents) {

		// if there is 1 student and n books, then he can hold 1 book with atleast max
		// pages as start and at max he can hold books that's sum of all the pages of
		// all books
		int l = maxPagesOfBook(arr), r = sumOfAllPages(arr), mid = 0;

		while (l <= r) {

			// here mid indicates min no of max pages that that can be allocated to all
			// students
			mid = (l + r) / 2;

			if (isPossible(arr, noOfStudents, mid))
				r = mid - 1;
			else
				l = mid + 1;
		}

		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 34, 67, 90 };// no of pages in each book
		int m = 2;// no of students

		System.out.println(sumOfMinPages(arr, m));
	}

}
