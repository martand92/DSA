package DSA._09_graph.easy;

//https://practice.geeksforgeeks.org/problems/b64485d3994958cca8748991bb58668204b3e4c0/1
public class _08_MaxWeightNode_Imp {

	public static void main(String[] args) {

		int result = Integer.MIN_VALUE, resultIndex = 0;
		int[] Edge = { 2, 0, -1, 2 };
		int[] weight = new int[Edge.length];

		if (Edge.length == 1) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < Edge.length; i++) {
			if (Edge[i] != -1)
				weight[Edge[i]] += i;
		}

		for (int i = 0; i < weight.length; i++) {
			if (weight[i] >= result) {
				result = weight[i];
				resultIndex = i;
			}
		}

		System.out.println(resultIndex);

	}

}
