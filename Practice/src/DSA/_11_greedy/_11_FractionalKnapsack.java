package DSA._11_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class _11_FractionalKnapsack {

	static class Item {
		int unitValue;
		int value;
		int weight;

		Item(int unitValue, int value, int weight) {
			this.unitValue = unitValue;
			this.value = value;
			this.weight = weight;
		}
	}

	public static int maxKnapsackVal(int[] values, int[] weights, int knapsackWeight) {

		Item[] items = new Item[values.length];

		for (int i = 0; i < items.length; i++)
			items[i] = new Item(values[i] / weights[i], values[i], weights[i]);

		Arrays.sort(items, new Comparator<Item>() {
			public int compare(Item a, Item b) {
				return b.unitValue - a.unitValue;
			}
		});

		int totalValue = 0;

		for (int i = 0; i < items.length; i++) {

			if (knapsackWeight >= items[i].weight) {
				totalValue += items[i].value;
				knapsackWeight -= items[i].weight;

			} else { // if(knapsackWeight < itemWeight) then fraction scenario
				totalValue += (knapsackWeight * items[i].value) / items[i].weight;
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
