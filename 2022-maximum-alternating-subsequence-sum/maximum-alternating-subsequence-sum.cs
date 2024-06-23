public class Solution {
    public long MaxAlternatingSum(int[] nums) {
        long[,] dp = new long[nums.Length + 1, 2];


        for(int i = 1; i<=nums.Length; i++){
            //for even length subsequence
            dp[i, 0] = Math.Max(dp[i - 1, 1] - nums[i - 1], dp[i - 1, 0]);

            //for odd length subsequence
            dp[i, 1] = Math.Max(dp[i - 1, 0] + nums[i - 1], dp[i - 1, 1]);
        }

        return Math.Max(dp[nums.Length, 0], dp[nums.Length, 1]);
    }
}