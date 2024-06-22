public class Solution {
    private int n;
    private long[,] dp;

    private long Solve(int[] nums, int index, bool flag) {
         if (index >= n) {
            return 0;
        }

        int fg = flag ? 1 : 0;
        if(dp[index, fg] != -1) {
            return dp[index, fg];
        }
        
        long skip = Solve(nums, index + 1, flag);

        long val = nums[index];
        if (!flag) {
            val = -val;
        }

        long take = val + Solve(nums, index + 1, !flag);

        dp[index, fg] = Math.Max(skip, take);

        return dp[index, fg];
        
    }

    public long MaxAlternatingSum(int[] nums) {
        n = nums.Length;
        dp = new long[n, 2];
        for (int i = 0; i < n; i++) {
            dp[i, 0] = -1;
            dp[i, 1] = -1;
        }


        return Solve(nums, 0, true);     
    }
}