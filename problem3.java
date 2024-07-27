public class problem3 {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a 2D array to store the maximum value that can be obtained
        // dp[i][w] will hold the maximum value that can be obtained with the first i items and a capacity of w
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dp array from bottom up
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 6;
        System.out.println(knapsack(weights, values, capacity));  // Output: 55
    }
}