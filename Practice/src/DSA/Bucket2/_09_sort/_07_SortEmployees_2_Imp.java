package DSA.Bucket2._09_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/sorting-employees5907/1

class Node {
	int salary;
	String name;

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name + " " + this.salary;
	}

}

class SortBySalary implements Comparator<Node> {

	// Sorting in ascending order of salary
	public int compare(Node a, Node b) {

		if (a.salary == b.salary)
			return a.name.compareTo(b.name);

		return a.salary - b.salary;

	}
}

public class _07_SortEmployees_2_Imp {

	public static void main(String[] args) {

		ArrayList<Node> ar = new ArrayList<Node>();

		Node node = new Node();
		node.setName("xbnnskd");
		node.setSalary(50);
		ar.add(node);

		node = new Node();
		node.setName("geek");
		node.setSalary(50);
		ar.add(node);

		Collections.sort(ar, new SortBySalary());

		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

	}
}
