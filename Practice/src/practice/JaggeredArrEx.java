package practice;

public class JaggeredArrEx {
	public static void main(String[] args) {
		
		//You are only declaring array here with rows 
		int[][] jagArr = new int[4][];
		
		//you also need to allocate memory for columns 
		for(int i = 0 ; i < jagArr.length ; i++) {
			jagArr[i] = new int[i + 1]; // jagArr[0] has 1 element memory allocated , jagArr[1] has 2 etc... 
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				jagArr[i][j] = j;
				System.out.print(jagArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
