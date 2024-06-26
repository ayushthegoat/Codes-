public class Solution {
    private int[, ] memo;
    private int Solve(int[] coins, int n, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || index >= n) {
            return int.MaxValue;
        }

        if(memo[index, amount] != -1) {
            return memo[index, amount];
        }

        int currVal = coins[index];

        // Include the current coin (don't move to next index)
        int take = Solve(coins, n, amount - currVal, index);
        if(take != int.MaxValue) {
            take += 1;
        }
        // Exclude the current coin (move to next index)
        int not = Solve(coins, n, amount, index + 1);

        return memo[index, amount] = Math.Min(take, not);
    }

    public int CoinChange(int[] coins, int amount) {
        int n = coins.Length;
        memo = new int[n + 1, amount + 1];
          for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                memo[i, j] = -1;
            }
        }
        int ans = Solve(coins, n, amount, 0);
        return  ans != int.MaxValue ? ans : -1;
    }
}