package DSA._11_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class _11_FractionalKnapsack {

	static class Item {
		int unitValue;
		int itemNumber;

		Item(int unitValue, int itemNumber) {
			this.unitValue = unitValue;
			this.itemNumber = itemNumber;
		}
	}

	public static int maxKnapsackVal(int[] values, int[] weights, int knapsackWeight) {

		Item[] items = new Item[values.length];
		for (int i = 0; i < items.length; i++)
			items[i] = new Item(values[i] / weights[i], i);

		Arrays.sort(items, new Comparator<Item>() {
			public int compare(Item a, Item b) {
				return b.unitValue - a.unitValue;
			}
		});

		int totalValue = 0;
		for (int i = 0; i < items.length; i++) {

			if (knapsackWeight >= weights[items[i].itemNumber]) {
				totalValue += values[items[i].itemNumber];
				knapsackWeight -= weights[items[i].itemNumber];

			} else { // if(knapsackWeight < itemWeight) then fraction scenario
				totalValue += (knapsackWeight * values[items[i].itemNumber]) / weights[items[i].itemNumber];
				break;
			}
		}

		return totalValue;
	}

	public static void main(String[] args) {
		int[] values = { 60, 100, 120 };
		int[] weights = { 10, 20, 30 };
		int knapsackWeight = 50;
		System.out.println(maxKnapsackVal(values, weights, knapsackWeight));
	}

}
