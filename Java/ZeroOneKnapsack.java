public class ZeroOneKnapsack {
  // Time complexity: O(2^n) where n is number of items, Space complexity: O(1)
  public int knapsack(int[] weights, int[] values, int capacity) {
    return knapsack(weights, values, capacity, 0);
  }

  private int knapsack(int[] weights, int[] values, int capacity, int index) {
    if (index == weights.length) return 0;
    if (capacity - weights[i] < 0) return knapsack(weights, values, capacity, index + 1);
    return Math.max(knapsack(weights, values, capacity, index + 1),
            knapsack(weights, values, capacity - weights[index], index + 1) + values[index]);
  }

  // Time complexity: O(n*C), Space complexity: O(n*C) where n is number of items & C is capacity
  public int knapsackDP(int[] weights, int[] values, int capacity) {
    int[][] cache = new int[weights.length + 1][capacity + 1];
    for (int i = 1; i <= weights.length; i++) {
      for (int j = 1; j <= capacity; j++) {
        if (j < weights[i - 1]) cache[i][j] = cache[i - 1][j];
        else cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - weights[i - 1]] + values[i - 1]);
      }
    }
    return cache[weights.length][capacity];
  }
}
