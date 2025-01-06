package DSA._01_arrays._07_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/sorting-employees5907/1
class Node1 {
	int salary;
	String name;

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class _07_SortEmployees_1_Imp {

	void sortRecords(Node1 arr[]) {

		Arrays.sort(arr, new Comparator<Node1>() {
			public int compare(Node1 o1, Node1 o2) {

				if (o1.salary == o2.salary)
					return o1.name.compareTo(o2.name);

				return o1.salary - o2.salary;
			}
		});

	}

	public static void main(String[] args) {

		Node1[] arr = new Node1[2];

		Node1 node = new Node1();
		node.setName("xbnnskd");
		node.setSalary(50);
		arr[0] = node;

		node = new Node1();
		node.setName("geek");
		node.setSalary(100);
		arr[1] = node;

		_07_SortEmployees_1_Imp obj = new _07_SortEmployees_1_Imp();
		obj.sortRecords(arr);

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i].name + " " + arr[i].salary);

	}
}
